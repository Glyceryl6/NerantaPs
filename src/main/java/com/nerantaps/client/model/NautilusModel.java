package com.nerantaps.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nerantaps.entity.animal.Nautilus;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class NautilusModel<T extends Nautilus> extends EntityModel<T> {

    private final ModelPart bone;
    private final ModelPart bone2;

    public NautilusModel(ModelPart root) {
        this.bone = root.getChild("bone");
        this.bone2 = root.getChild("bone2");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-3.0F, -7.44F, -3.0F, 6.0F, 12.0F, 12.0F,
                        new CubeDeformation(0.0F)).texOffs(35, 0)
                .addBox(-3.5F, -1.44F, -6.0F, 7.0F, 1.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-3.0F, 19.44F, -1.0F));
        partDefinition.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(40, 8).mirror()
                .addBox(-2.5F, -2.5F, -5.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .mirror(false), PartPose.offset(0.0F, 2.26F, -2.0F));
        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.bone2.yRot = -0.5F;
        this.bone2.y = 20.5F;
        this.bone2.x = -3.0F;
        if (entity.isMovingInWater()) {
            this.bone.xRot = Mth.cos(ageInTicks * 0.15F) / 6.0F;
            this.bone2.xRot = Mth.cos(ageInTicks * 0.15F) / 7.0F;
        } else {
            this.bone.y = Mth.cos(ageInTicks * 0.15F) + 18.5F;
            this.bone2.xRot = -Mth.cos(ageInTicks * 0.15F) / 11.0F + 0.2F;
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.bone2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}