package com.nerantaps.level.effect;

import com.nerantaps.registry.NPEffects;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class NPMobEffect extends MobEffect {

    private final boolean isInstantenous;
    
    public NPMobEffect(MobEffectCategory category, int color, boolean isInstantenous) {
        super(category, color);
        this.isInstantenous = isInstantenous;
    }

    @Override
    public void applyInstantenousEffect(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {
        if (this == NPEffects.CORRODE.get()) {
            for (EquipmentSlot slots : EquipmentSlot.values()) {
                ItemStack slotsStack = livingEntity.getItemBySlot(slots);
                boolean flag1 = slots.getType() == EquipmentSlot.Type.ARMOR;
                boolean flag2 = slotsStack.getItem() instanceof ArmorItem;
                if (flag1 && flag2) {
                    if (livingEntity instanceof Player player && player.getAbilities().instabuild) {
                        return;
                    }
                    int damage = slotsStack.getDamageValue();
                    float reduceDamage = (float) damage * 0.1F;
                    float newDamage = (float) damage - reduceDamage;
                    slotsStack.setDamageValue(Mth.floor(newDamage));
                }
            }
        }
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return this.isInstantenous ? duration >= 1 : super.isDurationEffectTick(duration, amplifier);
    }

    @Override
    public boolean isInstantenous() {
        return this.isInstantenous;
    }

}