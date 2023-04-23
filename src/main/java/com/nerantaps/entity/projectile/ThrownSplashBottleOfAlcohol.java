package com.nerantaps.entity.projectile;

import com.nerantaps.registry.NPEntities;
import com.nerantaps.registry.NPItems;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ThrownSplashBottleOfAlcohol extends ThrowableItemProjectile {

    public ThrownSplashBottleOfAlcohol(EntityType<? extends ThrownSplashBottleOfAlcohol> type, Level level) {
        super(type, level);
    }

    public ThrownSplashBottleOfAlcohol(double x, double y, double z, Level level) {
        super(NPEntities.THROWN_SPLASH_BOTTLE_OF_ALCOHOL.get(), x, y, z, level);
    }

    public ThrownSplashBottleOfAlcohol(LivingEntity livingEntity, Level level) {
        super(NPEntities.THROWN_SPLASH_BOTTLE_OF_ALCOHOL.get(), livingEntity, level);
    }

    @Override
    protected Item getDefaultItem() {
        return NPItems.SPLASH_BOTTLE_OF_ALCOHOL.get();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level.isClientSide) {
            BlockPos blockPos = result.getBlockPos();
            BlockState state = this.level.getBlockState(blockPos);
            if (state.is(BlockTags.FIRE)) {
                Explosion.BlockInteraction type = Explosion.BlockInteraction.NONE;
                this.level.explode(this, this.getX(), this.getY(), this.getZ(), 8.0F, true, type);
            }
            this.discard();
        }
    }

}