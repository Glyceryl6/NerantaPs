package com.nerantaps.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nerantaps.entity.monster.WingSnake;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class WingSnakeModel<T extends WingSnake> extends EntityModel<T> {

    private final ModelPart head;
    private final ModelPart body;

    public WingSnakeModel(ModelPart root) {
        this.head = root.getChild("head");
        this.body = root.getChild("body");
    }

    @SuppressWarnings("unused")
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-3.0F, -7.0F, -5.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(13, 43).addBox(-2.0F, -6.0F, -9.0F, 4.0F, 5.0F, 4.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 2.0F));
        PartDefinition rightEar = head.addOrReplaceChild("rightEar", CubeListBuilder.create().texOffs(24, 0)
                .addBox(-3.0F, -6.0F, -1.0F, 3.0F, 4.0F, 2.0F,
                        new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, -2.0F, -1.5708F, -1.1781F, 1.5708F));
        PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 16)
                .addBox(-3.0F, 4.0F, -3.0F, 6.0F, 12.0F, 6.0F,
                        new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.5236F, 0.0F, 0.0F));
        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 15.5281F, -0.2988F));
        PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(8, 52)
                .addBox(-3.0F, -1.5F, -7.0F, 6.0F, 6.0F, 6.0F,
                        new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -13.0F, -1.6144F, 0.0F, 0.0F));
        PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(32, 53)
                .addBox(-2.0F, -3.5F, -6.0F, 4.0F, 7.0F, 4.0F,
                        new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, -13.0F, -2.3562F, 0.0F, 0.0F));
        PartDefinition cube_r3 = tail.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(32, 54)
                .addBox(-2.0F, 3.0F, -2.0F, 4.0F, 6.0F, 4.0F,
                        new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.4719F, 0.2988F, -1.309F, 0.0F, 0.0F));
        PartDefinition cube_r4 = tail.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(32, 54)
                .addBox(-2.0F, -3.0F, -4.0F, 4.0F, 6.0F, 4.0F,
                        new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.4719F, 0.2988F, -0.6545F, 0.0F, 0.0F));
        PartDefinition rightWing = body.addOrReplaceChild("rightWing", CubeListBuilder.create().texOffs(42, 0)
                .addBox(-12.0F, 1.0F, 1.5F, 10.0F, 16.0F, 1.0F,
                        new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));
        PartDefinition rightWingTip = rightWing.addOrReplaceChild("rightWingTip", CubeListBuilder.create().texOffs(24, 16)
                .addBox(-8.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F,
                        new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, 1.0F, 1.5F, 0.0F, -0.2618F, 0.0F));
        PartDefinition leftWing = body.addOrReplaceChild("leftWing", CubeListBuilder.create().texOffs(42, 0).mirror()
                .addBox(2.0F, 1.0F, 1.5F, 10.0F, 16.0F, 1.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));
        PartDefinition leftWingTip = leftWing.addOrReplaceChild("leftWingTip", CubeListBuilder.create().texOffs(24, 16).mirror()
                .addBox(0.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(12.0F, 1.0F, 1.5F, 0.0F, 0.2618F, 0.0F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}