package com.nerantaps.blocks.grower;

import com.nerantaps.data.worldgen.features.NPTreeFeatures;
import com.nerantaps.data.worldgen.features.NPVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class CycasGrower extends AbstractMegaTreeGrower {

    @Nullable @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean largeHive) {
        return NPTreeFeatures.CYCAS;
    }

    @Nullable @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
        return NPTreeFeatures.MEGA_CYCAS;
    }

}