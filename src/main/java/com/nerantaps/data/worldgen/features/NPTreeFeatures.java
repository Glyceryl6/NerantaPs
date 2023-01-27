package com.nerantaps.data.worldgen.features;

import com.google.common.collect.ImmutableList;
import com.nerantaps.level.levelgen.feature.tree.foliage.CycasFoliagePlacer;
import com.nerantaps.level.levelgen.feature.tree.foliage.EldenTreeFoliagePlacer;
import com.nerantaps.level.levelgen.feature.tree.foliage.MegaCycasFoliagePlacer;
import com.nerantaps.level.levelgen.feature.tree.trunk.FlatTopGiantTrunkPlacer;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;

public class NPTreeFeatures {

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GLOW_TREE_01 = FeatureUtils.register("neranta_ps:glow_tree_01",
            Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NPBlocks.GLOW_LOG.get()),
                    new StraightTrunkPlacer(5, 2, 1), BlockStateProvider.simple(NPBlocks.GLOW_LEAVES.get()),
                    new SpruceFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), UniformInt.of(1, 2)),
                    new TwoLayersFeatureSize(2, 1, 2))).ignoreVines().build());

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> GLOW_TREE_02 = FeatureUtils.register("neranta_ps:glow_tree_02",
            Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NPBlocks.GLOW_LOG.get()),
                    new StraightTrunkPlacer(6, 4, 0), BlockStateProvider.simple(NPBlocks.GLOW_LEAVES.get()),
                    new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), ConstantInt.of(3)),
                    new TwoLayersFeatureSize(2, 2, 2))).ignoreVines().build());

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> ELDEN_TREE = FeatureUtils.register("neranta_ps:elden_tree",
            Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.JUNGLE_LOG),
                    new StraightTrunkPlacer(6, 7, 0), BlockStateProvider.simple(
                            Blocks.JUNGLE_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true)),
                    new EldenTreeFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 1))).decorators(ImmutableList.of(
                    TrunkVineDecorator.INSTANCE, new LeaveVineDecorator(0.2F))).ignoreVines().build());

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> CYCAS = FeatureUtils.register("neranta_ps:cycas",
            Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NPBlocks.CYCAS_LOG.get()),
                    new StraightTrunkPlacer(4, 4, 0), BlockStateProvider.simple(
                            NPBlocks.CYCAS_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true)),
                    new CycasFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 0, 1))).ignoreVines().build());

    public static final Holder<ConfiguredFeature<TreeConfiguration, ?>> MEGA_CYCAS = FeatureUtils.register("neranta_ps:mega_cycas",
            Feature.TREE, (new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(NPBlocks.CYCAS_LOG.get()),
                    new FlatTopGiantTrunkPlacer(4, 4, 0), BlockStateProvider.simple(
                            NPBlocks.CYCAS_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true)),
                    new MegaCycasFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0)),
                    new TwoLayersFeatureSize(1, 1, 2))).ignoreVines().build());

}