package com.nerantaps.entity.animal;

import net.minecraft.network.protocol.Packet;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.network.NetworkHooks;

public class TubeWorm extends PathfinderMob {

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState swimAnimationState = new AnimationState();

    public TubeWorm(EntityType<? extends TubeWorm> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.2F)
                .add(Attributes.MAX_HEALTH, 16.0F)
                .add(Attributes.ARMOR, 0.0F)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0F)
                .add(ForgeMod.SWIM_SPEED.get(), 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.level.isClientSide() && this.tickCount % 200 == 20) {
            if (this.isInWaterOrBubble()) {
                this.swimAnimationState.start(this.tickCount);
                this.idleAnimationState.stop();
            } else {
                this.idleAnimationState.start(this.tickCount);
                this.swimAnimationState.stop();
            }
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

}