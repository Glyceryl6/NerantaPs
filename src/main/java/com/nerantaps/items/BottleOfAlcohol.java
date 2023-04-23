package com.nerantaps.items;

import com.nerantaps.registry.NPEffects;
import com.nerantaps.registry.NPTabs;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.stats.Stats;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import java.util.Objects;

public class BottleOfAlcohol extends Item {

    public BottleOfAlcohol() {
        super((new Item.Properties().tab(NPTabs.TAB_NERANTA_TAB_1)).craftRemainder(Items.GLASS_BOTTLE));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        super.finishUsingItem(stack, level, livingEntity);
        if (livingEntity instanceof ServerPlayer serverPlayer) {
            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);
            serverPlayer.awardStat(Stats.ITEM_USED.get(this));
        }

        if (!level.isClientSide && livingEntity instanceof Player player) {
            if (player.hasEffect(NPEffects.DRUNKENNESS.get())) {
                int amplifier = Objects.requireNonNull(player.getEffect(NPEffects.DRUNKENNESS.get())).getAmplifier();
                int newAmplifier = 1200 / (amplifier + 1);
                player.addEffect(new MobEffectInstance(NPEffects.DRUNKENNESS.get(),
                        newAmplifier, 0, false, false, false));
                if (amplifier >= 2) {
                    player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600, amplifier - 1));
                    player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, amplifier - 2));
                } else {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, newAmplifier, amplifier));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, newAmplifier, amplifier));
                }
            } else {
                player.addEffect(new MobEffectInstance(NPEffects.DRUNKENNESS.get(),
                        1200, 0, false, false, false));
            }
        }

        if (stack.isEmpty()) {
            return new ItemStack(Items.GLASS_BOTTLE);
        } else {
            if (livingEntity instanceof Player player && !player.getAbilities().instabuild) {
                ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
                if (!player.getInventory().add(itemStack)) {
                    player.drop(itemStack, false);
                }
            }

            return stack;
        }
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        return 40;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack pStack) {
        return UseAnim.DRINK;
    }

    @Override
    public SoundEvent getEatingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

}