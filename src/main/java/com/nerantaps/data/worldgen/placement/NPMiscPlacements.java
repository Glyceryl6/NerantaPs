package com.nerantaps.data.worldgen.placement;

import com.nerantaps.data.worldgen.features.NPMiscFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class NPMiscPlacements {

    public static final Holder<PlacedFeature> DISK_GRAVEL = PlacementUtils.register("neranta_ps:disk_gravel",
            NPMiscFeatures.DISK_GRAVEL, List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> JUNGLE_MUSHROOM = PlacementUtils.register("neranta_ps:jungle_mushroom",
            NPMiscFeatures.JUNGLE_MUSHROOM, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> MAGNETIC_STORM_VENT_PILLAR = PlacementUtils.register("neranta_ps:magnetic_storm_vent_pillar",
            NPMiscFeatures.MAGNETIC_STORM_VENT_PILLAR, RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> BONE_REEF_SMALL = PlacementUtils.register("neranta_ps:bone_reef_small",
            NPMiscFeatures.BONE_REEF_SMALL, RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());

}