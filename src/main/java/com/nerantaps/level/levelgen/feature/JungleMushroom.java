package com.nerantaps.level.levelgen.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class JungleMushroom extends Feature<NoneFeatureConfiguration> {

    public JungleMushroom() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        WorldGenLevel worldGenLevel = context.level();
        RandomSource random = context.random();
        BlockPos blockPos = context.origin();
        int airCount = 0;
        int y = blockPos.getY();
        int i = random.nextInt(4, 8);
        BlockState state = Blocks.BROWN_MUSHROOM_BLOCK.defaultBlockState();
        if (y > worldGenLevel.getMinBuildHeight() && y + i + 6 < worldGenLevel.getMaxBuildHeight()) {
            BlockPos stemTopPos = blockPos.above(i).below();
            BlockPos firstPos = stemTopPos.west(2).north(2);
            BlockPos secondPos = stemTopPos.east(2).south(2).above(5);
            for (BlockPos pos : BlockPos.betweenClosed(firstPos, secondPos)) {
                airCount += worldGenLevel.isEmptyBlock(pos) ? 1 : 0;
            }
            if (isGrassOrDirt(worldGenLevel, blockPos.below()) && airCount >= 150) {
                for (Direction direction : Direction.values()) {
                    if (direction.getAxis().isHorizontal()) {
                        this.setBlock(worldGenLevel, stemTopPos.relative(direction, 2), state);
                    }
                }
                for (int k = 0; k < 4; k++) {
                    for (Direction direction : Direction.values()) {
                        if (direction.getAxis().isHorizontal()) {
                            this.setBlock(worldGenLevel, stemTopPos.relative(direction).above(k), state);
                        }
                    }
                }
                for (BlockPos pos : BlockPos.betweenClosed(stemTopPos.west().north(), stemTopPos.east().south().above())) {
                    this.setBlock(worldGenLevel, pos, state);
                }
                for (int j = 0; j < i + 5; j++) {
                    mutableBlockPos.set(blockPos).move(Direction.UP, j);
                    BlockState state1 = j > i ? state : Blocks.MUSHROOM_STEM.defaultBlockState();
                    this.setBlock(worldGenLevel, mutableBlockPos, state1);
                }
                return true;
            }
        }
        return false;
    }

}