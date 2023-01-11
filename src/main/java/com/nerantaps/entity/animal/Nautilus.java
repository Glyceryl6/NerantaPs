package com.nerantaps.entity.animal;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkHooks;

public class Nautilus extends WaterAnimal {

    public Nautilus(EntityType<? extends Nautilus> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new RandomSwimmingGoal(this, 1, 40));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.4F)
                .add(Attributes.MAX_HEALTH, 10.0F)
                .add(Attributes.ARMOR, 4.0F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0F)
                .add(ForgeMod.SWIM_SPEED.get(), 0.4F);
    }

    public boolean isMovingInWater() {
        return this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D && this.isInWaterOrBubble();
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        Entity entity = source.getDirectEntity();
        boolean flag1 = entity instanceof ThrownPotion;
        boolean flag2 = entity instanceof AreaEffectCloud;
        if (flag1 || flag2 || source == DamageSource.DROWN) {
            return false;
        }
        return super.hurt(source, amount);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}