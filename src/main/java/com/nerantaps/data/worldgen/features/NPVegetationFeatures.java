package com.nerantaps.data.worldgen.features;

import com.nerantaps.data.worldgen.placement.NPTreePlacements;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.*;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;

import java.util.List;

import static net.minecraft.data.worldgen.features.VegetationFeatures.*;

public class NPVegetationFeatures {

    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREES_FLUORESCENT_FOREST =
            FeatureUtils.register("neranta_ps:trees_fluorescent_forest", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
            List.of(new WeightedPlacedFeature(NPTreePlacements.GLOW_02_CHECKED, 0.33333334F)), NPTreePlacements.GLOW_01_CHECKED));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GLOW_GRASS =
            FeatureUtils.register("neranta_ps:patch_glow_grass", Feature.RANDOM_PATCH, grassPatch(
                    new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                            .add(NPBlocks.GLOW_GRASS.get().defaultBlockState(), 1)
                            .add(NPBlocks.ELDEN_FERN.get().defaultBlockState(), 4)), 32));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GLOW_MOSS =
            FeatureUtils.register("neranta_ps:patch_glow_moss", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(NPBlocks.GLOW_MOSS.get()))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_ELDEN_FERN =
            FeatureUtils.register("neranta_ps:patch_elden_fern", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(NPBlocks.ELDEN_FERN.get())), List.of(Blocks.GRASS_BLOCK)));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_DESERT_BUSH =
            FeatureUtils.register("neranta_ps:patch_desert_bush", Feature.RANDOM_PATCH,
                    grassPatch(BlockStateProvider.simple(NPBlocks.DESERT_BUSH.get()), 4));
    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> TREE_ANCIENT_JUNGLE =
            FeatureUtils.register("neranta_ps:tree_ancient_jungle", Feature.TREE,
                    new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.JUNGLE_LOG.defaultBlockState()),
                            new MegaJungleTrunkPlacer(11, 2, 19), BlockStateProvider.simple(Blocks.JUNGLE_LEAVES.defaultBlockState()),
                            new MegaJungleFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 2),
                            new TwoLayersFeatureSize(1, 1, 2)).build());

}