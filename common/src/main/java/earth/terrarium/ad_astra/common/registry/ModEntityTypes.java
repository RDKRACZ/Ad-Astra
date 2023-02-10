package earth.terrarium.ad_astra.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.common.entity.SpacePainting;
import earth.terrarium.ad_astra.common.entity.mob.*;
import earth.terrarium.ad_astra.common.entity.projectile.IceSpit;
import earth.terrarium.ad_astra.common.entity.vehicle.*;
import earth.terrarium.ad_astra.common.util.PlatformUtils;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.level.levelgen.Heightmap;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ModEntityTypes {
    public static final ResourcefulRegistry<EntityType<?>> ENTITY_TYPES = ResourcefulRegistries.create(Registry.ENTITY_TYPE, AdAstra.MOD_ID);

    // Mobs
    public static final RegistryEntry<EntityType<Lunarian>> LUNARIAN = ENTITY_TYPES.register("lunarian", () -> EntityType.Builder.of(Lunarian::new, MobCategory.CREATURE).sized(0.75f, 2.5f).build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<CorruptedLunarian>> CORRUPTED_LUNARIAN = ENTITY_TYPES.register("corrupted_lunarian", () -> EntityType.Builder.of(CorruptedLunarian::new, MobCategory.MONSTER).sized(0.6f, 2.4f).build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<StarCrawler>> STAR_CRAWLER = ENTITY_TYPES.register("star_crawler", () -> EntityType.Builder.of(StarCrawler::new, MobCategory.MONSTER).sized(1.3f, 1.0f).build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<MartianRaptor>> MARTIAN_RAPTOR = ENTITY_TYPES.register("martian_raptor", () -> EntityType.Builder.of(MartianRaptor::new, MobCategory.MONSTER).sized(0.75f, 2.0f).build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<Pygro>> PYGRO = ENTITY_TYPES.register("pygro", () -> EntityType.Builder.of(Pygro::new, MobCategory.MONSTER).sized(0.6f, 1.8f).build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<ZombifiedPygro>> ZOMBIFIED_PYGRO = ENTITY_TYPES.register("zombified_pygro", () -> EntityType.Builder.of(ZombifiedPygro::new, MobCategory.MONSTER).sized(0.6f, 1.8f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<PygroBrute>> PYGRO_BRUTE = ENTITY_TYPES.register("pygro_brute", () -> EntityType.Builder.of(PygroBrute::new, MobCategory.MONSTER).sized(0.6f, 1.8f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<Mogler>> MOGLER = ENTITY_TYPES.register("mogler", () -> EntityType.Builder.of(Mogler::new, MobCategory.MONSTER).sized(1.4f, 1.4f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<ZombifiedMogler>> ZOMBIFIED_MOGLER = ENTITY_TYPES.register("zombified_mogler", () -> EntityType.Builder.of(ZombifiedMogler::new, MobCategory.MONSTER).sized(1.4f, 1.4f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<LunarianWanderingTrader>> LUNARIAN_WANDERING_TRADER = ENTITY_TYPES.register("lunarian_wandering_trader", () -> EntityType.Builder.of(LunarianWanderingTrader::new, MobCategory.CREATURE).sized(0.6f, 1.95f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<SulfurCreeper>> SULFUR_CREEPER = ENTITY_TYPES.register("sulfur_creeper", () -> EntityType.Builder.of(SulfurCreeper::new, MobCategory.MONSTER).sized(0.6f, 1.7f).clientTrackingRange(8).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<GlacianRam>> GLACIAN_RAM = ENTITY_TYPES.register("glacian_ram", () -> EntityType.Builder.of(GlacianRam::new, MobCategory.CREATURE).sized(0.9f, 1.3f).clientTrackingRange(10).build(AdAstra.MOD_ID));

    // Machines
    public static final RegistryEntry<EntityType<RocketTier1>> TIER_1_ROCKET = ENTITY_TYPES.register("tier_1_rocket", () -> EntityType.Builder.<RocketTier1>of(RocketTier1::new, MobCategory.MISC).sized(1.1f, 4.6f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<RocketTier2>> TIER_2_ROCKET = ENTITY_TYPES.register("tier_2_rocket", () -> EntityType.Builder.<RocketTier2>of(RocketTier2::new, MobCategory.MISC).sized(1.1f, 4.8f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<RocketTier3>> TIER_3_ROCKET = ENTITY_TYPES.register("tier_3_rocket", () -> EntityType.Builder.<RocketTier3>of(RocketTier3::new, MobCategory.MISC).sized(1.1f, 5.5f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<RocketTier4>> TIER_4_ROCKET = ENTITY_TYPES.register("tier_4_rocket", () -> EntityType.Builder.<RocketTier4>of(RocketTier4::new, MobCategory.MISC).sized(1.1f, 7.0f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<Rover>> TIER_1_ROVER = ENTITY_TYPES.register("tier_1_rover", () -> EntityType.Builder.of(Rover::new, MobCategory.MISC).sized(1.8f, 1.5f).fireImmune().build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<Lander>> LANDER = ENTITY_TYPES.register("lander", () -> EntityType.Builder.of(Lander::new, MobCategory.MISC).sized(1.2f, 2.0f).fireImmune().build(AdAstra.MOD_ID));

    // Other
    public static final RegistryEntry<EntityType<SpacePainting>> SPACE_PAINTING = ENTITY_TYPES.register("space_painting", () -> EntityType.Builder.of(SpacePainting::new, MobCategory.MISC).sized(0.5f, 0.5f).clientTrackingRange(10).updateInterval(Integer.MAX_VALUE).build(AdAstra.MOD_ID));
    public static final RegistryEntry<EntityType<IceSpit>> ICE_SPIT = ENTITY_TYPES.register("ice_spit", () -> EntityType.Builder.<IceSpit>of(IceSpit::new, MobCategory.MISC).sized(0.5f, 0.5f).build(AdAstra.MOD_ID));

    public static void registerSpawnPlacements() {
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.LUNARIAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Lunarian::checkMobSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.CORRUPTED_LUNARIAN.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CorruptedLunarian::checkMonsterSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.STAR_CRAWLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, StarCrawler::checkMonsterSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.MARTIAN_RAPTOR.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MartianRaptor::checkMonsterSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.PYGRO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Pygro::checkMonsterSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.ZOMBIFIED_PYGRO.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ZombifiedPygro::checkMonsterSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.PYGRO_BRUTE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PygroBrute::checkMonsterSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.MOGLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mogler::checkMobSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.ZOMBIFIED_MOGLER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, ZombifiedMogler::checkMonsterSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.LUNARIAN_WANDERING_TRADER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Lunarian::checkMobSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.SULFUR_CREEPER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SulfurCreeper::checkMonsterSpawnRules);
        PlatformUtils.registerSpawnPlacement(ModEntityTypes.GLACIAN_RAM.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GlacianRam::checkMobSpawnRules);
    }

    public static void registerAttributes(BiConsumer<Supplier<? extends EntityType<? extends LivingEntity>>, Supplier<AttributeSupplier.Builder>> attributes) {
        attributes.accept(LUNARIAN, Lunarian::createMobAttributes);
        attributes.accept(CORRUPTED_LUNARIAN, CorruptedLunarian::createMobAttributes);
        attributes.accept(STAR_CRAWLER, StarCrawler::createMobAttributes);
        attributes.accept(MARTIAN_RAPTOR, MartianRaptor::createMobAttributes);
        attributes.accept(PYGRO, Pygro::createMobAttributes);
        attributes.accept(ZOMBIFIED_PYGRO, ZombifiedPygro::createMobAttributes);
        attributes.accept(PYGRO_BRUTE, PygroBrute::createMobAttributes);
        attributes.accept(MOGLER, Mogler::createMobAttributes);
        attributes.accept(ZOMBIFIED_MOGLER, ZombifiedMogler::createMobAttributes);
        attributes.accept(LUNARIAN_WANDERING_TRADER, Lunarian::createMobAttributes);
        attributes.accept(SULFUR_CREEPER, SulfurCreeper::createMobAttributes);
        attributes.accept(GLACIAN_RAM, GlacianRam::createMobAttributes);
    }
}