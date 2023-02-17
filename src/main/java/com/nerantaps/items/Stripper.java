package com.nerantaps.items;

import com.nerantaps.blocks.CycasLog;
import com.nerantaps.registry.NPItems;
import com.nerantaps.registry.NPTabs;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.enchantment.DigDurabilityEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;

@SuppressWarnings("deprecation")
public class Stripper extends Item {

    public Stripper() {
        super(new Item.Properties().tab(NPTabs.TAB_NERANTA_TAB_1).setNoRepair().durability(64));
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return enchantment instanceof DigDurabilityEnchantment || enchantment == Enchantments.MENDING;
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos clickedPos = context.getClickedPos();
        ItemStack heldStack = context.getItemInHand();
        BlockState state = level.getBlockState(clickedPos);
        if (state.getBlock() instanceof CycasLog cycasLog) {
            if (player instanceof ServerPlayer serverPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger(serverPlayer, clickedPos, heldStack);
            }
            BlockState modifiedState = cycasLog.getToolModifiedState(state, context, ToolActions.AXE_STRIP, true);
            level.playSound(player, clickedPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.setBlock(clickedPos, modifiedState != null ? modifiedState : state, 11);
            if (player != null) {
                ItemStack barkStack = NPItems.CYCAS_BARK.get().getDefaultInstance();
                Block.popResourceFromFace(level, clickedPos, player.getDirection().getOpposite(), barkStack);
                heldStack.hurtAndBreak(1, player, (p) -> p.broadcastBreakEvent(context.getHand()));
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        } else {
            return InteractionResult.PASS;
        }
    }

}