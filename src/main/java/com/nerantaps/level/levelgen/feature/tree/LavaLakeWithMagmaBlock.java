package com.nerantaps.level.levelgen.feature.tree;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class LavaLakeWithMagmaBlock extends Feature<NoneFeatureConfiguration> {

    public LavaLakeWithMagmaBlock() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldGenLevel = context.level();
        RandomSource random = context.random();
        BlockPos blockPos = context.origin().below();
        int solidCount = 0, airCount = 0, y = blockPos.getY();
        if (y > worldGenLevel.getMinBuildHeight() && y < worldGenLevel.getMaxBuildHeight()) {
            for (BlockPos pos : BlockPos.withinManhattan(blockPos, 3, 0, 3)) {
                //Todo: Need to create a lava pool with magma block.
            }
        }
        return false;
    }

}