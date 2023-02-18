package com.nerantaps.entity.animal;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

import java.util.Objects;

public class IronSnail extends PathfinderMob {

    public final AnimationState inShellAnimationState = new AnimationState();

    public IronSnail(EntityType<? extends IronSnail> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new FloatGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 10.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.15F)
                .add(Attributes.FOLLOW_RANGE, 16.0F)
                .add(Attributes.MAX_HEALTH, 10.0F)
                .add(Attributes.ARMOR, 10.0F);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level.isClientSide() && this.attributes.hasAttribute(Attributes.MOVEMENT_SPEED)) {
            float f = this.inShellAnimationState.isStarted() ? 0.0F : 0.15F;
            Objects.requireNonNull(this.getAttribute(Attributes.MOVEMENT_SPEED)).setBaseValue(f);
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.level.isClientSide()) {
            this.inShellAnimationState.startIfStopped(this.tickCount);
        }
        return !(source.isProjectile() || source.isDamageHelmet() || source.isFall()
                || source.isExplosion() || source == DamageSource.DROWN);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}