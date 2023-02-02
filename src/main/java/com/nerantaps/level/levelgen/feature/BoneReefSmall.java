package com.nerantaps.level.levelgen.feature;

import com.nerantaps.blocks.UnderwaterFungus;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class BoneReefSmall extends Feature<NoneFeatureConfiguration> {

    public BoneReefSmall() {
        super(NoneFeatureConfiguration.CODEC);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldGenLevel = context.level();
        RandomSource random = context.random();
        BlockPos blockPos = context.origin();
        int solidCount = 0, waterCount = 0, y = blockPos.getY();
        if (y > worldGenLevel.getMinBuildHeight() && y < worldGenLevel.getMaxBuildHeight()) {
            BlockState state1 = Blocks.BONE_BLOCK.defaultBlockState();
            BlockState state2 = NPBlocks.ROTTEN_FLESH_BLOCK.get().defaultBlockState();
            BlockState state3 = NPBlocks.UNDERWATER_FUNGUS_BLOCK.get().defaultBlockState();
            BlockState state4 = NPBlocks.UNDERWATER_FUNGUS.get().defaultBlockState()
                    .setValue(UnderwaterFungus.WATERLOGGED, true);
            for (BlockPos pos : BlockPos.withinManhattan(blockPos, 2, 0, 2)) {
                solidCount += worldGenLevel.getBlockState(pos.below()).isSolidRender(worldGenLevel, pos.below()) ? 1 : 0;
                waterCount += worldGenLevel.isWaterAt(pos) ? 1 : 0;
            }
            if (solidCount >= 25 && waterCount >= 21) {
                Direction direction = random.nextBoolean() ? Direction.EAST : Direction.SOUTH;
                this.setBlock(worldGenLevel, blockPos, random.nextBoolean() ? state2 : state3);
                if (random.nextBoolean()) {
                    //从中心向两端偏移1或2格处放置一个骨块
                    int offsetCount1 = random.nextBoolean() ? 2 : 1, offsetCount2 = random.nextBoolean() ? 2 : 1;
                    this.setBlock(worldGenLevel, blockPos.relative(direction, offsetCount1), state1);
                    this.setBlock(worldGenLevel, blockPos.relative(direction.getOpposite(), offsetCount2), state1);
                    //由上述位置的坐标分别朝六面再次放置骨块，如果为横向，则有概率在上面放置一个水下真菌
                    for (Direction direction1 : Direction.values()) {
                        BlockPos pos1 = blockPos.relative(direction, offsetCount1);
                        BlockPos pos2 = blockPos.relative(direction.getOpposite(), offsetCount2);
                        if (worldGenLevel.isWaterAt(pos1.relative(direction1))) {
                            this.setBlock(worldGenLevel, pos1.relative(direction1), state1);
                        }
                        if (worldGenLevel.isWaterAt(pos2.relative(direction1))) {
                            this.setBlock(worldGenLevel, pos2.relative(direction1), state1);
                        }
                        if (direction1.getAxis().isHorizontal()) {
                            BlockPos pos3 = blockPos.relative(direction1);
                            this.setBlock(worldGenLevel, pos1.relative(direction1).above(), random.nextBoolean() ? state4 : Blocks.WATER.defaultBlockState());
                            this.setBlock(worldGenLevel, pos1.relative(direction1).above(), random.nextBoolean() ? state4 : Blocks.WATER.defaultBlockState());
                            if (direction1.getAxis() != direction.getAxis() && worldGenLevel.isWaterAt(pos3) && random.nextBoolean()) {
                                this.setBlock(worldGenLevel, pos3, NPBlocks.PALOLO_WORM_HOLE.get().defaultBlockState());
                            }
                        }
                    }
                    //在两端末尾处再放置一个方块，可能是骨块、腐肉块或水下真菌块
                    this.setBlock(worldGenLevel, blockPos.relative(direction, (offsetCount1 + 1)), random.nextBoolean() ? state1 : (random.nextBoolean() ? state2 : state3));
                    this.setBlock(worldGenLevel, blockPos.relative(direction.getOpposite(), (offsetCount2 + 1)), random.nextBoolean() ? state1 : (random.nextBoolean() ? state2 : state3));
                } else {
                    int x = direction.getAxis() == Direction.Axis.X ? 3 : 1;
                    int z = direction.getAxis() == Direction.Axis.Z ? 3 : 1;
                    for (BlockPos pos : BlockPos.withinManhattan(blockPos, x, 0, z)) {
                        if (worldGenLevel.isWaterAt(pos)) {
                            this.setBlock(worldGenLevel, pos, this.randomBoneReefState());
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private BlockState randomBoneReefState() {
        return switch (RandomSource.create().nextInt(8)) {
            case 0 -> Blocks.WATER.defaultBlockState();
            case 1 -> NPBlocks.ROTTEN_FLESH_BLOCK.get().defaultBlockState();
            case 2 -> NPBlocks.UNDERWATER_FUNGUS_BLOCK.get().defaultBlockState();
            case 3 -> NPBlocks.UNDERWATER_FUNGUS.get().defaultBlockState()
                    .setValue(UnderwaterFungus.WATERLOGGED, true);
            default -> Blocks.BONE_BLOCK.defaultBlockState();
        };
    }

}