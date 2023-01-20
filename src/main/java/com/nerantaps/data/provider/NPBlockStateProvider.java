package com.nerantaps.data.provider;

import com.nerantaps.NerantaPs;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class NPBlockStateProvider extends BlockStateProvider {

    public NPBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, NerantaPs.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.simpleBlock(NPBlocks.IRON_SAND.get());
        this.simpleBlock(NPBlocks.KIMBERLITE.get());
        this.simpleBlock(NPBlocks.SULFUR_ORE.get());
        this.simpleBlock(NPBlocks.DESERT_BUSH.get());
        this.simpleBlock(NPBlocks.GLOW_LEAVES.get());
        this.simpleBlock(NPBlocks.GLOW_PLANKS.get());
        this.simpleBlock(NPBlocks.SULFUR_BLOCK.get());
        this.simpleBlock(NPBlocks.CYCAS_LEAVES.get());
        this.simpleBlock(NPBlocks.CYCAS_PLANKS.get());
        this.simpleBlock(NPBlocks.IRON_SANDSTONE.get());
        this.simpleBlock(NPBlocks.COMBUSTIBLE_ICE.get());
        this.simpleBlock(NPBlocks.ABYSMAL_SEA_ROCK.get());
        this.simpleBlock(NPBlocks.RED_HOT_IRON_SAND.get());
        this.simpleBlock(NPBlocks.ENRICHED_IRON_ORE.get());
        this.simpleBlock(NPBlocks.ROTTEN_FLESH_BLOCK.get());
        this.simpleBlock(NPBlocks.UNDERWATER_FUNGUS_BLOCK.get());
        this.logBlock((RotatedPillarBlock) NPBlocks.GLOW_LOG.get());
        this.logBlock((RotatedPillarBlock) NPBlocks.CYCAS_LOG.get());
        this.logBlock((RotatedPillarBlock) NPBlocks.STRIPPED_GLOW_LOG.get());
        this.logBlock((RotatedPillarBlock) NPBlocks.STRIPPED_CYCAS_LOG.get());
        this.axisBlock((RotatedPillarBlock) NPBlocks.GLOW_WOOD.get(),
                NerantaPs.prefix("block/glow_log"), NerantaPs.prefix("block/glow_log"));
        this.axisBlock((RotatedPillarBlock) NPBlocks.CYCAS_WOOD.get(),
                NerantaPs.prefix("block/cycas_log"), NerantaPs.prefix("block/cycas_log"));
        this.axisBlock((RotatedPillarBlock) NPBlocks.STRIPPED_GLOW_WOOD.get(),
                NerantaPs.prefix("block/stripped_glow_log"), NerantaPs.prefix("block/stripped_glow_log"));
        this.axisBlock((RotatedPillarBlock) NPBlocks.STRIPPED_CYCAS_WOOD.get(),
                NerantaPs.prefix("block/stripped_cycas_log"), NerantaPs.prefix("block/stripped_cycas_log"));
        this.simpleBlockItem(NPBlocks.IRON_SAND.get(), this.cubeAll(NPBlocks.IRON_SAND.get()));
        this.simpleBlockItem(NPBlocks.GLOW_WOOD.get(), this.models().cubeColumn("glow_wood",
                NerantaPs.prefix("block/glow_log"), NerantaPs.prefix("block/glow_log")));
        this.simpleBlockItem(NPBlocks.GLOW_LEAVES.get(), this.cubeAll(NPBlocks.GLOW_LEAVES.get()));
        this.simpleBlockItem(NPBlocks.GLOW_PLANKS.get(), this.cubeAll(NPBlocks.GLOW_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.KIMBERLITE.get(), this.cubeAll(NPBlocks.KIMBERLITE.get()));
        this.simpleBlockItem(NPBlocks.SULFUR_ORE.get(), this.cubeAll(NPBlocks.SULFUR_ORE.get()));
        this.simpleBlockItem(NPBlocks.DESERT_BUSH.get(), this.cubeAll(NPBlocks.DESERT_BUSH.get()));
        this.simpleBlockItem(NPBlocks.CYCAS_WOOD.get(), this.models().cubeColumn("cycas_wood",
                NerantaPs.prefix("block/cycas_log"), NerantaPs.prefix("block/cycas_log")));
        this.simpleBlockItem(NPBlocks.CYCAS_LEAVES.get(), this.cubeAll(NPBlocks.CYCAS_LEAVES.get()));
        this.simpleBlockItem(NPBlocks.CYCAS_PLANKS.get(), this.cubeAll(NPBlocks.CYCAS_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.SULFUR_BLOCK.get(), this.cubeAll(NPBlocks.SULFUR_BLOCK.get()));
        this.simpleBlockItem(NPBlocks.IRON_SANDSTONE.get(), this.cubeAll(NPBlocks.IRON_SANDSTONE.get()));
        this.simpleBlockItem(NPBlocks.COMBUSTIBLE_ICE.get(), this.cubeAll(NPBlocks.COMBUSTIBLE_ICE.get()));
        this.simpleBlockItem(NPBlocks.ABYSMAL_SEA_ROCK.get(), this.cubeAll(NPBlocks.ABYSMAL_SEA_ROCK.get()));
        this.simpleBlockItem(NPBlocks.RED_HOT_IRON_SAND.get(), this.cubeAll(NPBlocks.RED_HOT_IRON_SAND.get()));
        this.simpleBlockItem(NPBlocks.ENRICHED_IRON_ORE.get(), this.cubeAll(NPBlocks.ENRICHED_IRON_ORE.get()));
        this.simpleBlockItem(NPBlocks.ROTTEN_FLESH_BLOCK.get(), this.cubeAll(NPBlocks.ROTTEN_FLESH_BLOCK.get()));
        this.fenceBlock((FenceBlock) NPBlocks.GLOW_FENCE.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.fenceBlock((FenceBlock) NPBlocks.CYCAS_FENCE.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.stairsBlock((StairBlock) NPBlocks.GLOW_STAIRS.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.stairsBlock((StairBlock) NPBlocks.CYCAS_STAIRS.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.buttonBlock((ButtonBlock) NPBlocks.GLOW_BUTTON.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.buttonBlock((ButtonBlock) NPBlocks.CYCAS_BUTTON.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.simpleBlockItem(NPBlocks.UNDERWATER_FUNGUS_BLOCK.get(), this.cubeAll(NPBlocks.UNDERWATER_FUNGUS_BLOCK.get()));
        this.fenceGateBlock((FenceGateBlock) NPBlocks.GLOW_FENCE_GATE.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.fenceGateBlock((FenceGateBlock) NPBlocks.CYCAS_FENCE_GATE.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.trapdoorBlock((TrapDoorBlock) NPBlocks.GLOW_TRAPDOOR.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()), true);
        this.trapdoorBlock((TrapDoorBlock) NPBlocks.CYCAS_TRAPDOOR.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()), true);
        this.pressurePlateBlock((PressurePlateBlock) NPBlocks.GLOW_PRESSURE_PLATE.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.pressurePlateBlock((PressurePlateBlock) NPBlocks.CYCAS_PRESSURE_PLATE.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.slabBlock((SlabBlock) NPBlocks.GLOW_SLAB.get(), this.blockTexture(NPBlocks.GLOW_PLANKS.get()), this.blockTexture(NPBlocks.GLOW_PLANKS.get()));
        this.slabBlock((SlabBlock) NPBlocks.CYCAS_SLAB.get(), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()), this.blockTexture(NPBlocks.CYCAS_PLANKS.get()));
        this.doorBlock((DoorBlock) NPBlocks.GLOW_DOOR.get(), NerantaPs.prefix("block/glow_door_bottom"), NerantaPs.prefix("block/glow_door_top"));
        this.doorBlock((DoorBlock) NPBlocks.CYCAS_DOOR.get(), NerantaPs.prefix("block/cycas_door_bottom"), NerantaPs.prefix("block/cycas_door_top"));
        this.simpleBlock(NPBlocks.BLACK_SMOKER.get(), this.models().cubeTop("black_smoker",
                NerantaPs.prefix("block/abysmal_sea_rock"), NerantaPs.prefix("block/black_smoker")));
        this.simpleBlock(NPBlocks.MAGNETIC_STORM_VENT.get(), this.models().cubeTop("magnetic_storm_vent",
                NerantaPs.prefix("block/magnetic_storm_vent"), NerantaPs.prefix("block/magnetic_storm_vent_top")));
        this.simpleBlock(NPBlocks.ELDEN_FERN.get(), this.models().cross("elden_fern", this.blockTexture(NPBlocks.ELDEN_FERN.get())));
        this.simpleBlock(NPBlocks.GLOW_MOSS.get(), this.models().cross("glow_moss", this.blockTexture(NPBlocks.GLOW_MOSS.get())));
        this.simpleBlock(NPBlocks.GLOW_GRASS.get(), this.models().cross("glow_grass", this.blockTexture(NPBlocks.GLOW_GRASS.get())));
        this.simpleBlock(NPBlocks.GLOW_SAPLING.get(), this.models().cross("glow_sapling", this.blockTexture(NPBlocks.GLOW_SAPLING.get())));
        this.simpleBlock(NPBlocks.GLOSSOPTERIS.get(), this.models().cross("glossopteris", this.blockTexture(NPBlocks.GLOSSOPTERIS.get())));
        this.simpleBlock(NPBlocks.CYCAS_SAPLING.get(), this.models().cross("cycas_sapling", this.blockTexture(NPBlocks.CYCAS_SAPLING.get())));
        this.simpleBlock(NPBlocks.UNDERWATER_FUNGUS.get(), this.models().crop("underwater_fungus", this.blockTexture(NPBlocks.UNDERWATER_FUNGUS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_STAIRS.get(), this.models().stairs("glow_stairs", this.blockTexture(NPBlocks.GLOW_PLANKS.get()),
                this.blockTexture(NPBlocks.GLOW_PLANKS.get()), this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_STAIRS.get(), this.models().stairs("glow_stairs", this.blockTexture(NPBlocks.CYCAS_PLANKS.get()),
                this.blockTexture(NPBlocks.CYCAS_PLANKS.get()), this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_FENCE.get(), this.models().fenceInventory("glow_fence", this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_FENCE.get(), this.models().fenceInventory("cycas_fence", this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_FENCE_GATE.get(), this.models().fenceGate("glow_fence_gate", this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_FENCE_GATE.get(), this.models().fenceGate("cycas_fence_gate", this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_TRAPDOOR.get(), this.models().trapdoorBottom("glow_trapdoor", this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_TRAPDOOR.get(), this.models().trapdoorBottom("cycas_trapdoor", this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_PRESSURE_PLATE.get(), this.models().pressurePlate("glow_pressure_plate", this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_PRESSURE_PLATE.get(), this.models().pressurePlate("cycas_pressure_plate", this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_SLAB.get(), this.models().slab("glow_slab", this.blockTexture(NPBlocks.GLOW_PLANKS.get()),
                this.blockTexture(NPBlocks.GLOW_PLANKS.get()), this.blockTexture(NPBlocks.GLOW_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.CYCAS_SLAB.get(), this.models().slab("cycas_slab", this.blockTexture(NPBlocks.CYCAS_PLANKS.get()),
                this.blockTexture(NPBlocks.CYCAS_PLANKS.get()), this.blockTexture(NPBlocks.CYCAS_PLANKS.get())));
        this.simpleBlockItem(NPBlocks.GLOW_LOG.get(), this.models().cubeColumn("glow_log",
                NerantaPs.prefix("block/glow_log"), NerantaPs.prefix("block/glow_log_top")));
        this.simpleBlockItem(NPBlocks.CYCAS_LOG.get(), this.models().cubeColumn("cycas_log",
                NerantaPs.prefix("block/cycas_log"), NerantaPs.prefix("block/cycas_log_top")));
        this.simpleBlockItem(NPBlocks.STRIPPED_GLOW_LOG.get(), this.models().cubeColumn("stripped_glow_log",
                NerantaPs.prefix("block/stripped_glow_log"), NerantaPs.prefix("block/stripped_glow_log_top")));
        this.simpleBlockItem(NPBlocks.STRIPPED_CYCAS_LOG.get(), this.models().cubeColumn("stripped_cycas_log",
                NerantaPs.prefix("block/stripped_cycas_log"), NerantaPs.prefix("block/stripped_cycas_log_top")));
        this.simpleBlockItem(NPBlocks.STRIPPED_GLOW_WOOD.get(), this.models().cubeColumn("stripped_glow_wood",
                NerantaPs.prefix("block/stripped_glow_log"), NerantaPs.prefix("block/stripped_glow_log")));
        this.simpleBlockItem(NPBlocks.STRIPPED_CYCAS_WOOD.get(), this.models().cubeColumn("stripped_cycas_wood",
                NerantaPs.prefix("block/stripped_cycas_log"), NerantaPs.prefix("block/stripped_cycas_log")));
        this.simpleBlockItem(NPBlocks.BLACK_SMOKER.get(), this.models().cubeTop("black_smoker",
                NerantaPs.prefix("block/abysmal_sea_rock"), NerantaPs.prefix("block/black_smoker")));
        this.simpleBlockItem(NPBlocks.MAGNETIC_STORM_VENT.get(), this.models().cubeTop("magnetic_storm_vent",
                NerantaPs.prefix("block/magnetic_storm_vent"), NerantaPs.prefix("block/magnetic_storm_vent_top")));
    }

}