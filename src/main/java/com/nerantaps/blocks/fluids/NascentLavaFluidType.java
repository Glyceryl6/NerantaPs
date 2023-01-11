package com.nerantaps.blocks.fluids;

import com.nerantaps.NerantaPs;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidType;

import java.util.function.Consumer;

public class NascentLavaFluidType extends FluidType {

    public NascentLavaFluidType() {
        super(FluidType.Properties.create().canSwim(false).canDrown(false)
                .pathType(BlockPathTypes.LAVA).adjacentPathType(null).motionScale(0.007D)
                .density(2000).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY)
                .sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {

        consumer.accept(new IClientFluidTypeExtensions() {

            @Override
            public ResourceLocation getStillTexture() {
                return NerantaPs.prefix("block/nascent_lava_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return NerantaPs.prefix("block/nascent_lava_flow");
            }

        });

    }

}