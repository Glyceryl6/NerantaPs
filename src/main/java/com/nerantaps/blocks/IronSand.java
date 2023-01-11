package com.nerantaps.blocks;

import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

public class IronSand extends FallingBlock {

    public IronSand() {
        super(Properties.of(Material.SAND).sound(SoundType.SAND).strength(0.75F, 5.0F));
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        for (Direction direction : Direction.values()) {
            BlockState relativeState = level.getBlockState(pos.relative(direction));
            if ((relativeState.is(Blocks.LAVA) || relativeState.is(Blocks.MAGMA_BLOCK))) {
                level.setBlockAndUpdate(pos, NPBlocks.RED_HOT_IRON_SAND.get().defaultBlockState());
            }
        }
    }

}