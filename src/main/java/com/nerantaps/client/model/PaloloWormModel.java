package com.nerantaps.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nerantaps.entity.monster.PaloloWorm;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class PaloloWormModel<T extends PaloloWorm> extends EntityModel<T> {

    private final ModelPart part4;

    public PaloloWormModel(ModelPart root) {
        this.part4 = root.getChild("part4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        meshDefinition.getRoot().addOrReplaceChild("part4", CubeListBuilder.create().texOffs(0, 13)
                                .addBox(3.0F, -4.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                                .addBox(-3.0F, -4.0F, -2.5F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 13).mirror()
                                .addBox(-5.0F, -4.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false),
                        PartPose.offsetAndRotation(0.1897F, 21.4874F, -3.0023F, 1.5708F, -0.0205F, -0.0253F))
                .addOrReplaceChild("part5", CubeListBuilder.create().texOffs(0, 13)
                        .addBox(3.0F, 1.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-3.0F, 1.0F, -2.5F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 13).mirror()
                        .addBox(-5.0F, 1.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                        .mirror(false), PartPose.offset(0.0F, 3.0F, 0.0F))
                .addOrReplaceChild("part6", CubeListBuilder.create().texOffs(0, 13)
                        .addBox(3.0F, -1.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-3.0F, -1.0F, -2.5F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 13).mirror()
                        .addBox(-5.0F, -1.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                        .mirror(false), PartPose.offset(0.0F, 10.0F, 0.0F))
                .addOrReplaceChild("tail", CubeListBuilder.create().texOffs(18, 4).mirror()
                        .addBox(-2.0F, 24.0F, -2.0F, 4.0F, 6.0F, 3.0F, new CubeDeformation(0.0F))
                        .mirror(false), PartPose.offset(0.0F, -17.0F, 0.5F))
                .addOrReplaceChild("part3", CubeListBuilder.create().texOffs(0, 13)
                        .addBox(3.0F, -8.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
                        .addBox(-3.0F, -8.0F, -2.5F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 13).mirror()
                        .addBox(-5.0F, -8.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                        .mirror(false), PartPose.offset(0.0F, -4.0F, 0.0F))
                .addOrReplaceChild("part2", CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -9.0F, -2.5F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 13)
                        .addBox(3.0F, -9.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 13).mirror()
                        .addBox(-5.0F, -9.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                        .mirror(false), PartPose.offset(0.0F, -7.0F, 0.0F))
                .addOrReplaceChild("part1", CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-3.0F, -9.0F, -2.5F, 6.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 13).mirror()
                        .addBox(-5.0F, -9.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 13)
                        .addBox(3.0F, -9.0F, -0.5F, 2.0F, 8.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F))
                .addOrReplaceChild("head", CubeListBuilder.create().texOffs(6, 13)
                        .addBox(-4.0F, -2.5F, -2.3333F, 8.0F, 4.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(16, 25)
                        .addBox(-3.0F, -7.5F, 0.6667F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(22, 15)
                        .addBox(-2.0F, -4.5F, -2.3333F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.5F, -0.1667F))
                .addOrReplaceChild("left", CubeListBuilder.create().texOffs(0, 28)
                        .addBox(-0.25F, -1.75F, -1.0F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(22, 0)
                        .addBox(-1.25F, -0.75F, 0.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.25F, -3.75F, -0.3333F))
                .addOrReplaceChild("right", CubeListBuilder.create().texOffs(0, 28).mirror()
                        .addBox(-6.75F, -1.75F, -1.0F, 7.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(22, 0).mirror()
                        .addBox(-2.75F, -0.75F, 0.0F, 4.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                        .mirror(false), PartPose.offset(-2.25F, -3.75F, -0.3333F));
        return LayerDefinition.create(meshDefinition, 32, 32);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.part4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}