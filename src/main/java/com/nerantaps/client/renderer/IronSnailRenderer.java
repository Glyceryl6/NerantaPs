package com.nerantaps.client.renderer;

import com.nerantaps.NerantaPs;
import com.nerantaps.client.NPModelLayers;
import com.nerantaps.client.model.IronSnailModel;
import com.nerantaps.entity.animal.IronSnail;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class IronSnailRenderer extends MobRenderer<IronSnail, IronSnailModel<IronSnail>> {

    public IronSnailRenderer(EntityRendererProvider.Context context) {
        super(context, new IronSnailModel<>(context.bakeLayer(NPModelLayers.IRON_SNAIL)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(IronSnail entity) {
        return NerantaPs.prefix("textures/entity/iron_snail.png");
    }

}