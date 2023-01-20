package com.nerantaps.data.worldgen.placement;

import com.nerantaps.data.worldgen.features.NPMiscFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class NPMiscPlacements {

    public static final Holder<PlacedFeature> DISK_GRAVEL = PlacementUtils.register("neranta_ps:disk_gravel", NPMiscFeatures.DISK_GRAVEL,
            List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome()));

}