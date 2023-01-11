package com.nerantaps.blocks;

import com.nerantaps.data.tags.NPBlockTags;
import com.nerantaps.registry.NPBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

@SuppressWarnings("deprecation")
public class SulfurFire extends BaseFireBlock {

    public static final IntegerProperty AGE = BlockStateProperties.AGE_15;

    public SulfurFire() {
        super(Properties.copy(Blocks.FIRE).lightLevel(s -> 10), 2.0F);
        this.registerDefaultState(this.stateDefinition.any().setValue(AGE, 0));
    }

    public static BlockState getState(BlockGetter blockGetter, BlockPos blockPos) {
        BlockState state = blockGetter.getBlockState(blockPos.below());
        BlockState sulfurFireState = NPBlocks.SULFUR_FIRE.get().defaultBlockState();
        BlockState fireState = ((FireBlock)Blocks.FIRE).getStateForPlacement(blockGetter, blockPos);
        return state.is(NPBlockTags.SULFUR_FIRE_BASE_BLOCKS) ? sulfurFireState : fireState;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        level.scheduleTick(pos, this, 30 + random.nextInt(10));
        if (level.getGameRules().getBoolean(GameRules.RULE_DOFIRETICK)) {
            if (!state.canSurvive(level, pos)) {
                level.removeBlock(pos, false);
            }
            int i = state.getValue(AGE);
            BlockState blockState = level.getBlockState(pos.below());
            boolean flag1 = blockState.is(NPBlocks.SULFUR_ORE.get());
            boolean flag2 = random.nextFloat() < 0.2F + (float)i * 0.03F;
            if (!flag1 && level.isRaining() && this.isNearRain(level, pos) && flag2) {
                level.removeBlock(pos, false);
            } else {
                int j = Math.min(15, i + random.nextInt(3) / 2);
                if (i != j) {
                    state = state.setValue(AGE, j);
                    level.setBlock(pos, state, 4);
                }
                if (!flag1 && i == 15 && random.nextInt(4) == 0) {
                    level.removeBlock(pos, false);
                }
            }
        }
    }

    protected boolean isNearRain(Level level, BlockPos pos) {
        return level.isRainingAt(pos) || level.isRainingAt(pos.west()) || level.isRainingAt(pos.east()) || level.isRainingAt(pos.north()) || level.isRainingAt(pos.south());
    }

    @Override
    public void entityInside(BlockState blockState, Level level, BlockPos pos, Entity entity) {
        if (!entity.fireImmune()) {
            entity.setRemainingFireTicks(entity.getRemainingFireTicks() + 1);
            if (entity instanceof LivingEntity livingEntity && level.getGameTime() % 60L == 0L) {
                livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 400));
            }
            if (entity.getRemainingFireTicks() == 0) {
                entity.setSecondsOnFire(8);
            }
        }

        entity.hurt(DamageSource.IN_FIRE, 2.0F);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return levelReader.getBlockState(blockPos.below()).is(NPBlockTags.SULFUR_FIRE_BASE_BLOCKS);
    }

    @Override
    protected boolean canBurn(BlockState state) {
        return state.is(NPBlocks.SULFUR_BLOCK.get());
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

}