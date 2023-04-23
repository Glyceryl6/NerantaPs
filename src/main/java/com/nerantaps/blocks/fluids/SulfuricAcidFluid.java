package com.nerantaps.blocks.fluids;

import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPFluids;
import com.nerantaps.registry.NPItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nonnull;
import java.util.Optional;

public abstract class SulfuricAcidFluid extends ForgeFlowingFluid {

    private static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(
            NPFluids.SULFURIC_ACID_TYPE, NPFluids.SULFURIC_ACID, NPFluids.FLOWING_SULFURIC_ACID)
            .explosionResistance(100f).tickRate(20).levelDecreasePerBlock(2)
            .bucket(NPItems.SULFURIC_ACID_BUCKET).block(() -> (LiquidBlock) NPBlocks.SULFURIC_ACID.get());

    protected SulfuricAcidFluid() {
        super(PROPERTIES);
    }

    @Nonnull @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL_LAVA);
    }

    public static class Source extends SulfuricAcidFluid {

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }

        @Override
        public int getAmount(FluidState state) {
            return 3;
        }

    }

    public static class Flowing extends SulfuricAcidFluid {

        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }

    }

}