package com.nerantaps.blocks;

import com.nerantaps.items.Stripper;
import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("deprecation")
public class MapleLog extends RotatedPillarBlock {

    public static final EnumProperty<MapleLogState> STATE_PROPERTY = EnumProperty.create("sugar_state", MapleLogState.class);

    public MapleLog(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(STATE_PROPERTY, MapleLogState.PLAIN));
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (toolAction == ToolActions.AXE_STRIP) {
            return transferAllBlockStates(state, NPBlocks.STRIPPED_MAPLE_LOG.get().defaultBlockState());
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private static BlockState transferAllBlockStates(BlockState initial, BlockState after) {
        BlockState block = after;
        for (Property property : initial.getBlock().getStateDefinition().getProperties()) {
            if (after.hasProperty(property)) {
                block = block.setValue(property, initial.getValue(property));
            }
        }
        return block;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(STATE_PROPERTY);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis()).setValue(STATE_PROPERTY, MapleLogState.PLAIN);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource random) {
        if (random.nextInt(7) == 0) {
            MapleLogState mapleLogState = blockState.getValue(STATE_PROPERTY);
            if (mapleLogState.canRegenerate()) {
                serverLevel.setBlockAndUpdate(blockPos, blockState.setValue(STATE_PROPERTY, mapleLogState.getWet()));
            }
        }
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState blockState) {
        Direction.Axis axis = blockState.getValue(AXIS);
        if (axis.isHorizontal() || axis.isVertical()) {
            return PushReaction.NORMAL;
        }
        return PushReaction.BLOCK;
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() instanceof Stripper) {
            level.playSound(player, blockPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0f, 1.0f);
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, blockPos, itemStack);
            }
            BlockState state = NPBlocks.STRIPPED_MAPLE_LOG.get().defaultBlockState();
            level.setBlock(blockPos, state.setValue(AXIS, blockState.getValue(AXIS)), 11);
            itemStack.hurtAndBreak(1, player, player1 -> player1.broadcastBreakEvent(hand));
        } else if (itemStack.is(Items.GLASS_BOTTLE)) {
            itemStack.shrink(1);
            level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);
            if (itemStack.isEmpty()) {
                player.setItemInHand(hand, new ItemStack(NPItems.MAPLE_SYRUP.get()));
            } else if (!player.getInventory().add(new ItemStack(NPItems.MAPLE_SYRUP.get()))) {
                player.drop(new ItemStack(NPItems.MAPLE_SYRUP.get()), false);
            }
            level.gameEvent(player, GameEvent.FLUID_PICKUP, blockPos);
            if (!level.isClientSide()) {
                player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
            }
        }
        return super.use(blockState, level, blockPos, player, hand, blockHitResult);
    }

}