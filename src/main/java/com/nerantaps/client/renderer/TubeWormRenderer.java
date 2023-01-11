package com.nerantaps.client.renderer;

import com.nerantaps.NerantaPs;
import com.nerantaps.client.NPModelLayers;
import com.nerantaps.client.model.TubeWormModel;
import com.nerantaps.entity.animal.TubeWorm;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class TubeWormRenderer extends MobRenderer<TubeWorm, TubeWormModel<TubeWorm>> {

    public TubeWormRenderer(EntityRendererProvider.Context context) {
        super(context, new TubeWormModel<>(context.bakeLayer(NPModelLayers.TUBE_WORM)), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(TubeWorm entity) {
        return NerantaPs.prefix("textures/entity/tube_worm.png");
    }

}