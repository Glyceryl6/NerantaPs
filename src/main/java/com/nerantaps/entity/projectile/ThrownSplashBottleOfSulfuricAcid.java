package com.nerantaps.entity.projectile;

import com.nerantaps.registry.NPEntities;
import com.nerantaps.registry.NPItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

import java.util.List;

public class ThrownSplashBottleOfSulfuricAcid extends ThrowableItemProjectile {

    public ThrownSplashBottleOfSulfuricAcid(EntityType<? extends ThrownSplashBottleOfSulfuricAcid> type, Level level) {
        super(type, level);
    }

    public ThrownSplashBottleOfSulfuricAcid(double x, double y, double z, Level level) {
        super(NPEntities.THROWN_SPLASH_BOTTLE_OF_SULFURIC_ACID.get(), x, y, z, level);
    }

    public ThrownSplashBottleOfSulfuricAcid(LivingEntity livingEntity, Level level) {
        super(NPEntities.THROWN_SPLASH_BOTTLE_OF_SULFURIC_ACID.get(), livingEntity, level);
    }

    @Override
    protected Item getDefaultItem() {
        return NPItems.SPLASH_BOTTLE_OF_SULFURIC_ACID.get();
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level.isClientSide) {
            this.level.levelEvent(2007, this.blockPosition(), 0xd3d1b7);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        AABB aabb = this.getBoundingBox().inflate(4.0D, 1.0D, 4.0D);
        List<LivingEntity> list = this.level.getEntitiesOfClass(LivingEntity.class, aabb);
        if (!list.isEmpty()) {
            for (LivingEntity livingEntity : list){
                if (this.distanceToSqr(livingEntity) < 16.0D) {
                    this.hurt(DamageSource.MAGIC, 6.0F);
                }
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level.isClientSide) {
            Direction direction = result.getDirection();
            BlockPos blockPos = result.getBlockPos().below();
            BlockPos blockPos1 = blockPos.relative(direction);
            this.carbonize(blockPos1);
            this.carbonize(blockPos1.relative(direction.getOpposite()));
            for (Direction direction1 : Direction.Plane.HORIZONTAL) {
                this.carbonize(blockPos1.relative(direction1));
            }
        }
    }

    private void carbonize(BlockPos blockPos) {
        BlockState state = this.level.getBlockState(blockPos);
        if (state.is(Blocks.GRASS_BLOCK)) {
            this.level.setBlockAndUpdate(blockPos, Blocks.DIRT.defaultBlockState());
        }
    }

}