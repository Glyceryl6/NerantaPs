package com.nerantaps.blocks.fluids;

import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPFluids;
import com.nerantaps.registry.NPItems;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fluids.ForgeFlowingFluid;

public abstract class AlcoholFluid extends ForgeFlowingFluid {

    private static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(
            NPFluids.ALCOHOL_TYPE, NPFluids.ALCOHOL, NPFluids.FLOWING_ALCOHOL)
            .explosionResistance(100f).tickRate(20).levelDecreasePerBlock(2)
            .bucket(NPItems.ALCOHOL_BUCKET).block(() -> (LiquidBlock) NPBlocks.ALCOHOL.get());

    protected AlcoholFluid() {
        super(PROPERTIES);
    }

    public static class Source extends AlcoholFluid {

        @Override
        public boolean isSource(FluidState state) {
            return true;
        }

        @Override
        public int getAmount(FluidState state) {
            return 7;
        }

    }

    public static class Flowing extends AlcoholFluid {

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