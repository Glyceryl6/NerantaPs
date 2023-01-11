package com.nerantaps.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nerantaps.entity.animal.Dicynodon;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class DicynodonModel<T extends Dicynodon> extends EntityModel<T> {

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart rightHindLeg;
    private final ModelPart leftHindLeg;
    private final ModelPart rightFrontLeg;
    private final ModelPart leftFrontLeg;
    private final ModelPart tail;

    public DicynodonModel(ModelPart root) {
        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.rightHindLeg = root.getChild("leg0");
        this.leftHindLeg = root.getChild("leg1");
        this.rightFrontLeg = root.getChild("leg2");
        this.leftFrontLeg = root.getChild("leg3");
        this.tail = root.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(28, 0)
                .addBox(-5.0F, -8.0F, -7.0F, 10.0F, 14.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 11.0F, 2.0F, 1.5708F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).mirror()
                .addBox(-4.0F, -3.0F, -6.0F, 8.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(46, 22)
                .addBox(-3.0F, -1.0F, -9.0F, 6.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(28, 3)
                .addBox(3.0F, 1.5F, -7.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 3)
                .addBox(-4.0F, 1.5F, -7.0F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, -6.0F));
        partDefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(0, 43).mirror()
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 18.0F, 7.0F));
        partDefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 33).mirror()
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 18.0F, 7.0F));
        partDefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 23).mirror()
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 18.0F, -5.0F));
        partDefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 13).mirror()
                .addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, 18.0F, -5.0F));
        PartDefinition tail = partDefinition.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offset(0.0F, 12.0F, 8.0F));
        tail.addOrReplaceChild("tail_r1", CubeListBuilder.create().texOffs(48, 8)
                        .addBox(-1.0F, -1.0F, 4.0F, 2.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.5672F, 0.0F, 0.0F));
        tail.addOrReplaceChild("tail_r2", CubeListBuilder.create().texOffs(48, 8)
                        .addBox(-2.0F, -1.0F, -1.0F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.rightHindLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftHindLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.leftFrontLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.rightHindLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.leftHindLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.rightFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.leftFrontLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.tail.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}