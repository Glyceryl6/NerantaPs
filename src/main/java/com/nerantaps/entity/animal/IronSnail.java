package com.nerantaps.entity.animal;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.level.Level;
import net.minecraftforge.network.NetworkHooks;

public class IronSnail extends PathfinderMob {

    private static final EntityDataAccessor<Integer> RETRACTION_TIME = SynchedEntityData.defineId(IronSnail.class, EntityDataSerializers.INT);

    public IronSnail(EntityType<? extends IronSnail> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
        this.goalSelector.addGoal(1, new IronSnailMeleeAttackGoal(this, 1.2, false));
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
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(RETRACTION_TIME, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("RetractionTime", this.entityData.get(RETRACTION_TIME));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(RETRACTION_TIME, compound.getInt("RetractionTime"));
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.getRetractionTime() > 0) {
            this.entityData.set(RETRACTION_TIME, this.getRetractionTime() - 1);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0F);
        } else {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.15F);
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            if (this.getRetractionTime() <= 0) {
                this.entityData.set(RETRACTION_TIME, 200);
            } else if (this.getRetractionTime() < 160 && this.getRetractionTime() > 40) {
                amount /= 1.5F;
            }
            return super.hurt(source, amount);
        }
    }

    public int getRetractionTime() {
        return this.entityData.get(RETRACTION_TIME);
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    static class IronSnailMeleeAttackGoal extends MeleeAttackGoal {

        public IronSnailMeleeAttackGoal(PathfinderMob mob, double speedModifier, boolean followingTargetEvenIfNotSeen) {
            super(mob, speedModifier, followingTargetEvenIfNotSeen);
        }

        @Override
        protected double getAttackReachSqr(LivingEntity entity) {
            return 4.0 + entity.getBbWidth() * entity.getBbWidth();
        }

    }

}