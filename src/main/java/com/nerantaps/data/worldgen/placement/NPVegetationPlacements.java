package com.nerantaps.data.worldgen.placement;

import com.nerantaps.data.worldgen.features.NPVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.*;

public class NPVegetationPlacements {

    public static final Holder<PlacedFeature> TREES_FLUORESCENT_FOREST = PlacementUtils.register("neranta_ps:trees_fluorescent_forest",
            NPVegetationFeatures.TREES_FLUORESCENT_FOREST, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
    public static final Holder<PlacedFeature> PATCH_GLOW_GRASS_2 = PlacementUtils.register("neranta_ps:patch_grass_taiga_2",
            NPVegetationFeatures.PATCH_GLOW_GRASS, InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PATCH_GLOW_GRASS = PlacementUtils.register("neranta_ps:patch_grass_taiga",
            NPVegetationFeatures.PATCH_GLOW_GRASS, worldSurfaceSquaredWithCount(7));
    public static final Holder<PlacedFeature> PATCH_GLOW_MOSS = PlacementUtils.register("neranta_ps:patch_glow_moss",
            NPVegetationFeatures.PATCH_GLOW_MOSS, getMushroomPlacement(4, null));
    public static final Holder<PlacedFeature> PATCH_ELDEN_FERN = PlacementUtils.register("neranta_ps:patch_elden_fern",
            NPVegetationFeatures.PATCH_ELDEN_FERN, RarityFilter.onAverageOnceEvery(32),
            InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> NORMAL_OAK = PlacementUtils.register("neranta_ps:normal_oak",
            TreeFeatures.OAK, treePlacement(PlacementUtils.countExtra(10, 0.1F, 1), Blocks.OAK_SAPLING));
    public static final Holder<PlacedFeature> PATCH_DESERT_BUSH = PlacementUtils.register("neranta_ps:patch_desert_bush",
            NPVegetationFeatures.PATCH_DESERT_BUSH, RarityFilter.onAverageOnceEvery(2), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> TREE_ANCIENT_JUNGLE = PlacementUtils.register("neranta_ps:tree_ancient_jungle",
            NPVegetationFeatures.TREE_ANCIENT_JUNGLE, List.of(CountPlacement.of(3),
                    InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0),
                    PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> ELDEN_TREES = PlacementUtils.register("neranta_ps:elden_trees",
            NPVegetationFeatures.ELDEN_TREE, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));
    public static final Holder<PlacedFeature> TREES_CYCAS = PlacementUtils.register("neranta_ps:trees_cycas",
            NPVegetationFeatures.TREE_CYCAS, treePlacement(PlacementUtils.countExtra(1, 0.1F, 1)));

}