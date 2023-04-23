package com.nerantaps.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import com.nerantaps.NerantaPs;
import com.nerantaps.client.NPModelLayers;
import com.nerantaps.client.model.PaloloWormModel;
import com.nerantaps.entity.monster.PaloloWorm;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PaloloWormRenderer extends MobRenderer<PaloloWorm, PaloloWormModel<PaloloWorm>> {

    public PaloloWormRenderer(EntityRendererProvider.Context context) {
        super(context, new PaloloWormModel<>(context.bakeLayer(NPModelLayers.PALOLO_WORM)), 0.5F);
    }

    @Override
    public void render(PaloloWorm entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (!entity.isCreeping()) {
            poseStack.mulPose(Vector3f.XN.rotationDegrees(90.0F));
        }
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(PaloloWorm entity) {
        return NerantaPs.prefix("textures/entity/palolo_worm.png");
    }

}