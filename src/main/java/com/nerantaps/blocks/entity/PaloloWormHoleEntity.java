package com.nerantaps.blocks.entity;

import com.nerantaps.registry.NPBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PaloloWormHoleEntity extends BlockEntity {

    public PaloloWormHoleEntity(BlockPos worldPosition, BlockState blockState) {
        super(NPBlockEntities.PALOLO_WORM_HOLE_ENTITY.get(), worldPosition, blockState);
    }

}