package com.nerantaps.level.levelgen.feature;

import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class PatchDesertBush extends Feature<NoneFeatureConfiguration> {

    public PatchDesertBush() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldGenLevel = context.level();
        BlockPos blockPos = context.origin();
        int solidCount = 0, airCount = 0, y = blockPos.getY();
        BlockState desertBushState = NPBlocks.DESERT_BUSH.get().defaultBlockState();
        if (y > worldGenLevel.getMinBuildHeight() && y < worldGenLevel.getMaxBuildHeight()) {
            BlockPos firstPos = blockPos.below().east().south();
            BlockPos secondPos = blockPos.below().west().north();
            for (BlockPos pos : BlockPos.betweenClosed(firstPos, secondPos)) {
                BlockState state = worldGenLevel.getBlockState(pos);
                boolean flag1 = state.isSolidRender(worldGenLevel, pos);
                boolean flag2 = state.is(NPBlocks.IRON_SAND.get());
                solidCount += flag1 && flag2 ? 1 : 0;
            }
            for (BlockPos pos : BlockPos.betweenClosed(firstPos.above(), secondPos.above(2))) {
                airCount += worldGenLevel.isEmptyBlock(pos) ? 1 : 0;
            }
            if (solidCount >= 9 && airCount >= 18) {
                this.setBlock(worldGenLevel, blockPos, desertBushState);
                for (Direction direction : Direction.values()) {
                    if (direction != Direction.DOWN) {
                        this.setBlock(worldGenLevel, blockPos.relative(direction), desertBushState);
                    }
                }
                return true;
            }
        }
        return false;
    }

}