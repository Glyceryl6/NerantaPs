package com.nerantaps.data.provider;

import com.nerantaps.NerantaPs;
import com.nerantaps.data.tags.NPBlockTags;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

public class NPBlockTagsProvider extends BlockTagsProvider {

    public NPBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, NerantaPs.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(BlockTags.FIRE).add(NPBlocks.SULFUR_FIRE.get());
        this.tag(BlockTags.ICE).add(NPBlocks.COMBUSTIBLE_ICE.get());
        this.tag(BlockTags.ENDERMAN_HOLDABLE).add(NPBlocks.IRON_SAND.get());
        this.tag(BlockTags.STRIDER_WARM_BLOCKS).add(NPBlocks.NASCENT_LAVA.get());
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(NPBlocks.IRON_SANDSTONE.get(),
                NPBlocks.MAGNETIC_STORM_VENT.get(), NPBlocks.ABYSMAL_SEA_ROCK.get(),
                NPBlocks.BLACK_SMOKER.get(), NPBlocks.COMBUSTIBLE_ICE.get(),
                NPBlocks.KIMBERLITE.get(), NPBlocks.ENRICHED_IRON_ORE.get(),
                NPBlocks.SULFUR_ORE.get(), NPBlocks.SULFUR_BLOCK.get(),
                NPBlocks.RUST_BLOCK.get(), NPBlocks.RUST_PILLAR.get(),
                NPBlocks.BLOODY_BLACKSTONE.get(), NPBlocks.RUST_PILE.get(),
                NPBlocks.CHROMITE_BLOCK.get(), NPBlocks.RAW_CHROMITE_BLOCK.get(),
                NPBlocks.DEEP_NETHERRACK.get(), NPBlocks.DEEP_NETHER_CHROMITE_ORE.get(),
                NPBlocks.OCEANICEND_STONE.get(), NPBlocks.COBBLED_OCEANICEND_STONE.get(),
                NPBlocks.IRON_PLATE_BLOCK.get(), NPBlocks.RUSTINESS_IRON_PLATE_BLOCK.get(),
                NPBlocks.CUT_IRON_PLATE_BLOCK.get(), NPBlocks.CUT_RUSTINESS_IRON_PLATE_BLOCK.get());
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(NPBlocks.IRON_SANDSTONE.get(), NPBlocks.ENRICHED_IRON_ORE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(NPBlocks.MAGNETIC_STORM_VENT.get(),
                NPBlocks.ABYSMAL_SEA_ROCK.get(), NPBlocks.BLACK_SMOKER.get(), NPBlocks.KIMBERLITE.get(),
                NPBlocks.OCEANICEND_STONE.get(), NPBlocks.COBBLED_OCEANICEND_STONE.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(NPBlocks.DESERT_BUSH.get(),
                NPBlocks.GLOW_GRASS.get(), NPBlocks.ELDEN_FERN.get(), NPBlocks.GLOSSOPTERIS.get());
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(NPBlocks.IRON_SAND.get(),
                NPBlocks.RED_HOT_IRON_SAND.get(), NPBlocks.ROTTEN_FLESH_BLOCK.get());
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(NPBlocks.GLOW_LEAVES.get(),
                NPBlocks.CYCAS_LEAVES.get(), NPBlocks.ROTTEN_FLESH_BLOCK.get());
        this.tag(BlockTags.LEAVES).add(NPBlocks.GLOW_LEAVES.get(), NPBlocks.CYCAS_LEAVES.get());
        this.tag(BlockTags.PLANKS).add(NPBlocks.GLOW_PLANKS.get(), NPBlocks.CYCAS_PLANKS.get());
        this.tag(BlockTags.SLABS).add(NPBlocks.IRON_PLATE_SLAB.get(), NPBlocks.CUT_IRON_PLATE_SLAB.get(),
                NPBlocks.RUSTINESS_IRON_PLATE_SLAB.get(), NPBlocks.CUT_RUSTINESS_IRON_PLATE_SLAB.get());
        this.tag(BlockTags.STAIRS).add(NPBlocks.IRON_PLATE_STAIRS.get(), NPBlocks.CUT_IRON_PLATE_STAIRS.get(),
                NPBlocks.RUSTINESS_IRON_PLATE_STAIRS.get(), NPBlocks.CUT_RUSTINESS_IRON_PLATE_STAIRS.get());
        this.tag(BlockTags.WOODEN_SLABS).add(NPBlocks.GLOW_SLAB.get(), NPBlocks.CYCAS_SLAB.get());
        this.tag(BlockTags.WOODEN_DOORS).add(NPBlocks.GLOW_DOOR.get(), NPBlocks.CYCAS_DOOR.get());
        this.tag(BlockTags.WOODEN_FENCES).add(NPBlocks.GLOW_FENCE.get(), NPBlocks.CYCAS_FENCE.get());
        this.tag(BlockTags.WOODEN_STAIRS).add(NPBlocks.GLOW_STAIRS.get(), NPBlocks.CYCAS_STAIRS.get());
        this.tag(BlockTags.WOODEN_BUTTONS).add(NPBlocks.GLOW_BUTTON.get(), NPBlocks.CYCAS_BUTTON.get());
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(NPBlocks.GLOW_TRAPDOOR.get(), NPBlocks.CYCAS_TRAPDOOR.get());
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(NPBlocks.GLOW_PRESSURE_PLATE.get(), NPBlocks.CYCAS_PRESSURE_PLATE.get());
        this.tag(BlockTags.FLOWER_POTS).add(NPBlocks.POTTED_GLOW_SAPLING.get(), NPBlocks.POTTED_CYCAS_SAPLING.get(),
                NPBlocks.POTTED_ELDEN_FERN.get(), NPBlocks.POTTED_MAPLE_SAPLING.get(),
                NPBlocks.POTTED_GLOSSOPTERIS.get(), NPBlocks.POTTED_UNDERWATER_FUNGUS.get());
        this.tag(BlockTags.GEODE_INVALID_BLOCKS).add(NPBlocks.NASCENT_LAVA.get(), NPBlocks.COMBUSTIBLE_ICE.get());
        this.tag(BlockTags.FENCE_GATES).add(NPBlocks.GLOW_FENCE_GATE.get(), NPBlocks.CYCAS_FENCE_GATE.get());
        this.tag(BlockTags.REPLACEABLE_PLANTS).add(NPBlocks.ELDEN_FERN.get(), NPBlocks.GLOSSOPTERIS.get());
        this.tag(BlockTags.SAPLINGS).add(NPBlocks.GLOW_SAPLING.get(), NPBlocks.CYCAS_SAPLING.get(), NPBlocks.MAPLE_SAPLING.get());
        this.tag(BlockTags.BEACON_BASE_BLOCKS).add(NPBlocks.CHROMITE_BLOCK.get());
        this.tag(Tags.Blocks.COBBLESTONE).add(NPBlocks.COBBLED_OCEANICEND_STONE.get());
        this.tag(NPBlockTags.SULFUR_FIRE_BASE_BLOCKS).add(NPBlocks.SULFUR_ORE.get(), NPBlocks.SULFUR_BLOCK.get());
        this.tag(NPBlockTags.GLOW_LOGS).add(NPBlocks.GLOW_LOG.get(), NPBlocks.GLOW_WOOD.get(),
                NPBlocks.STRIPPED_GLOW_LOG.get(), NPBlocks.STRIPPED_GLOW_WOOD.get());
        this.tag(NPBlockTags.CYCAS_LOGS).add(NPBlocks.CYCAS_LOG.get(), NPBlocks.CYCAS_WOOD.get(),
                NPBlocks.STRIPPED_CYCAS_LOG.get(), NPBlocks.STRIPPED_CYCAS_WOOD.get());
        this.tag(NPBlockTags.MAPLE_LOGS).add(NPBlocks.MAPLE_LOG.get(), NPBlocks.MAPLE_WOOD.get(),
                NPBlocks.STRIPPED_MAPLE_LOG.get(), NPBlocks.STRIPPED_MAPLE_WOOD.get());
        this.tag(BlockTags.LOGS).addTag(NPBlockTags.GLOW_LOGS).addTag(NPBlockTags.CYCAS_LOGS).addTag(NPBlockTags.MAPLE_LOGS);
    }

}