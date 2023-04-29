package com.nerantaps.client.renderer;

import com.nerantaps.NerantaPs;
import com.nerantaps.client.NPModelLayers;
import com.nerantaps.entity.animal.HellBee;
import net.minecraft.client.model.BeeModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HellBeeRenderer extends MobRenderer<HellBee, BeeModel<HellBee>> {

    public HellBeeRenderer(EntityRendererProvider.Context context) {
        super(context, new BeeModel<>(context.bakeLayer(NPModelLayers.HELL_BEE)), 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(HellBee hellBee) {
        return NerantaPs.prefix("textures/entity/hell_bee.png");
    }

}