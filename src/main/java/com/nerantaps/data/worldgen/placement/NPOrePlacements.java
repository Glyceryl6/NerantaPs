package com.nerantaps.data.worldgen.placement;

import com.nerantaps.data.worldgen.features.NPOreFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class NPOrePlacements {

    public static final Holder<PlacedFeature> ORE_BASALT = PlacementUtils.register("neranta_ps:ore_basalt", NPOreFeatures.ORE_BASALT,
            OrePlacements.commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
    public static final Holder<PlacedFeature> ORE_SULFUR = PlacementUtils.register("neranta_ps:ore_sulfur", NPOreFeatures.ORE_SULFUR,
            OrePlacements.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100))));
    public static final Holder<PlacedFeature> ORE_ENRICHED_IRON = PlacementUtils.register("neranta_ps:ore_enriched_iron", NPOreFeatures.ORE_ENRICHED_IRON,
            OrePlacements.commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60))));
    public static final Holder<PlacedFeature> ORE_KIMBERLITE = PlacementUtils.register("neranta_ps:ore_kimberlite", NPOreFeatures.ORE_KIMBERLITE,
            OrePlacements.commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-10), VerticalAnchor.absolute(70))));

}