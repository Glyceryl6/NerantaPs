package com.nerantaps.level.levelgen.feature;

import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class MagneticStormVentPillar extends Feature<NoneFeatureConfiguration> {

    public MagneticStormVentPillar() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldGenLevel = context.level();
        BlockPos blockPos = context.origin().below();
        BlockPos firstPos = blockPos.east().south();
        BlockPos secondPos = blockPos.west().north();
        int solidCount = 0, y = blockPos.getY();
        if (y + 4 > worldGenLevel.getMinBuildHeight() && y < worldGenLevel.getMaxBuildHeight()) {
            for (BlockPos pos : BlockPos.betweenClosed(firstPos, secondPos.below(3))) {
                solidCount += worldGenLevel.getBlockState(pos).isSolidRender(worldGenLevel, pos) ? 1 : 0;
            }
            if (solidCount >= 27) {
                BlockState ironSandState = NPBlocks.IRON_SAND.get().defaultBlockState();
                this.setBlock(worldGenLevel, blockPos, NPBlocks.MAGNETIC_STORM_VENT.get().defaultBlockState());
                this.setBlock(worldGenLevel, blockPos.below(), NPBlocks.RED_HOT_IRON_SAND.get().defaultBlockState());
                for (Direction direction : Direction.values()) {
                    if (direction.getAxis().isHorizontal()) {
                        this.setBlock(worldGenLevel, blockPos.relative(direction), NPBlocks.IRON_SANDSTONE.get().defaultBlockState());
                        this.setBlock(worldGenLevel, blockPos.relative(direction).below(), NPBlocks.IRON_SANDSTONE.get().defaultBlockState());
                        this.setBlock(worldGenLevel, blockPos.relative(direction).relative(direction.getClockWise()), ironSandState);
                        this.setBlock(worldGenLevel, blockPos.relative(direction).below().relative(direction.getClockWise()), ironSandState);
                    }
                }
                for (BlockPos pos : BlockPos.betweenClosed(firstPos.below(2), secondPos.below(3))) {
                    this.setBlock(worldGenLevel, pos, NPBlocks.IRON_SANDSTONE.get().defaultBlockState());
                }
                return true;
            }
        }
        return false;
    }

}