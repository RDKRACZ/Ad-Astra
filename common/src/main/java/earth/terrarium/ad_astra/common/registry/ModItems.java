package earth.terrarium.ad_astra.common.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.common.config.AdAstraConfig;
import earth.terrarium.ad_astra.common.item.*;
import earth.terrarium.ad_astra.common.item.armor.JetSuit;
import earth.terrarium.ad_astra.common.item.armor.NetheriteSpaceSuit;
import earth.terrarium.ad_astra.common.item.armor.SpaceSuit;
import earth.terrarium.ad_astra.common.item.vehicle.RocketItem;
import earth.terrarium.ad_astra.common.item.vehicle.RoverItem;
import earth.terrarium.ad_astra.common.util.PlatformUtils;
import earth.terrarium.botarium.api.registry.fluid.FluidBucketItem;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;

@SuppressWarnings("unused")
public class ModItems {
    public static final CreativeModeTab ITEM_GROUP = PlatformUtils.createTab(new ResourceLocation(AdAstra.MOD_ID, "main"), () -> new ItemStack(ModItems.TIER_1_ROCKET.get()));
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(Registry.ITEM, AdAstra.MOD_ID);

    public static final ResourcefulRegistry<Item> VEHICLES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> FLAGS = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> GLOBES = ResourcefulRegistries.create(ITEMS);
    public static final ResourcefulRegistry<Item> SLIDING_DOORS = ResourcefulRegistries.create(ITEMS);

