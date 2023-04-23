package com.nerantaps.core;

import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPItems;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LayeredCauldronBlock;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import java.util.Map;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NPCauldronInteraction {

    public static Map<Item, CauldronInteraction> ALCOHOL = CauldronInteraction.newInteractionMap();
    public static Map<Item, CauldronInteraction> SULFURIC_ACID = CauldronInteraction.newInteractionMap();
    public static final CauldronInteraction FILL_ALCOHOL = (state, level, blockPos, player, hand, stack) -> CauldronInteraction.emptyBucket(level, blockPos,
            player, hand, stack, NPBlocks.ALCOHOL_CAULDRON.get().defaultBlockState().setValue(LayeredCauldronBlock.LEVEL, 3), SoundEvents.BUCKET_EMPTY);
    public static final CauldronInteraction FILL_SULFURIC_ACID = (state, level, blockPos, player, hand, stack) -> CauldronInteraction.emptyBucket(level, blockPos,
            player, hand, stack, NPBlocks.SULFURIC_ACID_CAULDRON.get().defaultBlockState().setValue(LayeredCauldronBlock.LEVEL, 3), SoundEvents.BUCKET_EMPTY);

    @SubscribeEvent
    public static void registerCauldronInteraction(FMLCommonSetupEvent event) {
        addDefaultInteractions(ALCOHOL, FILL_ALCOHOL, NPItems.BOTTLE_OF_ALCOHOL.get(),
                NPItems.ALCOHOL_BUCKET.get(), NPBlocks.ALCOHOL_CAULDRON.get());
        addDefaultInteractions(SULFURIC_ACID, FILL_SULFURIC_ACID, NPItems.BOTTLE_OF_SULFURIC_ACID.get(),
                NPItems.SULFURIC_ACID_BUCKET.get(), NPBlocks.SULFURIC_ACID_CAULDRON.get());
    }

    private static void addDefaultInteractions(Map<Item, CauldronInteraction> map, CauldronInteraction cauldronInteraction,
                                              Item bottleItem, Item bucketItem, Block cauldronBlock) {
        CauldronInteraction.EMPTY.put(bucketItem, cauldronInteraction);
        CauldronInteraction.WATER.put(bucketItem, cauldronInteraction);
        CauldronInteraction.LAVA.put(bucketItem, cauldronInteraction);
        CauldronInteraction.POWDER_SNOW.put(bucketItem, cauldronInteraction);
        map.put(bucketItem, cauldronInteraction);
        map.put(Items.BUCKET, (state, level, pos, player, hand, stack) -> CauldronInteraction.fillBucket(state, level, pos, player, hand, stack,
                new ItemStack(bucketItem), (cauldronState) -> cauldronState.getValue(LayeredCauldronBlock.LEVEL) == 3, SoundEvents.BUCKET_FILL));
        map.put(Items.GLASS_BOTTLE, (state, level, pos, player, hand, stack) -> {
            if (!level.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(bottleItem)));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                LayeredCauldronBlock.lowerFillLevel(state, level, pos);
                level.playSound(null, pos, SoundEvents.BOTTLE_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PICKUP, pos);
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        });
        map.put(bottleItem, (state, level, pos, player, hand, stack) -> {
            if (state.getValue(LayeredCauldronBlock.LEVEL) != 3) {
                if (!level.isClientSide) {
                    player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                    player.awardStat(Stats.USE_CAULDRON);
                    player.awardStat(Stats.ITEM_USED.get(stack.getItem()));
                    level.setBlockAndUpdate(pos, state.cycle(LayeredCauldronBlock.LEVEL));
                    level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
                }
                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        });
        CauldronInteraction.EMPTY.put(bottleItem, (state, level, pos, player, hand, stack) -> {
            if (!level.isClientSide) {
                Item item = stack.getItem();
                player.setItemInHand(hand, ItemUtils.createFilledResult(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                player.awardStat(Stats.USE_CAULDRON);
                player.awardStat(Stats.ITEM_USED.get(item));
                level.setBlockAndUpdate(pos, cauldronBlock.defaultBlockState());
                level.playSound(null, pos, SoundEvents.BOTTLE_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                level.gameEvent(null, GameEvent.FLUID_PLACE, pos);
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        });
    }

}