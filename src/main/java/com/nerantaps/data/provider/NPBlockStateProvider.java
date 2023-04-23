package com.nerantaps.data.provider;

import com.nerantaps.NerantaPs;
import com.nerantaps.blocks.SuckBloodWartBlock;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

@SuppressWarnings("unused")
public class NPBlockStateProvider extends BlockStateProvider {

    protected static final ResourceLocation SOLID = new ResourceLocation("solid");
    protected static final ResourceLocation CUTOUT = new ResourceLocation("cutout");
    protected static final ResourceLocation CUTOUT_MIPPED = new ResourceLocation("cutout_mipped");
    protected static final ResourceLocation TRANSLUCENT = new ResourceLocation("translucent");

    public NPBlockStateProvider(DataGenerator generator, ExistingFileHelper exFileHelper) {
        super(generator, NerantaPs.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(NPBlocks.IRON_SAND.get());
//        this.simpleBlock(NPBlocks.RUST_PILE.get());
        this.simpleBlock(NPBlocks.RUST_BLOCK.get());
//        this.simpleBlock(NPBlocks.RUST_PILLAR.get());
        this.simpleBlock(NPBlocks.KIMBERLITE.get());
        this.simpleBlock(NPBlocks.SULFUR_ORE.get());
        this.simpleBlock(NPBlocks.DESERT_BUSH.get());
        this.simpleBlock(NPBlocks.GLOW_PLANKS.get());
        this.simpleBlock(NPBlocks.CYCAS_PLANKS.get());
        this.simpleBlock(NPBlocks.MAPLE_PLANKS.get());
        this.simpleBlock(NPBlocks.SULFUR_BLOCK.get());
        this.simpleBlock(NPBlocks.CHROMITE_BLOCK.get());
        this.simpleBlock(NPBlocks.IRON_SANDSTONE.get());
        this.simpleBlock(NPBlocks.DEEP_NETHERRACK.get());
        this.simpleBlock(NPBlocks.ABYSMAL_SEA_ROCK.get());
        this.simpleBlock(NPBlocks.RED_HOT_IRON_SAND.get());
        this.simpleBlock(NPBlocks.ENRICHED_IRON_ORE.get());
        this.simpleBlock(NPBlocks.BLOODY_BLACKSTONE.get());
        this.simpleBlock(NPBlocks.ROTTEN_FLESH_BLOCK.get());
        this.simpleBlock(NPBlocks.RAW_CHROMITE_BLOCK.get());
        this.simpleBlock(NPBlocks.UNDERWATER_FUNGUS_BLOCK.get());
        this.simpleBlock(NPBlocks.COBBLED_OCEANICEND_STONE.get());
        this.simpleBlock(NPBlocks.DEEP_NETHER_CHROMITE_ORE.get());
        this.simpleBlock(NPBlocks.IRON_PLATE_BLOCK.get());
        this.simpleBlock(NPBlocks.CUT_IRON_PLATE_BLOCK.get());
        this.simpleBlock(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get());
        this.simpleBlock(NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get());
        this.pottedPlants(NPBlocks.POTTED_ELDEN_FERN.get());
        this.pottedPlants(NPBlocks.POTTED_GLOSSOPTERIS.get());
        this.pottedPlants(NPBlocks.POTTED_GLOW_SAPLING.get());
        this.pottedPlants(NPBlocks.POTTED_CYCAS_SAPLING.get());
        this.pottedPlants(NPBlocks.POTTED_MAPLE_SAPLING.get());
        this.pottedPlants(NPBlocks.POTTED_UNDERWATER_FUNGUS.get());
        this.logBlock((RotatedPillarBlock) NPBlocks.GLOW_LOG.get());
        this.logBlock((RotatedPillarBlock) NPBlocks.CYCAS_LOG.get());
//        this.logBlock((RotatedPillarBlock) NPBlocks.MAPLE_LOG.get());
        this.logBlock((RotatedPillarBlock) NPBlocks.STRIPPED_GLOW_LOG.get());
        this.logBlock((RotatedPillarBlock) NPBlocks.STRIPPED_CYCAS_LOG.get());
        this.logBlock((RotatedPillarBlock) NPBlocks.STRIPPED_MAPLE_LOG.get());
        this.simpleBlockWithRenderType(NPBlocks.GLOW_LEAVES.get(), CUTOUT_MIPPED);
        this.simpleBlockWithRenderType(NPBlocks.CYCAS_LEAVES.get(), CUTOUT_MIPPED);
        this.simpleBlockWithRenderType(NPBlocks.MAPLE_LEAVES.get(), CUTOUT_MIPPED);
        this.simpleBlockWithRenderType(NPBlocks.COMBUSTIBLE_ICE.get(), TRANSLUCENT);
        this.getVariantBuilder(NPBlocks.SUCK_BLOOD_WART_BLOCK.get())
                .partialState().with(SuckBloodWartBlock.FULL, false)
                .addModels(new ConfiguredModel(this.models().cubeColumn("suck_blood_wart_block",
                        NerantaPs.prefix("block/suck_blood_wart_block_1"),
                        NerantaPs.prefix("block/suck_blood_wart_block_top"))))
                .partialState().with(SuckBloodWartBlock.FULL, true)
                .addModels(new ConfiguredModel(this.models().cubeColumn("suck_blood_wart_block_full",
                        NerantaPs.prefix("block/suck_blood_wart_block_2"),
                        NerantaPs.prefix("block/suck_blood_wart_block_top"))));
        this.axisBlock((RotatedPillarBlock) NPBlocks.GLOW_WOOD.get(),
                NerantaPs.prefix("block/glow_log"), NerantaPs.prefix("block/glow_log"));
        this.axisBlock((RotatedPillarBlock) NPBlocks.CYCAS_WOOD.get(),
                NerantaPs.prefix("block/cycas_log"), NerantaPs.prefix("block/cycas_log"));
        this.axisBlock((RotatedPillarBlock) NPBlocks.MAPLE_WOOD.get(),
                NerantaPs.prefix("block/maple_log"), NerantaPs.prefix("block/maple_log"));
        this.axisBlock((RotatedPillarBlock) NPBlocks.STRIPPED_GLOW_WOOD.get(),
                NerantaPs.prefix("block/stripped_glow_log"), NerantaPs.prefix("block/stripped_glow_log"));
        this.axisBlock((RotatedPillarBlock) NPBlocks.STRIPPED_CYCAS_WOOD.get(),
                NerantaPs.prefix("block/stripped_cycas_log"), NerantaPs.prefix("block/stripped_cycas_log"));
        this.axisBlock((RotatedPillarBlock) NPBlocks.STRIPPED_MAPLE_WOOD.get(),
                NerantaPs.prefix("block/stripped_maple_log"), NerantaPs.prefix("block/stripped_maple_log"));
        this.axisBlock((RotatedPillarBlock) NPBlocks.OCEANICEND_STONE.get(), NerantaPs.prefix("block/oceanicend_stone"));
        this.simpleBlockItem(NPBlocks.GLOW_WOOD.get(), this.models().cubeColumn("glow_wood",
                NerantaPs.prefix("block/glow_log"), NerantaPs.prefix("block/glow_log")));
        this.simpleBlockItem(NPBlocks.GLOW_LEAVES.get(), this.cubeAll(NPBlocks.GLOW_LEAVES.get()));
        this.simpleBlockItem(NPBlocks.GLOW_PLANKS.get(), this.cubeAll(NPBlocks.GLOW_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.CYCAS_WOOD.get(), this.models().cubeColumn("cycas_wood",
                NerantaPs.prefix("block/cycas_log"), NerantaPs.prefix("block/cycas_log")));
        this.simpleBlockItem(NPBlocks.CYCAS_LEAVES.get(), this.cubeAll(NPBlocks.CYCAS_LEAVES.get()));
        this.simpleBlockItem(NPBlocks.CYCAS_PLANKS.get(), this.cubeAll(NPBlocks.CYCAS_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.MAPLE_WOOD.get(), this.models().cubeColumn("maple_wood",
                NerantaPs.prefix("block/maple_log"), NerantaPs.prefix("block/maple_log")));
        this.simpleBlockItem(NPBlocks.MAPLE_LEAVES.get(), this.cubeAll(NPBlocks.MAPLE_LEAVES.get()));
        this.simpleBlockItem(NPBlocks.MAPLE_PLANKS.get(), this.cubeAll(NPBlocks.MAPLE_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.IRON_SAND.get(), this.cubeAll(NPBlocks.IRON_SAND.get()));
        this.simpleBlockItem(NPBlocks.KIMBERLITE.get(), this.cubeAll(NPBlocks.KIMBERLITE.get()));
        this.simpleBlockItem(NPBlocks.SULFUR_ORE.get(), this.cubeAll(NPBlocks.SULFUR_ORE.get()));
        this.simpleBlockItem(NPBlocks.DESERT_BUSH.get(), this.cubeAll(NPBlocks.DESERT_BUSH.get()));
        this.simpleBlockItem(NPBlocks.SULFUR_BLOCK.get(), this.cubeAll(NPBlocks.SULFUR_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.IRON_SANDSTONE.get(), this.cubeAll(NPBlocks.IRON_SANDSTONE.get()));
        this.simpleBlockItem(NPBlocks.COMBUSTIBLE_ICE.get(), this.cubeAll(NPBlocks.COMBUSTIBLE_ICE.get()));
        this.simpleBlockItem(NPBlocks.ABYSMAL_SEA_ROCK.get(), this.cubeAll(NPBlocks.ABYSMAL_SEA_ROCK.get()));
        this.simpleBlockItem(NPBlocks.RED_HOT_IRON_SAND.get(), this.cubeAll(NPBlocks.RED_HOT_IRON_SAND.get()));
        this.simpleBlockItem(NPBlocks.ENRICHED_IRON_ORE.get(), this.cubeAll(NPBlocks.ENRICHED_IRON_ORE.get()));
        this.simpleBlockItem(NPBlocks.ROTTEN_FLESH_BLOCK.get(), this.cubeAll(NPBlocks.ROTTEN_FLESH_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.UNDERWATER_FUNGUS_BLOCK.get(), this.cubeAll(NPBlocks.UNDERWATER_FUNGUS_BLOCK.get()));
        this.fenceBlock((FenceBlock) NPBlocks.GLOW_FENCE.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.fenceBlock((FenceBlock) NPBlocks.CYCAS_FENCE.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.fenceBlock((FenceBlock) NPBlocks.MAPLE_FENCE.get(), this.blockTexture(NPBlocks.MAPLE_PLANKS.get()));
        this.stairsBlock((StairBlock) NPBlocks.GLOW_STAIRS.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.stairsBlock((StairBlock) NPBlocks.CYCAS_STAIRS.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.stairsBlock((StairBlock) NPBlocks.MAPLE_STAIRS.get(), this.blockTexture(NPBlocks.MAPLE_PLANKS.get()));
        this.stairsBlock((StairBlock) NPBlocks.IRON_PLATE_STAIRS.get(), this.blockTexture(NPBlocks.IRON_PLATE_BLOCK.get()));
        this.stairsBlock((StairBlock) NPBlocks.CUT_IRON_PLATE_STAIRS.get(), this.blockTexture(NPBlocks.CUT_IRON_PLATE_BLOCK.get()));
        this.stairsBlock((StairBlock) NPBlocks.RUSTINESS_IRON_PLATE_STAIRS.get(), this.blockTexture(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get()));
        this.stairsBlock((StairBlock) NPBlocks.CUT_RUSTINESS_IRON_PLATE_STAIRS.get(), this.blockTexture(NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get()));
        this.buttonBlock((ButtonBlock) NPBlocks.GLOW_BUTTON.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.buttonBlock((ButtonBlock) NPBlocks.CYCAS_BUTTON.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.buttonBlock((ButtonBlock) NPBlocks.MAPLE_BUTTON.get(), this.blockTexture(NPBlocks.MAPLE_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) NPBlocks.GLOW_FENCE_GATE.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) NPBlocks.CYCAS_FENCE_GATE.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) NPBlocks.MAPLE_FENCE_GATE.get(), this.blockTexture(NPBlocks.MAPLE_PLANKS.get()));
        this.pressurePlateBlock((PressurePlateBlock) NPBlocks.GLOW_PRESSURE_PLATE.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.pressurePlateBlock((PressurePlateBlock) NPBlocks.CYCAS_PRESSURE_PLATE.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.pressurePlateBlock((PressurePlateBlock) NPBlocks.MAPLE_PRESSURE_PLATE.get(), this.blockTexture(NPBlocks.MAPLE_PLANKS.get()));
        this.slabBlock((SlabBlock) NPBlocks.GLOW_SLAB.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.slabBlock((SlabBlock) NPBlocks.CYCAS_SLAB.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.slabBlock((SlabBlock) NPBlocks.MAPLE_SLAB.get(), this.blockTexture(NPBlocks.MAPLE_PLANKS.get()), this.blockTexture(NPBlocks.MAPLE_PLANKS.get()));
        this.slabBlock((SlabBlock) NPBlocks.IRON_PLATE_SLAB.get(), this.blockTexture(NPBlocks.IRON_PLATE_BLOCK.get()), this.blockTexture(NPBlocks.IRON_PLATE_BLOCK.get()));
        this.slabBlock((SlabBlock) NPBlocks.CUT_IRON_PLATE_SLAB.get(), this.blockTexture(NPBlocks.CUT_IRON_PLATE_BLOCK.get()), this.blockTexture(NPBlocks.CUT_IRON_PLATE_BLOCK.get()));
        this.slabBlock((SlabBlock) NPBlocks.RUSTINESS_IRON_PLATE_SLAB.get(), this.blockTexture(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get()),
                this.blockTexture(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get()));
        this.slabBlock((SlabBlock) NPBlocks.CUT_RUSTINESS_IRON_PLATE_SLAB.get(), this.blockTexture(NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get()),
                this.blockTexture(NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get()));
        this.trapdoorBlockWithRenderType((TrapDoorBlock) NPBlocks.GLOW_TRAPDOOR.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()), true, CUTOUT);
        this.trapdoorBlockWithRenderType((TrapDoorBlock) NPBlocks.CYCAS_TRAPDOOR.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()), true, CUTOUT);
        this.trapdoorBlockWithRenderType((TrapDoorBlock) NPBlocks.MAPLE_TRAPDOOR.get(), this.blockTexture(NPBlocks.MAPLE_PLANKS.get()), true, CUTOUT);
        this.doorBlockWithRenderType((DoorBlock) NPBlocks.GLOW_DOOR.get(), NerantaPs.prefix("block/glow_door_bottom"), NerantaPs.prefix("block/glow_door_top"), CUTOUT);
        this.doorBlockWithRenderType((DoorBlock) NPBlocks.CYCAS_DOOR.get(), NerantaPs.prefix("block/cycas_door_bottom"), NerantaPs.prefix("block/cycas_door_top"), CUTOUT);
        this.doorBlockWithRenderType((DoorBlock) NPBlocks.MAPLE_DOOR.get(), NerantaPs.prefix("block/maple_door_bottom"), NerantaPs.prefix("block/maple_door_top"), CUTOUT);
        this.simpleBlock(NPBlocks.BLACK_SMOKER.get(), this.models().cubeTop("black_smoker",
                NerantaPs.prefix("block/abysmal_sea_rock"), NerantaPs.prefix("block/black_smoker")));
        this.simpleBlock(NPBlocks.MAGNETIC_STORM_VENT.get(), this.models().cubeTop("magnetic_storm_vent",
                NerantaPs.prefix("block/magnetic_storm_vent"), NerantaPs.prefix("block/magnetic_storm_vent_top")));
        this.simpleBlock(NPBlocks.ELDEN_FERN.get(), this.models().cross("elden_fern", this.blockTexture(NPBlocks.ELDEN_FERN.get())).renderType(CUTOUT));
        this.simpleBlock(NPBlocks.GLOW_MOSS.get(), this.models().cross("glow_moss", this.blockTexture(NPBlocks.GLOW_MOSS.get())).renderType(CUTOUT));
        this.simpleBlock(NPBlocks.GLOW_GRASS.get(), this.models().cross("glow_grass", this.blockTexture(NPBlocks.GLOW_GRASS.get())).renderType(CUTOUT));
        this.simpleBlock(NPBlocks.GLOW_SAPLING.get(), this.models().cross("glow_sapling", this.blockTexture(NPBlocks.GLOW_SAPLING.get())).renderType(CUTOUT));
        this.simpleBlock(NPBlocks.GLOSSOPTERIS.get(), this.models().cross("glossopteris", this.blockTexture(NPBlocks.GLOSSOPTERIS.get())).renderType(CUTOUT));
        this.simpleBlock(NPBlocks.CYCAS_SAPLING.get(), this.models().cross("cycas_sapling", this.blockTexture(NPBlocks.CYCAS_SAPLING.get())).renderType(CUTOUT));
        this.simpleBlock(NPBlocks.MAPLE_SAPLING.get(), this.models().cross("maple_sapling", this.blockTexture(NPBlocks.MAPLE_SAPLING.get())).renderType(CUTOUT));
        this.simpleBlock(NPBlocks.UNDERWATER_FUNGUS.get(), this.models().crop("underwater_fungus", this.blockTexture(NPBlocks.UNDERWATER_FUNGUS.get())).renderType(CUTOUT));
        this.simpleBlockItem(NPBlocks.GLOW_STAIRS.get(), this.normalStairs(NPBlocks.GLOW_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.CYCAS_STAIRS.get(), this.normalStairs(NPBlocks.CYCAS_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.MAPLE_STAIRS.get(), this.normalStairs(NPBlocks.MAPLE_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.IRON_PLATE_STAIRS.get(), this.normalStairs(NPBlocks.IRON_PLATE_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.CUT_IRON_PLATE_STAIRS.get(), this.normalStairs(NPBlocks.CUT_IRON_PLATE_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.RUSTINESS_IRON_PLATE_STAIRS.get(), this.normalStairs(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.CUT_RUSTINESS_IRON_PLATE_SLAB.get(), this.normalStairs(NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.GLOW_FENCE.get(), this.models().fenceInventory("glow_fence", this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_FENCE.get(), this.models().fenceInventory("cycas_fence", this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.MAPLE_FENCE.get(), this.models().fenceInventory("maple_fence", this.blockTexture(NPBlocks.MAPLE_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_FENCE_GATE.get(), this.models().fenceGate("glow_fence_gate", this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_FENCE_GATE.get(), this.models().fenceGate("cycas_fence_gate", this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.MAPLE_FENCE_GATE.get(), this.models().fenceGate("maple_fence_gate", this.blockTexture(NPBlocks.MAPLE_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_TRAPDOOR.get(), this.models().trapdoorBottom("glow_trapdoor", this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_TRAPDOOR.get(), this.models().trapdoorBottom("cycas_trapdoor", this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.MAPLE_TRAPDOOR.get(), this.models().trapdoorBottom("maple_trapdoor", this.blockTexture(NPBlocks.MAPLE_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_PRESSURE_PLATE.get(), this.models().pressurePlate("glow_pressure_plate", this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_PRESSURE_PLATE.get(), this.models().pressurePlate("cycas_pressure_plate", this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.MAPLE_PRESSURE_PLATE.get(), this.models().pressurePlate("maple_pressure_plate", this.blockTexture(NPBlocks.MAPLE_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_SLAB.get(), this.normalSlab(NPBlocks.GLOW_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.CYCAS_SLAB.get(), this.normalSlab(NPBlocks.CYCAS_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.MAPLE_SLAB.get(), this.normalSlab(NPBlocks.MAPLE_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.IRON_PLATE_SLAB.get(), this.normalSlab(NPBlocks.IRON_PLATE_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.CUT_IRON_PLATE_SLAB.get(), this.normalSlab(NPBlocks.CUT_IRON_PLATE_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.RUSTINESS_IRON_PLATE_SLAB.get(), this.normalSlab(NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.CUT_RUSTINESS_IRON_PLATE_SLAB.get(), this.normalSlab(NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.GLOW_LOG.get(), this.models().cubeColumn("glow_log",
                NerantaPs.prefix("block/glow_log"), NerantaPs.prefix("block/glow_log_top")));
        this.simpleBlockItem(NPBlocks.CYCAS_LOG.get(), this.models().cubeColumn("cycas_log",
                NerantaPs.prefix("block/cycas_log"), NerantaPs.prefix("block/cycas_log_top")));
        this.simpleBlockItem(NPBlocks.MAPLE_LOG.get(), this.models().cubeColumn("maple_log",
                NerantaPs.prefix("block/maple_log"), NerantaPs.prefix("block/maple_log_top")));
        this.simpleBlockItem(NPBlocks.STRIPPED_GLOW_LOG.get(), this.models().cubeColumn("stripped_glow_log",
                NerantaPs.prefix("block/stripped_glow_log"), NerantaPs.prefix("block/stripped_glow_log_top")));
        this.simpleBlockItem(NPBlocks.STRIPPED_CYCAS_LOG.get(), this.models().cubeColumn("stripped_cycas_log",
                NerantaPs.prefix("block/stripped_cycas_log"), NerantaPs.prefix("block/stripped_cycas_log_top")));
        this.simpleBlockItem(NPBlocks.STRIPPED_MAPLE_LOG.get(), this.models().cubeColumn("stripped_maple_log",
                NerantaPs.prefix("block/stripped_maple_log"), NerantaPs.prefix("block/stripped_maple_log_top")));
        this.simpleBlockItem(NPBlocks.STRIPPED_GLOW_WOOD.get(), this.models().cubeColumn("stripped_glow_wood",
                NerantaPs.prefix("block/stripped_glow_log"), NerantaPs.prefix("block/stripped_glow_log")));
        this.simpleBlockItem(NPBlocks.STRIPPED_CYCAS_WOOD.get(), this.models().cubeColumn("stripped_cycas_wood",
                NerantaPs.prefix("block/stripped_cycas_log"), NerantaPs.prefix("block/stripped_cycas_log")));
        this.simpleBlockItem(NPBlocks.STRIPPED_MAPLE_WOOD.get(), this.models().cubeColumn("stripped_maple_wood",
                NerantaPs.prefix("block/stripped_maple_log"), NerantaPs.prefix("block/stripped_maple_log")));
        this.simpleBlockItem(NPBlocks.BLACK_SMOKER.get(), this.models().cubeTop("black_smoker",
                NerantaPs.prefix("block/abysmal_sea_rock"), NerantaPs.prefix("block/black_smoker")));
        this.simpleBlockItem(NPBlocks.MAGNETIC_STORM_VENT.get(), this.models().cubeTop("magnetic_storm_vent",
                NerantaPs.prefix("block/magnetic_storm_vent"), NerantaPs.prefix("block/magnetic_storm_vent_top")));
    }

    public void simpleBlockWithRenderType(Block block, ResourceLocation type) {
        simpleBlock(block, models().cubeAll(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath(), blockTexture(block)).renderType(type));
    }

    private void pottedPlants(Block block) {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        this.simpleBlock(block, this.models().withExistingParent(name, "block/flower_pot_cross")
                .renderType(CUTOUT).texture("plant", this.blockTexture(block)));
    }

    private ModelFile normalStairs(Block block) {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        return this.models().stairs(name, this.blockTexture(block), this.blockTexture(block), this.blockTexture(block));
    }

    private ModelFile normalSlab(Block block) {
        String name = Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
        return this.models().slab(name, this.blockTexture(block), this.blockTexture(block), this.blockTexture(block));
    }

}