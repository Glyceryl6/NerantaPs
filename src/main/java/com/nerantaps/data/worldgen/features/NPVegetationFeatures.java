package com.nerantaps.data.worldgen.features;

import com.nerantaps.data.worldgen.placement.NPTreePlacements;
import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;

import java.util.List;

import static net.minecraft.data.worldgen.features.VegetationFeatures.grassPatch;

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
            FeatureUtils.register("neranta_ps:patch_glow_moss", Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(NPBlocks.GLOW_MOSS.get()))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_ELDEN_FERN =
            FeatureUtils.register("neranta_ps:patch_elden_fern", Feature.RANDOM_PATCH,
                    FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                    new SimpleBlockConfiguration(BlockStateProvider.simple(NPBlocks.ELDEN_FERN.get())), List.of(Blocks.GRASS_BLOCK)));
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> PATCH_DESERT_BUSH =
            FeatureUtils.register("neranta_ps:patch_desert_bush", NPFeatures.PATCH_DESERT_BUSH.get());
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> ELDEN_TREE =
            FeatureUtils.register("neranta_ps:elden_tree_0", Feature.RANDOM_SELECTOR,
                    new RandomFeatureConfiguration(List.of(), NPTreePlacements.ELDEN_TREE_CHECKED));
    public static final Holder<ConfiguredFeature<RandomFeatureConfiguration, ?>> TREE_CYCAS =
            FeatureUtils.register("neranta_ps:tree_cycas", Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
            List.of(new WeightedPlacedFeature(NPTreePlacements.MEGA_CYCAS_CHECKED, 0.33333334F)), NPTreePlacements.CYCAS_CHECKED));

}