package com.nerantaps.blocks.grower;

import com.nerantaps.data.worldgen.features.NPTreeFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class GlowTreeGrower extends AbstractTreeGrower {

    @Nullable @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean largeHive) {
        return randomSource.nextBoolean() ? NPTreeFeatures.GLOW_TREE_01 : NPTreeFeatures.GLOW_TREE_02;
    }

}