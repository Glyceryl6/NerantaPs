package com.nerantaps.items;

import com.nerantaps.entity.projectile.ThrownSplashBottleOfSulfuricAcid;
import com.nerantaps.registry.NPTabs;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class SplashBottleOfSulfuricAcid extends Item {

    public SplashBottleOfSulfuricAcid() {
        super(new Item.Properties().tab(NPTabs.TAB_NERANTA_TAB_1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);
        float pitch = 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F);
        level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5F, pitch);
        if (!level.isClientSide) {
            ThrownSplashBottleOfSulfuricAcid sulfuricAcid = new ThrownSplashBottleOfSulfuricAcid(player, level);
            sulfuricAcid.setItem(itemInHand);
            sulfuricAcid.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            level.addFreshEntity(sulfuricAcid);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemInHand.shrink(1);
        }

        return InteractionResultHolder.sidedSuccess(itemInHand, level.isClientSide());
    }

}