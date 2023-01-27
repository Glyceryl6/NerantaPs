package com.nerantaps.data.worldgen.features;

import com.nerantaps.registry.NPFeatures;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;

import java.util.List;

public class NPMiscFeatures {

    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_GRAVEL = FeatureUtils.register("neranta_ps:disk_gravel", Feature.DISK,
            new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL), BlockPredicate.matchesBlocks(List.of(Blocks.SMOOTH_BASALT, Blocks.BASALT)), UniformInt.of(2, 5), 2));
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> JUNGLE_MUSHROOM = FeatureUtils.register("neranta_ps:jungle_mushroom", NPFeatures.JUNGLE_MUSHROOM.get());
    public static final Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> MAGNETIC_STORM_VENT_PILLAR = FeatureUtils.register("neranta_ps:magnetic_storm_vent_pillar", NPFeatures.MAGNETIC_STORM_VENT_PILLAR.get());

}