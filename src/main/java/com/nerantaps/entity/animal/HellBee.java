package com.nerantaps.entity.animal;

import net.minecraft.network.protocol.Packet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class HellBee extends Bee {

    public HellBee(EntityType<? extends HellBee> type, Level level) {
        super(type, level);
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean flag = entity.hurt(DamageSource.sting(this), 4.0F);
        if (flag) {
            this.doEnchantDamageEffects(this, entity);
            if (entity instanceof LivingEntity livingEntity) {
                livingEntity.setStingerCount(livingEntity.getStingerCount() + 1);
                MobEffect[] effects = new MobEffect[]{MobEffects.HUNGER, MobEffects.CONFUSION, MobEffects.POISON};
                livingEntity.addEffect(new MobEffectInstance(effects[this.random.nextInt(effects.length)], 1000));
            }

            this.setHasStung(true);
            this.playSound(SoundEvents.BEE_STING, 1.0F, 1.0F);
        }

        return flag;
    }

    @Override
    protected void customServerAiStep() {
        if (this.isInWaterOrBubble()) {
            ++this.underWaterTicks;
        } else {
            this.underWaterTicks = 0;
        }

        if (this.underWaterTicks > 20) {
            this.hurt(DamageSource.DROWN, 1.0F);
        }

        if (!this.hasNectar()) {
            ++this.ticksWithoutNectarSinceExitingHive;
        }

        if (!this.level.isClientSide) {
            this.updatePersistentAnger((ServerLevel)this.level, false);
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}