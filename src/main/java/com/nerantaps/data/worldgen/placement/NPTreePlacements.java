package com.nerantaps.data.worldgen.placement;

import com.nerantaps.data.worldgen.features.NPTreeFeatures;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class NPTreePlacements {

    public static final Holder<PlacedFeature> GLOW_01_CHECKED = PlacementUtils.register("neranta_ps:glow_01_checked",
            NPTreeFeatures.GLOW_TREE_01, PlacementUtils.filteredByBlockSurvival(NPBlocks.GLOW_SAPLING.get()));
    public static final Holder<PlacedFeature> GLOW_02_CHECKED = PlacementUtils.register("neranta_ps:glow_02_checked",
            NPTreeFeatures.GLOW_TREE_02, PlacementUtils.filteredByBlockSurvival(NPBlocks.GLOW_SAPLING.get()));
    public static final Holder<PlacedFeature> CYCAS_CHECKED = PlacementUtils.register("neranta_ps:cycas_checked",
            NPTreeFeatures.CYCAS, PlacementUtils.filteredByBlockSurvival(NPBlocks.CYCAS_SAPLING.get()));
    public static final Holder<PlacedFeature> MEGA_CYCAS_CHECKED = PlacementUtils.register("neranta_ps:mega_cycas_checked",
            NPTreeFeatures.MEGA_CYCAS, PlacementUtils.filteredByBlockSurvival(NPBlocks.CYCAS_SAPLING.get()));
    public static final Holder<PlacedFeature> ELDEN_TREE_CHECKED = PlacementUtils.register("neranta_ps:elden_tree_checked",
            NPTreeFeatures.ELDEN_TREE, PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));

}