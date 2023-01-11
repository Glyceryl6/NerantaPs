package com.nerantaps.data.level.feature;

import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class NPTreeFeatures {

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GLOW_TREE = FeatureUtils.register("glow_tree",
            Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NPBlocks.GLOW_LOG.get()),
                    new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(NPBlocks.GLOW_LEAVES.get()),
                    new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(0, 2), UniformInt.of(1, 2)),
                    new TwoLayersFeatureSize(2, 0, 2))).ignoreVines().build());

}