package com.nerantaps.blocks.fluids;

import com.nerantaps.NerantaPs;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

public class NormalFluidTextures implements IClientFluidTypeExtensions {

    @Override
    public ResourceLocation getStillTexture() {
        return new ResourceLocation("block/water_still");
    }

    @Override
    public ResourceLocation getFlowingTexture() {
        return NerantaPs.prefix("block/nascent_lava_flow");
    }

}