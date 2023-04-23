package com.nerantaps.blocks.fluids;

import com.nerantaps.registry.NPFluids;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

@SuppressWarnings("deprecation")
public class NascentLava extends LiquidBlock {

    public NascentLava() {
        super(NPFluids.NASCENT_LAVA, BlockBehaviour.Properties.of(Material.LAVA)
                .strength(100f).lightLevel(s -> 15).noCollission().noLootTable());
    }

    @Override
    public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity livingEntity) {
            livingEntity.hurt(DamageSource.LAVA, 10);
            livingEntity.setSecondsOnFire(15);
        }
    }

}