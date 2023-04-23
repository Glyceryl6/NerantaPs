package com.nerantaps.items;

import com.nerantaps.registry.NPTabs;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class DetoxifySoup extends BowlFoodItem {
    
    public DetoxifySoup() {
        super(new Item.Properties().tab(NPTabs.TAB_NERANTA_TAB_1).food((new FoodProperties.Builder()).nutrition(1).build()));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        ItemStack itemStack = super.finishUsingItem(stack, level, livingEntity);
        if (!livingEntity.level.isClientSide) {
            for (MobEffectInstance effect : livingEntity.getActiveEffects()) {
                if (effect.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
                    livingEntity.removeEffect(effect.getEffect());
                }
            }
        }

        return livingEntity instanceof Player && ((Player)livingEntity).getAbilities().instabuild ? itemStack : new ItemStack(Items.BOWL);
    }

}