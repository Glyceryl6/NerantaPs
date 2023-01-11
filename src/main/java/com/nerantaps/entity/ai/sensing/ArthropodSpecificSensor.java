package com.nerantaps.entity.ai.sensing;

import com.google.common.collect.ImmutableSet;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Optional;
import java.util.Set;

public class ArthropodSpecificSensor extends Sensor<LivingEntity> {

    @Override
    public Set<MemoryModuleType<?>> requires() {
        return ImmutableSet.of(MemoryModuleType.NEAREST_REPELLENT);
    }

    @Override
    protected void doTick(ServerLevel level, LivingEntity attacker) {
        Brain<?> brain = attacker.getBrain();
        brain.setMemory(MemoryModuleType.NEAREST_REPELLENT, findNearestBurningSulfurBlock(level, attacker));
        //brain.setMemory(MemoryModuleType.NEAREST_REPELLENT, findNearestBurningSulfurOre(level, attacker));
    }

    private static Optional<BlockPos> findNearestBurningSulfurBlock(ServerLevel level, LivingEntity livingEntity) {
        return BlockPos.findClosestMatch(livingEntity.blockPosition(), 4, 4, blockPos -> {
            boolean flag = level.getBlockState(blockPos).is(NPBlocks.SULFUR_FIRE.get());
            BlockState belowState = level.getBlockState(blockPos.below());
            return flag && belowState.is(NPBlocks.SULFUR_BLOCK.get());
        });
    }

    @SuppressWarnings("unused")
    private static Optional<BlockPos> findNearestBurningSulfurOre(ServerLevel level, LivingEntity livingEntity) {
        return BlockPos.findClosestMatch(livingEntity.blockPosition(), 2, 4, blockPos -> {
            boolean flag = level.getBlockState(blockPos).is(NPBlocks.SULFUR_FIRE.get());
            BlockState belowState = level.getBlockState(blockPos.below());
            return flag && belowState.is(NPBlocks.SULFUR_ORE.get());
        });
    }

}