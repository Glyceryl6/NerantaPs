package com.nerantaps.registry;

import com.nerantaps.NerantaPs;
import com.nerantaps.blocks.*;
import com.nerantaps.blocks.fluids.Alcohol;
import com.nerantaps.blocks.fluids.NascentLava;
import com.nerantaps.blocks.fluids.SulfuricAcid;
import com.nerantaps.blocks.grower.CycasGrower;
import com.nerantaps.blocks.grower.GlowTreeGrower;
import com.nerantaps.blocks.grower.MapleGrower;
import com.nerantaps.core.NPCauldronInteraction;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.nerantaps.utils.NPBlockUtils.*;

public class NPBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, NerantaPs.MOD_ID);
    public static final RegistryObject<Block> ALCOHOL = BLOCKS.register("alcohol", Alcohol::new);
    public static final RegistryObject<Block> NASCENT_LAVA = BLOCKS.register("nascent_lava", NascentLava::new);
    public static final RegistryObject<Block> SULFURIC_ACID = BLOCKS.register("sulfuric_acid", SulfuricAcid::new);
    public static final RegistryObject<Block> SULFUR_FIRE = BLOCKS.register("sulfur_fire", SulfurFire::new);
    public static final RegistryObject<Block> ALCOHOL_CAULDRON = BLOCKS.register("alcohol_cauldron",
            () -> new LayeredCauldronBlock(copy(Blocks.CAULDRON), (precipitation) -> false, NPCauldronInteraction.ALCOHOL));
    public static final RegistryObject<Block> SULFURIC_ACID_CAULDRON = BLOCKS.register("sulfuric_acid_cauldron",
            () -> new LayeredCauldronBlock(copy(Blocks.CAULDRON), (precipitation) -> false, NPCauldronInteraction.SULFURIC_ACID));
    //Glow Trees
    public static final RegistryObject<Block> STRIPPED_GLOW_LOG = register("stripped_glow_log", () -> Blocks.log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final RegistryObject<Block> STRIPPED_GLOW_WOOD = wood("stripped_glow_wood", MaterialColor.WOOD, 15);
    public static final RegistryObject<Block> GLOW_LEAVES = register("glow_leaves", () -> new LeavesBlock(copy(Blocks.OAK_LEAVES).lightLevel(s -> 11)));
    public static final RegistryObject<Block> GLOW_LOG = register("glow_log", () -> glowLog(STRIPPED_GLOW_LOG, MaterialColor.PODZOL));
    public static final RegistryObject<Block> GLOW_WOOD = register("glow_wood", () -> glowLog(STRIPPED_GLOW_WOOD, MaterialColor.WOOD));
    public static final RegistryObject<Block> GLOW_PLANKS = normal("glow_planks", copy(Blocks.OAK_PLANKS).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_SLAB = slab("glow_slab", copy(Blocks.OAK_SLAB).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_DOOR = door("glow_door", copy(Blocks.OAK_DOOR).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_FENCE = fence("glow_fence", copy(Blocks.OAK_FENCE).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_TRAPDOOR = trapdoor("glow_trapdoor", copy(Blocks.OAK_TRAPDOOR).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_STAIRS = stair("glow_stairs", GLOW_PLANKS, copy(Blocks.OAK_STAIRS).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_BUTTON = button("glow_button", true, copy(Blocks.OAK_BUTTON).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_FENCE_GATE = fenceGate("glow_fence_gate", copy(Blocks.OAK_FENCE_GATE).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_PRESSURE_PLATE = pressurePlate("glow_pressure_plate", copy(Blocks.OAK_PRESSURE_PLATE).lightLevel(s -> 1));
    public static final RegistryObject<Block> GLOW_SAPLING = register("glow_sapling", () -> new SaplingBlock(new GlowTreeGrower(), copy(Blocks.OAK_SAPLING)));
    //Plants, ores and other natural blocks
    public static final RegistryObject<Block> GLOW_GRASS = register("glow_grass", () -> new TallGrassBlock(copy(Blocks.GRASS).lightLevel(s -> 7)));
    public static final RegistryObject<Block> GLOW_MOSS = register("glow_moss", () -> new TallGrassBlock(copy(Blocks.BROWN_MUSHROOM).lightLevel(s -> 3)));
    public static final RegistryObject<Block> ABYSMAL_SEA_ROCK = normal("abysmal_sea_rock", defaultProperties().strength(2.5F, 6.0F));
    public static final RegistryObject<Block> RAW_CHROMITE_BLOCK = normal("raw_chromite_block", defaultProperties().strength(5.0F, 6.0F));
    public static final RegistryObject<Block> CHROMITE_BLOCK = normal("chromite_block", defaultProperties().strength(6.0F));
    public static final RegistryObject<Block> SUCK_BLOOD_WART_BLOCK = register("suck_blood_wart_block", SuckBloodWartBlock::new);
    public static final RegistryObject<Block> MAGNETIC_STORM_VENT = register("magnetic_storm_vent", MagneticStormVent::new);
    public static final RegistryObject<Block> RED_HOT_IRON_SAND = register("red_hot_iron_sand", RedHotIronSand::new);
    public static final RegistryObject<Block> BLOODY_BLACKSTONE = normal("bloody_blackstone", copy(Blocks.STONE));
    public static final RegistryObject<Block> DESERT_BUSH = register("desert_bush", DesertBush::new);
    public static final RegistryObject<Block> BLACK_SMOKER = register("black_smoker", BlackSmoker::new);
    public static final RegistryObject<Block> COMBUSTIBLE_ICE = normal("combustible_ice", copy(Blocks.ICE));
    public static final RegistryObject<Block> DEEP_NETHERRACK = register("deep_netherrack", DeepNetherrack::new);
    public static final RegistryObject<Block> DEEP_NETHER_CHROMITE_ORE = ore("deep_nether_chromite_ore", copy(Blocks.STONE));
    public static final RegistryObject<Block> IRON_SAND = register("iron_sand", IronSand::new);
    public static final RegistryObject<Block> IRON_SANDSTONE = normal("iron_sandstone", defaultProperties().strength(1.0F, 40.0F));
    public static final RegistryObject<Block> OCEANICEND_STONE = register("oceanicend_stone", () -> new RotatedPillarBlock(defaultProperties().strength(3.2F, 9.0F)));
    public static final RegistryObject<Block> COBBLED_OCEANICEND_STONE = normal("cobbled_oceanicend_stone", defaultProperties().strength(2.8F, 6.0F));
    public static final RegistryObject<Block> KIMBERLITE = ore("kimberlite", defaultProperties().strength(2.0F, 5.0F));
    public static final RegistryObject<Block> ENRICHED_IRON_ORE = ore("enriched_iron_ore", defaultProperties().strength(2.5F, 6.0F));
    public static final RegistryObject<Block> SULFUR_ORE = ore("sulfur_ore", defaultProperties().strength(2.0F, 6.0F));
    public static final RegistryObject<Block> SULFUR_BLOCK = normal("sulfur_block", defaultProperties().strength(1.5F, 5.0F));
    public static final RegistryObject<Block> ELDEN_FERN = register("elden_fern", () -> new TallGrassBlock(copy(Blocks.GRASS)));
    public static final RegistryObject<Block> GLOSSOPTERIS = register("glossopteris", () -> new TallGrassBlock(copy(Blocks.GRASS)));
    public static final RegistryObject<Block> UNDERWATER_FUNGUS_BLOCK = register("underwater_fungus_block", UnderwaterFungusBlock::new);
    public static final RegistryObject<Block> UNDERWATER_FUNGUS = register("underwater_fungus", UnderwaterFungus::new);
    public static final RegistryObject<Block> ROTTEN_FLESH_BLOCK = register("rotten_flesh_block", RottenFleshBlock::new);
    public static final RegistryObject<Block> PALOLO_WORM_HOLE = register("palolo_worm_hole", PaloloWormHole::new);
    //Iron and Rust
    public static final RegistryObject<Block> IRON_PLATE_BLOCK = normal("iron_plate_block", copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> CUT_IRON_PLATE_BLOCK = normal("cut_iron_plate_block", copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> RUSTINESS_IRON_PLATE_BLOCK = normal("rustiness_iron_plate_block", copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> CUT_RUSTINESS_IRON_PLATE_BLOCK = normal("cut_rustiness_iron_plate_block", copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> IRON_PLATE_SLAB = slab("iron_plate_slab", copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> CUT_IRON_PLATE_SLAB = slab("cut_iron_plate_slab", copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> RUSTINESS_IRON_PLATE_SLAB = slab("rustiness_iron_plate_slab", copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> CUT_RUSTINESS_IRON_PLATE_SLAB = slab("cut_rustiness_iron_plate_slab", copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> IRON_PLATE_STAIRS = stair("iron_plate_stairs", IRON_PLATE_BLOCK, copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> CUT_IRON_PLATE_STAIRS = stair("cut_iron_plate_stairs", CUT_IRON_PLATE_BLOCK, copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> RUSTINESS_IRON_PLATE_STAIRS = stair("rustiness_iron_plate_stairs", RUSTINESS_IRON_PLATE_BLOCK, copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> CUT_RUSTINESS_IRON_PLATE_STAIRS = stair("cut_rustiness_iron_plate_stairs", CUT_RUSTINESS_IRON_PLATE_BLOCK, copy(Blocks.GOLD_BLOCK));
    public static final RegistryObject<Block> RUST_BLOCK = normal("rust_block", defaultProperties().strength(2.5F, 3.0F));
    public static final RegistryObject<Block> RUST_PILLAR = normal("rust_pillar", defaultProperties().strength(2.5F, 3.0F));
    public static final RegistryObject<Block> RUST_PILE = normal("rust_pile", defaultProperties().strength(2.0F, 3.0F));
    //Cycas Trees
    public static final RegistryObject<Block> STRIPPED_CYCAS_LOG = register("stripped_cycas_log", () -> Blocks.log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final RegistryObject<Block> STRIPPED_CYCAS_WOOD = wood("stripped_cycas_wood", MaterialColor.WOOD, 0);
    public static final RegistryObject<Block> CYCAS_LEAVES = register("cycas_leaves", () -> Blocks.leaves(SoundType.GRASS));
    public static final RegistryObject<Block> CYCAS_LOG = register("cycas_log", () -> new CycasLog(STRIPPED_CYCAS_LOG));
    public static final RegistryObject<Block> CYCAS_WOOD = register("cycas_wood", () -> new CycasLog(STRIPPED_CYCAS_WOOD));
    public static final RegistryObject<Block> CYCAS_PLANKS = normal("cycas_planks", cycasProperties());
    public static final RegistryObject<Block> CYCAS_SLAB = slab("cycas_slab", cycasProperties());
    public static final RegistryObject<Block> CYCAS_DOOR = door("cycas_door", cycasProperties());
    public static final RegistryObject<Block> CYCAS_FENCE = fence("cycas_fence", cycasProperties());
    public static final RegistryObject<Block> CYCAS_TRAPDOOR = trapdoor("cycas_trapdoor", cycasProperties());
    public static final RegistryObject<Block> CYCAS_FENCE_GATE = fenceGate("cycas_fence_gate", cycasProperties());
    public static final RegistryObject<Block> CYCAS_STAIRS = stair("cycas_stairs", CYCAS_PLANKS, cycasProperties());
    public static final RegistryObject<Block> CYCAS_BUTTON = button("cycas_button", true, cycasProperties());
    public static final RegistryObject<Block> CYCAS_PRESSURE_PLATE = pressurePlate("cycas_pressure_plate", cycasProperties());
    public static final RegistryObject<Block> CYCAS_SAPLING = register("cycas_sapling",
            () -> new SaplingBlock(new CycasGrower(), copy(Blocks.OAK_SAPLING)));
    //Maple Trees
    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = register("stripped_maple_log", () -> Blocks.log(MaterialColor.WOOD, MaterialColor.PODZOL));
    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = wood("stripped_maple_wood", MaterialColor.WOOD, 0);
    public static final RegistryObject<Block> MAPLE_LEAVES = register("maple_leaves", () -> Blocks.leaves(SoundType.GRASS));
//    public static final RegistryObject<Block> MAPLE_LOG = register("maple_log", () -> new MapleLog(copy(Blocks.SPRUCE_LOG)));
    public static final RegistryObject<Block> MAPLE_WOOD = register("maple_wood", () -> new AxeStrippedBlock(STRIPPED_MAPLE_WOOD, copy(Blocks.SPRUCE_WOOD)));
    public static final RegistryObject<Block> MAPLE_PLANKS = normal("maple_planks", copy(Blocks.SPRUCE_PLANKS));
    public static final RegistryObject<Block> MAPLE_SLAB = slab("maple_slab", copy(Blocks.SPRUCE_SLAB));
    public static final RegistryObject<Block> MAPLE_DOOR = door("maple_door", copy(Blocks.SPRUCE_DOOR));
    public static final RegistryObject<Block> MAPLE_FENCE = fence("maple_fence", copy(Blocks.SPRUCE_FENCE));
    public static final RegistryObject<Block> MAPLE_TRAPDOOR = trapdoor("maple_trapdoor", copy(Blocks.SPRUCE_TRAPDOOR));
    public static final RegistryObject<Block> MAPLE_FENCE_GATE = fenceGate("maple_fence_gate", copy(Blocks.SPRUCE_FENCE_GATE));
    public static final RegistryObject<Block> MAPLE_STAIRS = stair("maple_stairs", MAPLE_PLANKS, copy(Blocks.SPRUCE_STAIRS));
    public static final RegistryObject<Block> MAPLE_BUTTON = button("maple_button", true, copy(Blocks.SPRUCE_BUTTON));
    public static final RegistryObject<Block> MAPLE_PRESSURE_PLATE = pressurePlate("maple_pressure_plate", copy(Blocks.SPRUCE_PRESSURE_PLATE));
    public static final RegistryObject<Block> MAPLE_SAPLING = register("maple_sapling", () -> new SaplingBlock(new MapleGrower(), copy(Blocks.OAK_SAPLING)));
    //Ash Trees
    public static final RegistryObject<Block> ASHES_LEAVES = register("ashes_leaves", () -> Blocks.leaves(SoundType.WOOL));
    public static final RegistryObject<Block> ASHES_LOG = register("ashes_log", () -> Blocks.log(MaterialColor.COLOR_GRAY, MaterialColor.COLOR_BLACK));
    public static final RegistryObject<Block> ASHES_WOOD = wood("ashes_wood", MaterialColor.COLOR_GRAY, 0);
    public static final RegistryObject<Block> ASH_BLOCK = register("ash_block", () -> new FallingBlock(
            BlockBehaviour.Properties.of(Material.STONE).strength(2.0F).requiresCorrectToolForDrops().sound(SoundType.WOOL)));
    public static final RegistryObject<Block> ASH_PILE = register("ash_pile", AshPile::new);
    //Potted Plants
    public static final RegistryObject<Block> POTTED_GLOW_SAPLING = flowerPot("potted_glow_sapling", GLOW_SAPLING);
    public static final RegistryObject<Block> POTTED_CYCAS_SAPLING = flowerPot("potted_cycas_sapling", CYCAS_SAPLING);
    public static final RegistryObject<Block> POTTED_MAPLE_SAPLING = flowerPot("potted_maple_sapling", MAPLE_SAPLING);
    public static final RegistryObject<Block> POTTED_ELDEN_FERN = flowerPot("potted_elden_fern", ELDEN_FERN);
    public static final RegistryObject<Block> POTTED_GLOSSOPTERIS = flowerPot("potted_glossopteris", GLOSSOPTERIS);
    public static final RegistryObject<Block> POTTED_UNDERWATER_FUNGUS = flowerPot("potted_underwater_fungus", UNDERWATER_FUNGUS);

    private static RotatedPillarBlock glowLog(Supplier<Block> strippedBlock, MaterialColor barkColor) {
        return new AxeStrippedBlock(strippedBlock, BlockBehaviour.Properties.of(Material.WOOD, (state) ->
               state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : barkColor)
                .strength(2.0F).sound(SoundType.WOOD).lightLevel(s -> 15));
    }

    private static BlockBehaviour.Properties defaultProperties() {
       return BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops();
    }

    private static BlockBehaviour.Properties cycasProperties() {
        return BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).strength(4.0F, 5.0F);
    }

    private static BlockBehaviour.Properties copy(BlockBehaviour blockBehaviour) {
        return BlockBehaviour.Properties.copy(blockBehaviour);
    }

}