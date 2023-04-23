package com.nerantaps.entity.monster;

import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPParticles;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class PaloloWorm extends Monster {

    private static final EntityDataAccessor<Boolean> IS_CREEPING = SynchedEntityData.defineId(PaloloWorm.class, EntityDataSerializers.BOOLEAN);
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState drillAnimationState = new AnimationState();

    public PaloloWorm(EntityType<? extends PaloloWorm> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.0F)
                .add(Attributes.ATTACK_DAMAGE, 4.0F)
                .add(Attributes.FOLLOW_RANGE, 16.0F)
                .add(Attributes.MAX_HEALTH, 20.0F)
                .add(Attributes.ARMOR, 2.0F);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_CREEPING, true);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("Creeping", this.isCreeping());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(IS_CREEPING, compound.getBoolean("Creeping"));
    }

    public boolean isCreeping() {
        return this.entityData.get(IS_CREEPING);
    }

    @Override
    public void tick() {
        super.tick();
        int n = this.getPersistentData().getInt("number");
        this.getPersistentData().putInt("number",  n + 1);
        if (n > 0 && n < 66 && this.level.isClientSide) {
            this.idleAnimationState.startIfStopped(this.tickCount);
        } else if (n == 66 && this.level.isClientSide) {
            this.idleAnimationState.stop();
            this.drillAnimationState.startIfStopped(this.tickCount);
        } else if (n == 100) {
            if (this.level.isClientSide) {
                this.level.addParticle(NPParticles.SILT.get(), this.getX(), this.getY(), this.getZ(), 0.2F, 0.2F, 0.2F);
            } else {
                this.level.setBlockAndUpdate(this.getOnPos().above(), NPBlocks.PALOLO_WORM_HOLE.get().defaultBlockState());
                this.discard();
            }
        }
    }

}