package com.nerantaps.data.worldgen.features;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;

import java.util.List;

public class NPMiscFeatures {

    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_GRAVEL = FeatureUtils.register("neranta_ps:disk_gravel", Feature.DISK,
            new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL), BlockPredicate.matchesBlocks(List.of(Blocks.SMOOTH_BASALT, Blocks.BASALT)), UniformInt.of(2, 5), 2));

}