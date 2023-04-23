package com.nerantaps.blocks.fluids;

import com.nerantaps.registry.NPBlocks;
import com.nerantaps.registry.NPFluids;
import com.nerantaps.registry.NPItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.ForgeFlowingFluid;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

public abstract class NascentLavaFluid extends ForgeFlowingFluid {

    private static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(
            NPFluids.NASCENT_LAVA_TYPE, NPFluids.NASCENT_LAVA, NPFluids.FLOWING_NASCENT_LAVA)
            .explosionResistance(100f).tickRate(20).levelDecreasePerBlock(2)
            .bucket(NPItems.NASCENT_LAVA_BUCKET).block(() -> (LiquidBlock) NPBlocks.NASCENT_LAVA.get());

    public NascentLavaFluid() {
        super(PROPERTIES);
    }

    @Override
    public ParticleOptions getDripParticle() {
        return ParticleTypes.LAVA;
    }

    @Override
    protected void animateTick(Level level, BlockPos pos, FluidState fluidState, RandomSource randomSource) {
        Fluids.LAVA.defaultFluidState().animateTick(level, pos, randomSource);
    }

    @Override
    protected void randomTick(Level level, BlockPos pos, FluidState fluidState, RandomSource randomSource) {
        Fluids.LAVA.defaultFluidState().randomTick(level, pos, randomSource);
    }

    @Override
    protected boolean isRandomlyTicking() {
        return true;
    }

    @Nonnull @Override
    public Optional<SoundEvent> getPickupSound() {
        return Optional.of(SoundEvents.BUCKET_FILL_LAVA);
    }

    public static class Source extends NascentLavaFluid {

        public int getAmount(FluidState state) {
            return 8;
        }

        public boolean isSource(FluidState state) {
            return true;
        }

    }

    public static class Flowing extends NascentLavaFluid {

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