    public static final RegistryEntry<Item> ASTRODUX = ITEMS.register("astrodux", () -> new AstroduxItem(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> TIER_1_ROCKET = VEHICLES.register("tier_1_rocket", () -> new RocketItem<>(ModEntityTypes.TIER_1_ROCKET.get(), 1, new Item.Properties().tab(ITEM_GROUP).stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_2_ROCKET = VEHICLES.register("tier_2_rocket", () -> new RocketItem<>(ModEntityTypes.TIER_2_ROCKET.get(), 2, new Item.Properties().tab(ITEM_GROUP).stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_3_ROCKET = VEHICLES.register("tier_3_rocket", () -> new RocketItem<>(ModEntityTypes.TIER_3_ROCKET.get(), 3, new Item.Properties().tab(ITEM_GROUP).stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_4_ROCKET = VEHICLES.register("tier_4_rocket", () -> new RocketItem<>(ModEntityTypes.TIER_4_ROCKET.get(), 4, new Item.Properties().tab(ITEM_GROUP).stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> TIER_1_ROVER = VEHICLES.register("tier_1_rover", () -> new RoverItem(new Item.Properties().tab(ITEM_GROUP).stacksTo(1).fireResistant()));
    public static final RegistryEntry<Item> LAUNCH_PAD = ITEMS.register("launch_pad", () -> new HoldableOverHeadBlockItem(ModBlocks.LAUNCH_PAD.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> OIL_BUCKET = ITEMS.register("oil_bucket", () -> new FluidBucketItem(ModFluidProperties.OIL_FLUID, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> FUEL_BUCKET = ITEMS.register("fuel_bucket", () -> new FluidBucketItem(ModFluidProperties.FUEL_FLUID, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> CRYO_FUEL_BUCKET = ITEMS.register("cryo_fuel_bucket", () -> new FluidBucketItem(ModFluidProperties.CRYO_FUEL_FLUID, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));
    public static final RegistryEntry<Item> OXYGEN_BUCKET = ITEMS.register("oxygen_bucket", () -> new FluidBucketItem(ModFluidProperties.OXYGEN_FLUID, new Item.Properties().tab(ITEM_GROUP).craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryEntry<Item> OXYGEN_TANK = ITEMS.register("oxygen_tank", () -> new OxygenTankItem(new Item.Properties().tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryEntry<Item> SPACE_HELMET = ITEMS.register("space_helmet", () -> new SpaceSuit(ModArmour.SPACE_SUIT_ARMOUR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SPACE_SUIT = ITEMS.register("space_suit", () -> new SpaceSuit(ModArmour.SPACE_SUIT_ARMOUR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SPACE_PANTS = ITEMS.register("space_pants", () -> new SpaceSuit(ModArmour.SPACE_SUIT_ARMOUR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SPACE_BOOTS = ITEMS.register("space_boots", () -> new SpaceSuit(ModArmour.SPACE_SUIT_ARMOUR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> NETHERITE_SPACE_HELMET = ITEMS.register("netherite_space_helmet", () -> new NetheriteSpaceSuit(ModArmour.NETHERITE_SPACE_SUIT_ARMOUR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(ITEM_GROUP).fireResistant()));
    public static final RegistryEntry<Item> NETHERITE_SPACE_SUIT = ITEMS.register("netherite_space_suit", () -> new NetheriteSpaceSuit(ModArmour.NETHERITE_SPACE_SUIT_ARMOUR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(ITEM_GROUP).fireResistant()));
    public static final RegistryEntry<Item> NETHERITE_SPACE_PANTS = ITEMS.register("netherite_space_pants", () -> new NetheriteSpaceSuit(ModArmour.NETHERITE_SPACE_SUIT_ARMOUR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(ITEM_GROUP).fireResistant()));
    public static final RegistryEntry<Item> NETHERITE_SPACE_BOOTS = ITEMS.register("netherite_space_boots", () -> new NetheriteSpaceSuit(ModArmour.NETHERITE_SPACE_SUIT_ARMOUR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(ITEM_GROUP).fireResistant()));
    public static final RegistryEntry<Item> JET_SUIT_HELMET = ITEMS.register("jet_suit_helmet", () -> new JetSuit(ModArmour.JET_SUIT_ARMOUR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(ITEM_GROUP).fireResistant()));
    public static final RegistryEntry<Item> JET_SUIT = ITEMS.register("jet_suit", () -> new JetSuit(ModArmour.JET_SUIT_ARMOUR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(ITEM_GROUP).fireResistant()));
    public static final RegistryEntry<Item> JET_SUIT_PANTS = ITEMS.register("jet_suit_pants", () -> new JetSuit(ModArmour.JET_SUIT_ARMOUR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(ITEM_GROUP).fireResistant()));
    public static final RegistryEntry<Item> JET_SUIT_BOOTS = ITEMS.register("jet_suit_boots", () -> new JetSuit(ModArmour.JET_SUIT_ARMOUR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(ITEM_GROUP).fireResistant()));

    public static final RegistryEntry<Item> SPACE_PAINTING = ITEMS.register("space_painting", () -> new SpacePaintingItem(ModEntityTypes.SPACE_PAINTING.get(), new Item.Properties().tab(ITEM_GROUP).rarity(Rarity.UNCOMMON)));
    public static final RegistryEntry<Item> CHEESE = ITEMS.register("cheese", () -> new Item(new Item.Properties().tab(ITEM_GROUP).food(new FoodProperties.Builder().nutrition(4).saturationMod(1.0f).build())));

    public static final RegistryEntry<Item> WRENCH = ITEMS.register("wrench", () -> new Item(new Item.Properties().tab(ITEM_GROUP).stacksTo(1)));
    public static final RegistryEntry<Item> HAMMER = ITEMS.register("hammer", () -> new HammerItem(new Item.Properties().tab(ITEM_GROUP).stacksTo(1).durability(AdAstraConfig.hammerDurability)));
    public static final RegistryEntry<Item> STEEL_CABLE = ITEMS.register("steel_cable", () -> new BlockItem(ModBlocks.STEEL_CABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DESH_CABLE = ITEMS.register("desh_cable", () -> new BlockItem(ModBlocks.DESH_CABLE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> DESH_FLUID_PIPE = ITEMS.register("desh_fluid_pipe", () -> new BlockItem(ModBlocks.DESH_FLUID_PIPE.get(), new Item.Properties()));
    public static final RegistryEntry<Item> OSTRUM_FLUID_PIPE = ITEMS.register("ostrum_fluid_pipe", () -> new BlockItem(ModBlocks.OSTRUM_FLUID_PIPE.get(), new Item.Properties()));

    public static final RegistryEntry<Item> CABLE_DUCT = ITEMS.register("cable_duct", () -> new BlockItem(ModBlocks.CABLE_DUCT.get(), new Item.Properties()));
    public static final RegistryEntry<Item> FLUID_PIPE_DUCT = ITEMS.register("fluid_pipe_duct", () -> new BlockItem(ModBlocks.FLUID_PIPE_DUCT.get(), new Item.Properties()));

    public static final RegistryEntry<Item> COAL_GENERATOR = ITEMS.register("coal_generator", () -> new MachineBlockItem(ModBlocks.COAL_GENERATOR.get(), new Item.Properties().tab(ITEM_GROUP), "item.ad_astra.coal_generator.tooltip"));
    public static final RegistryEntry<Item> COMPRESSOR = ITEMS.register("compressor", () -> new MachineBlockItem(ModBlocks.COMPRESSOR.get(), new Item.Properties().tab(ITEM_GROUP), "item.ad_astra.compressor.tooltip"));
    public static final RegistryEntry<Item> NASA_WORKBENCH = ITEMS.register("nasa_workbench", () -> new MachineBlockItem(ModBlocks.NASA_WORKBENCH.get(), new Item.Properties().tab(ITEM_GROUP), "item.ad_astra.nasa_workbench.tooltip"));
    public static final RegistryEntry<Item> FUEL_REFINERY = ITEMS.register("fuel_refinery", () -> new MachineBlockItem(ModBlocks.FUEL_REFINERY.get(), new Item.Properties().tab(ITEM_GROUP), "item.ad_astra.fuel_refinery.tooltip"));
    public static final RegistryEntry<Item> OXYGEN_LOADER = ITEMS.register("oxygen_loader", () -> new MachineBlockItem(ModBlocks.OXYGEN_LOADER.get(), new Item.Properties().tab(ITEM_GROUP), "item.ad_astra.oxygen_loader.tooltip[0]", "item.ad_astra.oxygen_loader.tooltip[1]"));
    public static final RegistryEntry<Item> SOLAR_PANEL = ITEMS.register("solar_panel", () -> new SolarPanelBlockItem(ModBlocks.SOLAR_PANEL.get(), new Item.Properties().tab(ITEM_GROUP), "item.ad_astra.solar_panel.tooltip[0]", "item.ad_astra.solar_panel.tooltip[1]"));
    public static final RegistryEntry<Item> OXYGEN_DISTRIBUTOR = ITEMS.register("oxygen_distributor", () -> new MachineBlockItem(ModBlocks.OXYGEN_DISTRIBUTOR.get(), new Item.Properties().tab(ITEM_GROUP), "item.ad_astra.oxygen_distributor.tooltip[0]", "item.ad_astra.oxygen_distributor.tooltip[1]"));
    public static final RegistryEntry<Item> WATER_PUMP = ITEMS.register("water_pump", () -> new MachineBlockItem(ModBlocks.WATER_PUMP.get(), new Item.Properties().tab(ITEM_GROUP), "item.ad_astra.water_pump.tooltip[0]", "item.ad_astra.water_pump.tooltip[1]"));
    public static final RegistryEntry<Item> ENERGIZER = ITEMS.register("energizer", () -> new EnergizerBlockItem(ModBlocks.ENERGIZER.get(), new Item.Properties().tab(ITEM_GROUP).stacksTo(1), "item.ad_astra.energizer.tooltip[0]", "item.ad_astra.energizer.tooltip[1]"));
    public static final RegistryEntry<Item> CRYO_FREEZER = ITEMS.register("cryo_freezer", () -> new MachineBlockItem(ModBlocks.CRYO_FREEZER.get(), new Item.Properties().tab(ITEM_GROUP).stacksTo(1), "item.ad_astra.cryo_freezer.tooltip"));
    public static final RegistryEntry<Item> OXYGEN_SENSOR = ITEMS.register("oxygen_sensor", () -> new MachineBlockItem(ModBlocks.OXYGEN_SENSOR.get(), new Item.Properties().tab(ITEM_GROUP).stacksTo(1), "item.ad_astra.oxygen_sensor.tooltip[0]", "item.ad_astra.oxygen_sensor.tooltip[1]"));

    public static final RegistryEntry<Item> WHITE_FLAG = FLAGS.register("white_flag", () -> new FlagBlockItem(ModBlocks.WHITE_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ORANGE_FLAG = FLAGS.register("orange_flag", () -> new FlagBlockItem(ModBlocks.ORANGE_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MAGENTA_FLAG = FLAGS.register("magenta_flag", () -> new FlagBlockItem(ModBlocks.MAGENTA_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> LIGHT_BLUE_FLAG = FLAGS.register("light_blue_flag", () -> new FlagBlockItem(ModBlocks.LIGHT_BLUE_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> YELLOW_FLAG = FLAGS.register("yellow_flag", () -> new FlagBlockItem(ModBlocks.YELLOW_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> LIME_FLAG = FLAGS.register("lime_flag", () -> new FlagBlockItem(ModBlocks.LIME_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PINK_FLAG = FLAGS.register("pink_flag", () -> new FlagBlockItem(ModBlocks.PINK_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GRAY_FLAG = FLAGS.register("gray_flag", () -> new FlagBlockItem(ModBlocks.GRAY_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> LIGHT_GRAY_FLAG = FLAGS.register("light_gray_flag", () -> new FlagBlockItem(ModBlocks.LIGHT_GRAY_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CYAN_FLAG = FLAGS.register("cyan_flag", () -> new FlagBlockItem(ModBlocks.CYAN_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PURPLE_FLAG = FLAGS.register("purple_flag", () -> new FlagBlockItem(ModBlocks.PURPLE_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> BLUE_FLAG = FLAGS.register("blue_flag", () -> new FlagBlockItem(ModBlocks.BLUE_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> BROWN_FLAG = FLAGS.register("brown_flag", () -> new FlagBlockItem(ModBlocks.BROWN_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GREEN_FLAG = FLAGS.register("green_flag", () -> new FlagBlockItem(ModBlocks.GREEN_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> RED_FLAG = FLAGS.register("red_flag", () -> new FlagBlockItem(ModBlocks.RED_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> BLACK_FLAG = FLAGS.register("black_flag", () -> new FlagBlockItem(ModBlocks.BLACK_FLAG.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> EARTH_GLOBE = GLOBES.register("earth_globe", () -> new ModRenderedBlockItem(ModBlocks.EARTH_GLOBE.get(), new Item.Properties().tab(ITEM_GROUP).stacksTo(1).rarity(Rarity.RARE)));
    public static final RegistryEntry<Item> MOON_GLOBE = GLOBES.register("moon_globe", () -> new ModRenderedBlockItem(ModBlocks.MOON_GLOBE.get(), new Item.Properties().tab(ITEM_GROUP).stacksTo(1).rarity(Rarity.RARE)));
    public static final RegistryEntry<Item> MARS_GLOBE = GLOBES.register("mars_globe", () -> new ModRenderedBlockItem(ModBlocks.MARS_GLOBE.get(), new Item.Properties().tab(ITEM_GROUP).stacksTo(1).rarity(Rarity.RARE)));
    public static final RegistryEntry<Item> MERCURY_GLOBE = GLOBES.register("mercury_globe", () -> new ModRenderedBlockItem(ModBlocks.MERCURY_GLOBE.get(), new Item.Properties().tab(ITEM_GROUP).stacksTo(1).rarity(Rarity.RARE)));
    public static final RegistryEntry<Item> VENUS_GLOBE = GLOBES.register("venus_globe", () -> new ModRenderedBlockItem(ModBlocks.VENUS_GLOBE.get(), new Item.Properties().tab(ITEM_GROUP).stacksTo(1).rarity(Rarity.RARE)));
    public static final RegistryEntry<Item> GLACIO_GLOBE = GLOBES.register("glacio_globe", () -> new ModRenderedBlockItem(ModBlocks.GLACIO_GLOBE.get(), new Item.Properties().tab(ITEM_GROUP).stacksTo(1).rarity(Rarity.RARE)));

    public static final RegistryEntry<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_INGOT = ITEMS.register("desh_ingot", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_INGOT = ITEMS.register("ostrum_ingot", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_INGOT = ITEMS.register("calorite_ingot", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ICE_SHARD = ITEMS.register("ice_shard", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_MUSHROOM = ITEMS.register("aeronos_mushroom", () -> new BlockItem(ModBlocks.AERONOS_MUSHROOM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_MUSHROOM = ITEMS.register("strophar_mushroom", () -> new BlockItem(ModBlocks.STROPHAR_MUSHROOM.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> IRON_PLATE = ITEMS.register("iron_plate", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_PLATE = ITEMS.register("desh_plate", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_PLATE = ITEMS.register("ostrum_plate", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_PLATE = ITEMS.register("calorite_plate", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> RAW_DESH = ITEMS.register("raw_desh", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> RAW_OSTRUM = ITEMS.register("raw_ostrum", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> RAW_CALORITE = ITEMS.register("raw_calorite", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_NUGGET = ITEMS.register("desh_nugget", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_NUGGET = ITEMS.register("ostrum_nugget", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_NUGGET = ITEMS.register("calorite_nugget", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> IRON_ROD = ITEMS.register("iron_rod", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OXYGEN_GEAR = ITEMS.register("oxygen_gear", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> WHEEL = ITEMS.register("wheel", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ENGINE_FRAME = ITEMS.register("engine_frame", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ENGINE_FAN = ITEMS.register("engine_fan", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ROCKET_NOSE_CONE = ITEMS.register("rocket_nose_cone", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_ENGINE = ITEMS.register("steel_engine", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_ENGINE = ITEMS.register("desh_engine", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_ENGINE = ITEMS.register("ostrum_engine", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_ENGINE = ITEMS.register("calorite_engine", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_TANK = ITEMS.register("steel_tank", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_TANK = ITEMS.register("desh_tank", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_TANK = ITEMS.register("ostrum_tank", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_TANK = ITEMS.register("calorite_tank", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ROCKET_FIN = ITEMS.register("rocket_fin", () -> new Item(new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> EXTINGUISHED_TORCH = ITEMS.register("extinguished_torch", () -> new StandingAndWallBlockItem(ModBlocks.EXTINGUISHED_TORCH.get(), ModBlocks.WALL_EXTINGUISHED_TORCH.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> EXTINGUISHED_LANTERN = ITEMS.register("extinguished_lantern", () -> new BlockItem(ModBlocks.EXTINGUISHED_LANTERN.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> CHEESE_BLOCK = ITEMS.register("cheese_block", () -> new BlockItem(ModBlocks.CHEESE_BLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SKY_STONE = ITEMS.register("sky_stone", () -> new BlockItem(ModBlocks.SKY_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> IRON_PLATING = ITEMS.register("iron_plating", () -> new BlockItem(ModBlocks.IRON_PLATING.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRON_PLATING_STAIRS = ITEMS.register("iron_plating_stairs", () -> new BlockItem(ModBlocks.IRON_PLATING_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRON_PLATING_SLAB = ITEMS.register("iron_plating_slab", () -> new BlockItem(ModBlocks.IRON_PLATING_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRON_PILLAR = ITEMS.register("iron_pillar", () -> new BlockItem(ModBlocks.IRON_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLOWING_IRON_PILLAR = ITEMS.register("glowing_iron_pillar", () -> new BlockItem(ModBlocks.GLOWING_IRON_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARKED_IRON_PILLAR = ITEMS.register("marked_iron_pillar", () -> new BlockItem(ModBlocks.MARKED_IRON_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRON_PLATING_BUTTON = ITEMS.register("iron_plating_button", () -> new BlockItem(ModBlocks.IRON_PLATING_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRON_PLATING_PRESSURE_PLATE = ITEMS.register("iron_plating_pressure_plate", () -> new BlockItem(ModBlocks.IRON_PLATING_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> IRON_SLIDING_DOOR = SLIDING_DOORS.register("iron_sliding_door", () -> new BlockItem(ModBlocks.IRON_SLIDING_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> STEEL_BLOCK = ITEMS.register("steel_block", () -> new BlockItem(ModBlocks.STEEL_BLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_PLATING = ITEMS.register("steel_plating", () -> new BlockItem(ModBlocks.STEEL_PLATING.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_PLATING_STAIRS = ITEMS.register("steel_plating_stairs", () -> new BlockItem(ModBlocks.STEEL_PLATING_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_PLATING_SLAB = ITEMS.register("steel_plating_slab", () -> new BlockItem(ModBlocks.STEEL_PLATING_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_PILLAR = ITEMS.register("steel_pillar", () -> new BlockItem(ModBlocks.STEEL_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLOWING_STEEL_PILLAR = ITEMS.register("glowing_steel_pillar", () -> new BlockItem(ModBlocks.GLOWING_STEEL_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_PLATING_BUTTON = ITEMS.register("steel_plating_button", () -> new BlockItem(ModBlocks.STEEL_PLATING_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_PLATING_PRESSURE_PLATE = ITEMS.register("steel_plating_pressure_plate", () -> new BlockItem(ModBlocks.STEEL_PLATING_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_SLIDING_DOOR = SLIDING_DOORS.register("steel_sliding_door", () -> new BlockItem(ModBlocks.STEEL_SLIDING_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AIRLOCK = SLIDING_DOORS.register("airlock", () -> new BlockItem(ModBlocks.AIRLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> REINFORCED_DOOR = SLIDING_DOORS.register("reinforced_door", () -> new BlockItem(ModBlocks.REINFORCED_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_DOOR = ITEMS.register("steel_door", () -> new BlockItem(ModBlocks.STEEL_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STEEL_TRAPDOOR = ITEMS.register("steel_trapdoor", () -> new BlockItem(ModBlocks.STEEL_TRAPDOOR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> DESH_BLOCK = ITEMS.register("desh_block", () -> new BlockItem(ModBlocks.DESH_BLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> RAW_DESH_BLOCK = ITEMS.register("raw_desh_block", () -> new BlockItem(ModBlocks.RAW_DESH_BLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_PLATING = ITEMS.register("desh_plating", () -> new BlockItem(ModBlocks.DESH_PLATING.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_PLATING_STAIRS = ITEMS.register("desh_plating_stairs", () -> new BlockItem(ModBlocks.DESH_PLATING_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_PLATING_SLAB = ITEMS.register("desh_plating_slab", () -> new BlockItem(ModBlocks.DESH_PLATING_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_PILLAR = ITEMS.register("desh_pillar", () -> new BlockItem(ModBlocks.DESH_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLOWING_DESH_PILLAR = ITEMS.register("glowing_desh_pillar", () -> new BlockItem(ModBlocks.GLOWING_DESH_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_PLATING_BUTTON = ITEMS.register("desh_plating_button", () -> new BlockItem(ModBlocks.DESH_PLATING_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_PLATING_PRESSURE_PLATE = ITEMS.register("desh_plating_pressure_plate", () -> new BlockItem(ModBlocks.DESH_PLATING_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DESH_SLIDING_DOOR = SLIDING_DOORS.register("desh_sliding_door", () -> new BlockItem(ModBlocks.DESH_SLIDING_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> OSTRUM_BLOCK = ITEMS.register("ostrum_block", () -> new BlockItem(ModBlocks.OSTRUM_BLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> RAW_OSTRUM_BLOCK = ITEMS.register("raw_ostrum_block", () -> new BlockItem(ModBlocks.RAW_OSTRUM_BLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_PLATING = ITEMS.register("ostrum_plating", () -> new BlockItem(ModBlocks.OSTRUM_PLATING.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_PLATING_STAIRS = ITEMS.register("ostrum_plating_stairs", () -> new BlockItem(ModBlocks.OSTRUM_PLATING_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_PLATING_SLAB = ITEMS.register("ostrum_plating_slab", () -> new BlockItem(ModBlocks.OSTRUM_PLATING_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_PILLAR = ITEMS.register("ostrum_pillar", () -> new BlockItem(ModBlocks.OSTRUM_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLOWING_OSTRUM_PILLAR = ITEMS.register("glowing_ostrum_pillar", () -> new BlockItem(ModBlocks.GLOWING_OSTRUM_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_PLATING_BUTTON = ITEMS.register("ostrum_plating_button", () -> new BlockItem(ModBlocks.OSTRUM_PLATING_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_PLATING_PRESSURE_PLATE = ITEMS.register("ostrum_plating_pressure_plate", () -> new BlockItem(ModBlocks.OSTRUM_PLATING_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> OSTRUM_SLIDING_DOOR = SLIDING_DOORS.register("ostrum_sliding_door", () -> new BlockItem(ModBlocks.OSTRUM_SLIDING_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> CALORITE_BLOCK = ITEMS.register("calorite_block", () -> new BlockItem(ModBlocks.CALORITE_BLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> RAW_CALORITE_BLOCK = ITEMS.register("raw_calorite_block", () -> new BlockItem(ModBlocks.RAW_CALORITE_BLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_PLATING = ITEMS.register("calorite_plating", () -> new BlockItem(ModBlocks.CALORITE_PLATING.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_PLATING_STAIRS = ITEMS.register("calorite_plating_stairs", () -> new BlockItem(ModBlocks.CALORITE_PLATING_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_PLATING_SLAB = ITEMS.register("calorite_plating_slab", () -> new BlockItem(ModBlocks.CALORITE_PLATING_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_PILLAR = ITEMS.register("calorite_pillar", () -> new BlockItem(ModBlocks.CALORITE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLOWING_CALORITE_PILLAR = ITEMS.register("glowing_calorite_pillar", () -> new BlockItem(ModBlocks.GLOWING_CALORITE_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_PLATING_BUTTON = ITEMS.register("calorite_plating_button", () -> new BlockItem(ModBlocks.CALORITE_PLATING_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_PLATING_PRESSURE_PLATE = ITEMS.register("calorite_plating_pressure_plate", () -> new BlockItem(ModBlocks.CALORITE_PLATING_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CALORITE_SLIDING_DOOR = SLIDING_DOORS.register("calorite_sliding_door", () -> new BlockItem(ModBlocks.CALORITE_SLIDING_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> MOON_SAND = ITEMS.register("moon_sand", () -> new BlockItem(ModBlocks.MOON_SAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_STONE = ITEMS.register("moon_stone", () -> new BlockItem(ModBlocks.MOON_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_STONE_STAIRS = ITEMS.register("moon_stone_stairs", () -> new BlockItem(ModBlocks.MOON_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_STONE_SLAB = ITEMS.register("moon_stone_slab", () -> new BlockItem(ModBlocks.MOON_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_COBBLESTONE = ITEMS.register("moon_cobblestone", () -> new BlockItem(ModBlocks.MOON_COBBLESTONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_COBBLESTONE_STAIRS = ITEMS.register("moon_cobblestone_stairs", () -> new BlockItem(ModBlocks.MOON_COBBLESTONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_COBBLESTONE_SLAB = ITEMS.register("moon_cobblestone_slab", () -> new BlockItem(ModBlocks.MOON_COBBLESTONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_STONE_BRICKS = ITEMS.register("moon_stone_bricks", () -> new BlockItem(ModBlocks.MOON_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_STONE_BRICK_SLAB = ITEMS.register("moon_stone_brick_slab", () -> new BlockItem(ModBlocks.MOON_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_STONE_BRICK_STAIRS = ITEMS.register("moon_stone_brick_stairs", () -> new BlockItem(ModBlocks.MOON_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CRACKED_MOON_STONE_BRICKS = ITEMS.register("cracked_moon_stone_bricks", () -> new BlockItem(ModBlocks.CRACKED_MOON_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_MOON_STONE_BRICKS = ITEMS.register("chiseled_moon_stone_bricks", () -> new BlockItem(ModBlocks.CHISELED_MOON_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_MOON_STONE_STAIRS = ITEMS.register("chiseled_moon_stone_stairs", () -> new BlockItem(ModBlocks.CHISELED_MOON_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_MOON_STONE_SLAB = ITEMS.register("chiseled_moon_stone_slab", () -> new BlockItem(ModBlocks.CHISELED_MOON_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_MOON_STONE = ITEMS.register("polished_moon_stone", () -> new BlockItem(ModBlocks.POLISHED_MOON_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_MOON_STONE_STAIRS = ITEMS.register("polished_moon_stone_stairs", () -> new BlockItem(ModBlocks.POLISHED_MOON_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_MOON_STONE_SLAB = ITEMS.register("polished_moon_stone_slab", () -> new BlockItem(ModBlocks.POLISHED_MOON_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_PILLAR = ITEMS.register("moon_pillar", () -> new BlockItem(ModBlocks.MOON_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_STONE_BRICK_WALL = ITEMS.register("moon_stone_brick_wall", () -> new BlockItem(ModBlocks.MOON_STONE_BRICK_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> MOON_CHEESE_ORE = ITEMS.register("moon_cheese_ore", () -> new BlockItem(ModBlocks.MOON_CHEESE_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_DESH_ORE = ITEMS.register("moon_desh_ore", () -> new BlockItem(ModBlocks.MOON_DESH_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DEEPSLATE_DESH_ORE = ITEMS.register("deepslate_desh_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_DESH_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_IRON_ORE = ITEMS.register("moon_iron_ore", () -> new BlockItem(ModBlocks.MOON_IRON_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOON_ICE_SHARD_ORE = ITEMS.register("moon_ice_shard_ore", () -> new BlockItem(ModBlocks.MOON_ICE_SHARD_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DEEPSLATE_ICE_SHARD_ORE = ITEMS.register("deepslate_ice_shard_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_ICE_SHARD_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> AERONOS_CAP = ITEMS.register("aeronos_cap", () -> new BlockItem(ModBlocks.AERONOS_CAP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_STEM = ITEMS.register("aeronos_stem", () -> new BlockItem(ModBlocks.AERONOS_STEM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_PLANKS = ITEMS.register("aeronos_planks", () -> new BlockItem(ModBlocks.AERONOS_PLANKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_STAIRS = ITEMS.register("aeronos_stairs", () -> new BlockItem(ModBlocks.AERONOS_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_SLAB = ITEMS.register("aeronos_slab", () -> new BlockItem(ModBlocks.AERONOS_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_FENCE = ITEMS.register("aeronos_fence", () -> new BlockItem(ModBlocks.AERONOS_FENCE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_FENCE_GATE = ITEMS.register("aeronos_fence_gate", () -> new BlockItem(ModBlocks.AERONOS_FENCE_GATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_LADDER = ITEMS.register("aeronos_ladder", () -> new BlockItem(ModBlocks.AERONOS_LADDER.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_CHEST = ITEMS.register("aeronos_chest", () -> new ModRenderedBlockItem(ModBlocks.AERONOS_CHEST.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_DOOR = ITEMS.register("aeronos_door", () -> new BlockItem(ModBlocks.AERONOS_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> AERONOS_TRAPDOOR = ITEMS.register("aeronos_trapdoor", () -> new BlockItem(ModBlocks.AERONOS_TRAPDOOR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> STROPHAR_CAP = ITEMS.register("strophar_cap", () -> new BlockItem(ModBlocks.STROPHAR_CAP.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_STEM = ITEMS.register("strophar_stem", () -> new BlockItem(ModBlocks.STROPHAR_STEM.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_PLANKS = ITEMS.register("strophar_planks", () -> new BlockItem(ModBlocks.STROPHAR_PLANKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_STAIRS = ITEMS.register("strophar_stairs", () -> new BlockItem(ModBlocks.STROPHAR_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_SLAB = ITEMS.register("strophar_slab", () -> new BlockItem(ModBlocks.STROPHAR_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_FENCE = ITEMS.register("strophar_fence", () -> new BlockItem(ModBlocks.STROPHAR_FENCE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_FENCE_GATE = ITEMS.register("strophar_fence_gate", () -> new BlockItem(ModBlocks.STROPHAR_FENCE_GATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_LADDER = ITEMS.register("strophar_ladder", () -> new BlockItem(ModBlocks.STROPHAR_LADDER.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_CHEST = ITEMS.register("strophar_chest", () -> new ModRenderedBlockItem(ModBlocks.STROPHAR_CHEST.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_DOOR = ITEMS.register("strophar_door", () -> new BlockItem(ModBlocks.STROPHAR_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STROPHAR_TRAPDOOR = ITEMS.register("strophar_trapdoor", () -> new BlockItem(ModBlocks.STROPHAR_TRAPDOOR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> MARS_SAND = ITEMS.register("mars_sand", () -> new BlockItem(ModBlocks.MARS_SAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_STONE = ITEMS.register("mars_stone", () -> new BlockItem(ModBlocks.MARS_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_STONE_STAIRS = ITEMS.register("mars_stone_stairs", () -> new BlockItem(ModBlocks.MARS_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_STONE_SLAB = ITEMS.register("mars_stone_slab", () -> new BlockItem(ModBlocks.MARS_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_COBBLESTONE = ITEMS.register("mars_cobblestone", () -> new BlockItem(ModBlocks.MARS_COBBLESTONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_COBBLESTONE_STAIRS = ITEMS.register("mars_cobblestone_stairs", () -> new BlockItem(ModBlocks.MARS_COBBLESTONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_COBBLESTONE_SLAB = ITEMS.register("mars_cobblestone_slab", () -> new BlockItem(ModBlocks.MARS_COBBLESTONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_STONE_BRICKS = ITEMS.register("mars_stone_bricks", () -> new BlockItem(ModBlocks.MARS_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_STONE_BRICK_SLAB = ITEMS.register("mars_stone_brick_slab", () -> new BlockItem(ModBlocks.MARS_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_STONE_BRICK_STAIRS = ITEMS.register("mars_stone_brick_stairs", () -> new BlockItem(ModBlocks.MARS_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CRACKED_MARS_STONE_BRICKS = ITEMS.register("cracked_mars_stone_bricks", () -> new BlockItem(ModBlocks.CRACKED_MARS_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_MARS_STONE_BRICKS = ITEMS.register("chiseled_mars_stone_bricks", () -> new BlockItem(ModBlocks.CHISELED_MARS_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_MARS_STONE_STAIRS = ITEMS.register("chiseled_mars_stone_stairs", () -> new BlockItem(ModBlocks.CHISELED_MARS_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_MARS_STONE_SLAB = ITEMS.register("chiseled_mars_stone_slab", () -> new BlockItem(ModBlocks.CHISELED_MARS_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_MARS_STONE = ITEMS.register("polished_mars_stone", () -> new BlockItem(ModBlocks.POLISHED_MARS_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_MARS_STONE_STAIRS = ITEMS.register("polished_mars_stone_stairs", () -> new BlockItem(ModBlocks.POLISHED_MARS_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_MARS_STONE_SLAB = ITEMS.register("polished_mars_stone_slab", () -> new BlockItem(ModBlocks.POLISHED_MARS_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_PILLAR = ITEMS.register("mars_pillar", () -> new BlockItem(ModBlocks.MARS_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_STONE_BRICK_WALL = ITEMS.register("mars_stone_brick_wall", () -> new BlockItem(ModBlocks.MARS_STONE_BRICK_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> CONGLOMERATE = ITEMS.register("conglomerate", () -> new BlockItem(ModBlocks.CONGLOMERATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_CONGLOMERATE = ITEMS.register("polished_conglomerate", () -> new BlockItem(ModBlocks.POLISHED_CONGLOMERATE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> MARS_IRON_ORE = ITEMS.register("mars_iron_ore", () -> new BlockItem(ModBlocks.MARS_IRON_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_DIAMOND_ORE = ITEMS.register("mars_diamond_ore", () -> new BlockItem(ModBlocks.MARS_DIAMOND_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_OSTRUM_ORE = ITEMS.register("mars_ostrum_ore", () -> new BlockItem(ModBlocks.MARS_OSTRUM_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DEEPSLATE_OSTRUM_ORE = ITEMS.register("deepslate_ostrum_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_OSTRUM_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARS_ICE_SHARD_ORE = ITEMS.register("mars_ice_shard_ore", () -> new BlockItem(ModBlocks.MARS_ICE_SHARD_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> VENUS_SANDSTONE = ITEMS.register("venus_sandstone", () -> new BlockItem(ModBlocks.VENUS_SANDSTONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_SANDSTONE_BRICKS = ITEMS.register("venus_sandstone_bricks", () -> new BlockItem(ModBlocks.VENUS_SANDSTONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_SANDSTONE_BRICK_SLAB = ITEMS.register("venus_sandstone_brick_slab", () -> new BlockItem(ModBlocks.VENUS_SANDSTONE_BRICK_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_SANDSTONE_BRICK_STAIRS = ITEMS.register("venus_sandstone_brick_stairs", () -> new BlockItem(ModBlocks.VENUS_SANDSTONE_BRICK_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CRACKED_VENUS_SANDSTONE_BRICKS = ITEMS.register("cracked_venus_sandstone_bricks", () -> new BlockItem(ModBlocks.CRACKED_VENUS_SANDSTONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> VENUS_SAND = ITEMS.register("venus_sand", () -> new BlockItem(ModBlocks.VENUS_SAND.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_STONE = ITEMS.register("venus_stone", () -> new BlockItem(ModBlocks.VENUS_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_STONE_STAIRS = ITEMS.register("venus_stone_stairs", () -> new BlockItem(ModBlocks.VENUS_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_STONE_SLAB = ITEMS.register("venus_stone_slab", () -> new BlockItem(ModBlocks.VENUS_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_COBBLESTONE = ITEMS.register("venus_cobblestone", () -> new BlockItem(ModBlocks.VENUS_COBBLESTONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_COBBLESTONE_STAIRS = ITEMS.register("venus_cobblestone_stairs", () -> new BlockItem(ModBlocks.VENUS_COBBLESTONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_COBBLESTONE_SLAB = ITEMS.register("venus_cobblestone_slab", () -> new BlockItem(ModBlocks.VENUS_COBBLESTONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_STONE_BRICKS = ITEMS.register("venus_stone_bricks", () -> new BlockItem(ModBlocks.VENUS_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_STONE_BRICK_SLAB = ITEMS.register("venus_stone_brick_slab", () -> new BlockItem(ModBlocks.VENUS_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_STONE_BRICK_STAIRS = ITEMS.register("venus_stone_brick_stairs", () -> new BlockItem(ModBlocks.VENUS_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CRACKED_VENUS_STONE_BRICKS = ITEMS.register("cracked_venus_stone_bricks", () -> new BlockItem(ModBlocks.CRACKED_VENUS_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_VENUS_STONE_BRICKS = ITEMS.register("chiseled_venus_stone_bricks", () -> new BlockItem(ModBlocks.CHISELED_VENUS_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_VENUS_STONE_STAIRS = ITEMS.register("chiseled_venus_stone_stairs", () -> new BlockItem(ModBlocks.CHISELED_VENUS_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_VENUS_STONE_SLAB = ITEMS.register("chiseled_venus_stone_slab", () -> new BlockItem(ModBlocks.CHISELED_VENUS_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_VENUS_STONE = ITEMS.register("polished_venus_stone", () -> new BlockItem(ModBlocks.POLISHED_VENUS_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_VENUS_STONE_STAIRS = ITEMS.register("polished_venus_stone_stairs", () -> new BlockItem(ModBlocks.POLISHED_VENUS_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_VENUS_STONE_SLAB = ITEMS.register("polished_venus_stone_slab", () -> new BlockItem(ModBlocks.POLISHED_VENUS_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_PILLAR = ITEMS.register("venus_pillar", () -> new BlockItem(ModBlocks.VENUS_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_STONE_BRICK_WALL = ITEMS.register("venus_stone_brick_wall", () -> new BlockItem(ModBlocks.VENUS_STONE_BRICK_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> VENUS_COAL_ORE = ITEMS.register("venus_coal_ore", () -> new BlockItem(ModBlocks.VENUS_COAL_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_GOLD_ORE = ITEMS.register("venus_gold_ore", () -> new BlockItem(ModBlocks.VENUS_GOLD_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_DIAMOND_ORE = ITEMS.register("venus_diamond_ore", () -> new BlockItem(ModBlocks.VENUS_DIAMOND_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> VENUS_CALORITE_ORE = ITEMS.register("venus_calorite_ore", () -> new BlockItem(ModBlocks.VENUS_CALORITE_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> DEEPSLATE_CALORITE_ORE = ITEMS.register("deepslate_calorite_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_CALORITE_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> INFERNAL_SPIRE_BLOCK = ITEMS.register("infernal_spire_block", () -> new BlockItem(ModBlocks.INFERNAL_SPIRE_BLOCK.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> MERCURY_STONE = ITEMS.register("mercury_stone", () -> new BlockItem(ModBlocks.MERCURY_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_STONE_STAIRS = ITEMS.register("mercury_stone_stairs", () -> new BlockItem(ModBlocks.MERCURY_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_STONE_SLAB = ITEMS.register("mercury_stone_slab", () -> new BlockItem(ModBlocks.MERCURY_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_COBBLESTONE = ITEMS.register("mercury_cobblestone", () -> new BlockItem(ModBlocks.MERCURY_COBBLESTONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_COBBLESTONE_STAIRS = ITEMS.register("mercury_cobblestone_stairs", () -> new BlockItem(ModBlocks.MERCURY_COBBLESTONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_COBBLESTONE_SLAB = ITEMS.register("mercury_cobblestone_slab", () -> new BlockItem(ModBlocks.MERCURY_COBBLESTONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_STONE_BRICKS = ITEMS.register("mercury_stone_bricks", () -> new BlockItem(ModBlocks.MERCURY_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_STONE_BRICK_SLAB = ITEMS.register("mercury_stone_brick_slab", () -> new BlockItem(ModBlocks.MERCURY_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_STONE_BRICK_STAIRS = ITEMS.register("mercury_stone_brick_stairs", () -> new BlockItem(ModBlocks.MERCURY_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CRACKED_MERCURY_STONE_BRICKS = ITEMS.register("cracked_mercury_stone_bricks", () -> new BlockItem(ModBlocks.CRACKED_MERCURY_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_MERCURY_STONE_BRICKS = ITEMS.register("chiseled_mercury_stone_bricks", () -> new BlockItem(ModBlocks.CHISELED_MERCURY_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_MERCURY_STONE_STAIRS = ITEMS.register("chiseled_mercury_stone_stairs", () -> new BlockItem(ModBlocks.CHISELED_MERCURY_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_MERCURY_STONE_SLAB = ITEMS.register("chiseled_mercury_stone_slab", () -> new BlockItem(ModBlocks.CHISELED_MERCURY_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_MERCURY_STONE = ITEMS.register("polished_mercury_stone", () -> new BlockItem(ModBlocks.POLISHED_MERCURY_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_MERCURY_STONE_STAIRS = ITEMS.register("polished_mercury_stone_stairs", () -> new BlockItem(ModBlocks.POLISHED_MERCURY_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_MERCURY_STONE_SLAB = ITEMS.register("polished_mercury_stone_slab", () -> new BlockItem(ModBlocks.POLISHED_MERCURY_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_PILLAR = ITEMS.register("mercury_pillar", () -> new BlockItem(ModBlocks.MERCURY_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MERCURY_STONE_BRICK_WALL = ITEMS.register("mercury_stone_brick_wall", () -> new BlockItem(ModBlocks.MERCURY_STONE_BRICK_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> MERCURY_IRON_ORE = ITEMS.register("mercury_iron_ore", () -> new BlockItem(ModBlocks.MERCURY_IRON_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> GLACIO_STONE = ITEMS.register("glacio_stone", () -> new BlockItem(ModBlocks.GLACIO_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_STONE_STAIRS = ITEMS.register("glacio_stone_stairs", () -> new BlockItem(ModBlocks.GLACIO_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_STONE_SLAB = ITEMS.register("glacio_stone_slab", () -> new BlockItem(ModBlocks.GLACIO_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_COBBLESTONE = ITEMS.register("glacio_cobblestone", () -> new BlockItem(ModBlocks.GLACIO_COBBLESTONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_COBBLESTONE_STAIRS = ITEMS.register("glacio_cobblestone_stairs", () -> new BlockItem(ModBlocks.GLACIO_COBBLESTONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_COBBLESTONE_SLAB = ITEMS.register("glacio_cobblestone_slab", () -> new BlockItem(ModBlocks.GLACIO_COBBLESTONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_STONE_BRICKS = ITEMS.register("glacio_stone_bricks", () -> new BlockItem(ModBlocks.GLACIO_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_STONE_BRICK_SLAB = ITEMS.register("glacio_stone_brick_slab", () -> new BlockItem(ModBlocks.GLACIO_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_STONE_BRICK_STAIRS = ITEMS.register("glacio_stone_brick_stairs", () -> new BlockItem(ModBlocks.GLACIO_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CRACKED_GLACIO_STONE_BRICKS = ITEMS.register("cracked_glacio_stone_bricks", () -> new BlockItem(ModBlocks.CRACKED_GLACIO_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_GLACIO_STONE_BRICKS = ITEMS.register("chiseled_glacio_stone_bricks", () -> new BlockItem(ModBlocks.CHISELED_GLACIO_STONE_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_GLACIO_STONE_STAIRS = ITEMS.register("chiseled_glacio_stone_stairs", () -> new BlockItem(ModBlocks.CHISELED_GLACIO_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_GLACIO_STONE_SLAB = ITEMS.register("chiseled_glacio_stone_slab", () -> new BlockItem(ModBlocks.CHISELED_GLACIO_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_GLACIO_STONE = ITEMS.register("polished_glacio_stone", () -> new BlockItem(ModBlocks.POLISHED_GLACIO_STONE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_GLACIO_STONE_STAIRS = ITEMS.register("polished_glacio_stone_stairs", () -> new BlockItem(ModBlocks.POLISHED_GLACIO_STONE_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_GLACIO_STONE_SLAB = ITEMS.register("polished_glacio_stone_slab", () -> new BlockItem(ModBlocks.POLISHED_GLACIO_STONE_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_PILLAR = ITEMS.register("glacio_pillar", () -> new BlockItem(ModBlocks.GLACIO_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_STONE_BRICK_WALL = ITEMS.register("glacio_stone_brick_wall", () -> new BlockItem(ModBlocks.GLACIO_STONE_BRICK_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> GLACIO_ICE_SHARD_ORE = ITEMS.register("glacio_ice_shard_ore", () -> new BlockItem(ModBlocks.GLACIO_ICE_SHARD_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_COAL_ORE = ITEMS.register("glacio_coal_ore", () -> new BlockItem(ModBlocks.GLACIO_COAL_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_COPPER_ORE = ITEMS.register("glacio_copper_ore", () -> new BlockItem(ModBlocks.GLACIO_COPPER_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_IRON_ORE = ITEMS.register("glacio_iron_ore", () -> new BlockItem(ModBlocks.GLACIO_IRON_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIO_LAPIS_ORE = ITEMS.register("glacio_lapis_ore", () -> new BlockItem(ModBlocks.GLACIO_LAPIS_ORE.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> PERMAFROST = ITEMS.register("permafrost", () -> new BlockItem(ModBlocks.PERMAFROST.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PERMAFROST_BRICKS = ITEMS.register("permafrost_bricks", () -> new BlockItem(ModBlocks.PERMAFROST_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PERMAFROST_BRICK_STAIRS = ITEMS.register("permafrost_brick_stairs", () -> new BlockItem(ModBlocks.PERMAFROST_BRICK_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PERMAFROST_BRICK_SLAB = ITEMS.register("permafrost_brick_slab", () -> new BlockItem(ModBlocks.PERMAFROST_BRICK_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CRACKED_PERMAFROST_BRICKS = ITEMS.register("cracked_permafrost_bricks", () -> new BlockItem(ModBlocks.CRACKED_PERMAFROST_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PERMAFROST_TILES = ITEMS.register("permafrost_tiles", () -> new BlockItem(ModBlocks.PERMAFROST_TILES.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_PERMAFROST_BRICKS = ITEMS.register("chiseled_permafrost_bricks", () -> new BlockItem(ModBlocks.CHISELED_PERMAFROST_BRICKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_PERMAFROST_BRICK_STAIRS = ITEMS.register("chiseled_permafrost_brick_stairs", () -> new BlockItem(ModBlocks.CHISELED_PERMAFROST_BRICK_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CHISELED_PERMAFROST_BRICK_SLAB = ITEMS.register("chiseled_permafrost_brick_slab", () -> new BlockItem(ModBlocks.CHISELED_PERMAFROST_BRICK_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_PERMAFROST = ITEMS.register("polished_permafrost", () -> new BlockItem(ModBlocks.POLISHED_PERMAFROST.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_PERMAFROST_STAIRS = ITEMS.register("polished_permafrost_stairs", () -> new BlockItem(ModBlocks.POLISHED_PERMAFROST_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> POLISHED_PERMAFROST_SLAB = ITEMS.register("polished_permafrost_slab", () -> new BlockItem(ModBlocks.POLISHED_PERMAFROST_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PERMAFROST_PILLAR = ITEMS.register("permafrost_pillar", () -> new BlockItem(ModBlocks.PERMAFROST_PILLAR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PERMAFROST_BRICK_WALL = ITEMS.register("permafrost_brick_wall", () -> new BlockItem(ModBlocks.PERMAFROST_BRICK_WALL.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> GLACIAN_LOG = ITEMS.register("glacian_log", () -> new BlockItem(ModBlocks.GLACIAN_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STRIPPED_GLACIAN_LOG = ITEMS.register("stripped_glacian_log", () -> new BlockItem(ModBlocks.STRIPPED_GLACIAN_LOG.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_LEAVES = ITEMS.register("glacian_leaves", () -> new BlockItem(ModBlocks.GLACIAN_LEAVES.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_PLANKS = ITEMS.register("glacian_planks", () -> new BlockItem(ModBlocks.GLACIAN_PLANKS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_STAIRS = ITEMS.register("glacian_stairs", () -> new BlockItem(ModBlocks.GLACIAN_STAIRS.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_SLAB = ITEMS.register("glacian_slab", () -> new BlockItem(ModBlocks.GLACIAN_SLAB.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_DOOR = ITEMS.register("glacian_door", () -> new BlockItem(ModBlocks.GLACIAN_DOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_TRAPDOOR = ITEMS.register("glacian_trapdoor", () -> new BlockItem(ModBlocks.GLACIAN_TRAPDOOR.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_FENCE = ITEMS.register("glacian_fence", () -> new BlockItem(ModBlocks.GLACIAN_FENCE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_FENCE_GATE = ITEMS.register("glacian_fence_gate", () -> new BlockItem(ModBlocks.GLACIAN_FENCE_GATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_BUTTON = ITEMS.register("glacian_button", () -> new BlockItem(ModBlocks.GLACIAN_BUTTON.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_PRESSURE_PLATE = ITEMS.register("glacian_pressure_plate", () -> new BlockItem(ModBlocks.GLACIAN_PRESSURE_PLATE.get(), new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_SIGN = ITEMS.register("glacian_sign", () -> new SignItem(new Item.Properties().tab(ITEM_GROUP).stacksTo(16), ModBlocks.GLACIAN_SIGN.get(), ModBlocks.GLACIAN_WALL_SIGN.get()));
    public static final RegistryEntry<Item> GLACIAN_FUR = ITEMS.register("glacian_fur", () -> new BlockItem(ModBlocks.GLACIAN_FUR.get(), new Item.Properties().tab(ITEM_GROUP)));

    public static final RegistryEntry<Item> LUNARIAN_SPAWN_EGG = ITEMS.register("lunarian_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.LUNARIAN, -13382401, -11650781, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> CORRUPTED_LUNARIAN_SPAWN_EGG = ITEMS.register("corrupted_lunarian_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.CORRUPTED_LUNARIAN, -14804199, -16740159, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> STAR_CRAWLER_SPAWN_EGG = ITEMS.register("star_crawler_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.STAR_CRAWLER, -13421773, -16724788, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MARTIAN_RAPTOR_SPAWN_EGG = ITEMS.register("martian_raptor_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.MARTIAN_RAPTOR, 5349438, -13312, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PYGRO_SPAWN_EGG = ITEMS.register("pygro_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.PYGRO, -3381760, -6750208, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ZOMBIFIED_PYGRO_SPAWN_EGG = ITEMS.register("zombified_pygro_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.ZOMBIFIED_PYGRO, 8473125, 6131271, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> PYGRO_BRUTE_SPAWN_EGG = ITEMS.register("pygro_brute_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.PYGRO_BRUTE, -3381760, -67208, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> MOGLER_SPAWN_EGG = ITEMS.register("mogler_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.MOGLER, -13312, -3407872, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> ZOMBIFIED_MOGLER_SPAWN_EGG = ITEMS.register("zombified_mogler_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.ZOMBIFIED_MOGLER, 12537409, 7988821, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> SULFUR_CREEPER_SPAWN_EGG = ITEMS.register("sulfur_creeper_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.SULFUR_CREEPER, 13930288, 11303196, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> GLACIAN_RAM_SPAWN_EGG = ITEMS.register("glacian_ram_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.GLACIAN_RAM, 16770815, 4406589, new Item.Properties().tab(ITEM_GROUP)));
    public static final RegistryEntry<Item> LUNARIAN_WANDERING_TRADER_SPAWN_EGG = ITEMS.register("lunarian_wandering_trader_spawn_egg", PlatformUtils.createSpawnEggItem(ModEntityTypes.LUNARIAN_WANDERING_TRADER, 5993415, 8537301, new Item.Properties().tab(ITEM_GROUP)));
}