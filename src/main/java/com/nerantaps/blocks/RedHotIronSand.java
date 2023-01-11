package com.nerantaps.blocks;

import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.Material;

public class RedHotIronSand extends FallingBlock {

    protected static final IntegerProperty EVAPORATE_COUNT = IntegerProperty.create("evaporate_count", 0, 3);

    public RedHotIronSand() {
        super(Properties.of(Material.SAND).sound(SoundType.SAND).strength(0.75F, 5.0F));
        this.registerDefaultState(this.stateDefinition.any().setValue(EVAPORATE_COUNT, 0));
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        for (Direction direction : Direction.values()) {
            int j = state.getValue(EVAPORATE_COUNT);
            if (level.getBlockState(pos.relative(direction)).is(Blocks.WATER)) {
                float pitch = 2.6F + (level.random.nextFloat() - level.random.nextFloat()) * 0.8F;
                level.playSound(null, pos, SoundEvents.FIRE_EXTINGUISH, SoundSource.BLOCKS, 0.5F, pitch);
                if (!level.isClientSide()) {
                    level.setBlockAndUpdate(pos.relative(direction), Blocks.AIR.defaultBlockState());
                    if (j == 3) {
                        level.setBlockAndUpdate(pos, NPBlocks.IRON_SAND.get().defaultBlockState());
                    } else {
                        level.setBlock(pos, this.defaultBlockState().setValue(EVAPORATE_COUNT, j + 1), 4);
                    }
                }
            }
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof LivingEntity livingEntity && !EnchantmentHelper.hasFrostWalker(livingEntity)) {
            livingEntity.hurt(DamageSource.HOT_FLOOR, 1.0F);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(EVAPORATE_COUNT);
    }

}