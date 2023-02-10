package earth.terrarium.ad_astra.common.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import com.teamresourceful.resourcefullib.common.codecs.yabn.YabnOps;
import com.teamresourceful.resourcefullib.common.utils.readers.ByteBufByteReader;
import com.teamresourceful.resourcefullib.common.yabn.YabnParser;
import com.teamresourceful.resourcefullib.common.yabn.base.YabnElement;
import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.client.AdAstraClient;
import earth.terrarium.ad_astra.common.networking.NetworkHandling;
import earth.terrarium.ad_astra.common.networking.packet.client.RequestPlanetDataPacket;
import earth.terrarium.ad_astra.common.networking.packet.client.ToggleDistributorPacket;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;

import java.util.*;

public class PlanetData extends SimpleJsonResourceReloadListener {

    private static final Set<Planet> PLANETS = new HashSet<>();
    private static final Map<ResourceKey<Level>, Planet> LEVEL_TO_PLANET = new HashMap<>();
    private static final Map<ResourceKey<Level>, Planet> ORBIT_TO_PLANET = new HashMap<>();
    private static final Set<ResourceKey<Level>> PLANET_LEVELS = new HashSet<>();
    private static final Set<ResourceKey<Level>> ORBITS_LEVELS = new HashSet<>();
    private static final Set<ResourceKey<Level>> OXYGEN_LEVELS = new HashSet<>();

    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public PlanetData() {
        super(GSON, "planet_data/planets");
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> objects, ResourceManager resourceManager, ProfilerFiller profiler) {
        profiler.push("Ad Astra Planet Deserialization");
        List<Planet> planets = new ArrayList<>();

        for (Map.Entry<ResourceLocation, JsonElement> entry : objects.entrySet()) {
            JsonObject jsonObject = GsonHelper.convertToJsonObject(entry.getValue(), "planet");
            Planet newPlanet = Planet.CODEC.parse(JsonOps.INSTANCE, jsonObject).getOrThrow(false, AdAstra.LOGGER::error);
            planets.removeIf(planet -> planet.level().equals(newPlanet.level()));
            planets.add(newPlanet);
        }

        PlanetData.updatePlanets(planets);
        profiler.pop();
    }

    public static void updatePlanets(Collection<Planet> planets) {
        clear();
        for (Planet planet : new HashSet<>(planets)) {
            PLANETS.add(planet);
            LEVEL_TO_PLANET.put(planet.level(), planet);
            ORBIT_TO_PLANET.put(planet.orbitWorld(), planet);
            PLANET_LEVELS.add(planet.level());
            ORBITS_LEVELS.add(planet.orbitWorld());
            if (planet.hasOxygen()) {
                OXYGEN_LEVELS.add(planet.level());
            }
        }
    }

    private static void clear() {
        PLANETS.clear();
        LEVEL_TO_PLANET.clear();
        ORBIT_TO_PLANET.clear();
        ORBITS_LEVELS.clear();
        OXYGEN_LEVELS.clear();
    }

    public static void writePlanetData(FriendlyByteBuf buf) {
        YabnElement element = Planet.CODEC.listOf().encodeStart(YabnOps.COMPRESSED, PlanetData.planets().stream().toList())
                .getOrThrow(false, AdAstra.LOGGER::error);
        buf.writeBytes(element.toData());
    }

    public static void readPlanetData(FriendlyByteBuf buf) {
        try {
            PlanetData.updatePlanets(Planet.CODEC.listOf().parse(YabnOps.COMPRESSED, YabnParser.parse(new ByteBufByteReader(buf)))
                    .result()
                    .orElseThrow());
        } catch (Exception e) {
            AdAstra.LOGGER.error("Failed to parse planet data!");
            e.printStackTrace();
            PlanetData.updatePlanets(List.of());
        }
    }

    public static Set<Planet> planets() {
        return PLANETS;
    }

    public static Optional<Planet> getPlanetFromLevel(ResourceKey<Level> level) {
        return Optional.ofNullable(LEVEL_TO_PLANET.get(level));
    }

    public static Optional<Planet> getPlanetFromOrbit(ResourceKey<Level> level) {
        return Optional.ofNullable(ORBIT_TO_PLANET.get(level));
    }

    public static boolean isOrbitLevel(ResourceKey<Level> level) {
        return ORBITS_LEVELS.contains(level);
    }

    public static boolean isPlanetLevel(Level level) {
        if (level.isClientSide && !AdAstraClient.hasUpdatedPlanets) {
            NetworkHandling.CHANNEL.sendToServer(new RequestPlanetDataPacket());
            AdAstraClient.hasUpdatedPlanets = true;
        }
        return PLANET_LEVELS.contains(level.dimension());
    }

    public static boolean isOxygenated(ResourceKey<Level> level) {
        return OXYGEN_LEVELS.contains(level);
    }
}
