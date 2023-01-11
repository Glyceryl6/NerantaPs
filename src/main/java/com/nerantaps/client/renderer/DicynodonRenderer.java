package com.nerantaps.client.renderer;

import com.nerantaps.NerantaPs;
import com.nerantaps.client.NPModelLayers;
import com.nerantaps.client.model.DicynodonModel;
import com.nerantaps.entity.animal.Dicynodon;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DicynodonRenderer extends MobRenderer<Dicynodon, DicynodonModel<Dicynodon>> {

    public DicynodonRenderer(EntityRendererProvider.Context context) {
        super(context, new DicynodonModel<>(context.bakeLayer(NPModelLayers.DICYNODON)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Dicynodon entity) {
        return NerantaPs.prefix("textures/entity/dicynodon.png");
    }

}