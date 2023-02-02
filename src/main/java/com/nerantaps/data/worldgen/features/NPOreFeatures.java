package com.nerantaps.data.worldgen.features;

import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;

public class NPOreFeatures {

    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_BASALT = FeatureUtils.register("neranta_ps:ore_basalt",
            Feature.ORE, new OreConfiguration(OreFeatures.NATURAL_STONE, Blocks.BASALT.defaultBlockState(), 64));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_SULFUR = FeatureUtils.register("neranta_ps:ore_sulfur",
            Feature.ORE, new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, NPBlocks.KIMBERLITE.get().defaultBlockState(), 5));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_ENRICHED_IRON = FeatureUtils.register("neranta_ps:ore_enriched_iron",
            Feature.ORE, new OreConfiguration(OreFeatures.STONE_ORE_REPLACEABLES, NPBlocks.KIMBERLITE.get().defaultBlockState(), 8));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_KIMBERLITE = FeatureUtils.register("neranta_ps:ore_kimberlite",
            Feature.ORE, new OreConfiguration(new BlockMatchTest(Blocks.BASALT), NPBlocks.KIMBERLITE.get().defaultBlockState(), 2));

}