package com.nerantaps.client.renderer;

import com.nerantaps.NerantaPs;
import com.nerantaps.client.NPModelLayers;
import com.nerantaps.client.model.RustSlugModel;
import com.nerantaps.entity.monster.RustSlug;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RustSlugRenderer extends MobRenderer<RustSlug, RustSlugModel<RustSlug>> {

    public RustSlugRenderer(EntityRendererProvider.Context context) {
        super(context, new RustSlugModel<>(context.bakeLayer(NPModelLayers.RUST_SLUG)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(RustSlug hellBee) {
        return NerantaPs.prefix("textures/entity/rust_slug.png");
    }

}