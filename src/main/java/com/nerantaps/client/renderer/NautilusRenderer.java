package com.nerantaps.client.renderer;

import com.nerantaps.NerantaPs;
import com.nerantaps.client.NPModelLayers;
import com.nerantaps.client.model.NautilusModel;
import com.nerantaps.entity.animal.Nautilus;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class NautilusRenderer extends MobRenderer<Nautilus, NautilusModel<Nautilus>> {

    public NautilusRenderer(EntityRendererProvider.Context context) {
        super(context, new NautilusModel<>(context.bakeLayer(NPModelLayers.NAUTILUS)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Nautilus entity) {
        return NerantaPs.prefix("textures/entity/nautilus.png");
    }

}