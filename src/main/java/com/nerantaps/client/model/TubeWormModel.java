package com.nerantaps.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nerantaps.entity.animal.TubeWorm;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class TubeWormModel<T extends TubeWorm> extends EntityModel<T> {

    private final ModelPart group;
    private final ModelPart group2;
    private final ModelPart group3;

    public TubeWormModel(ModelPart root) {
        this.group = root.getChild("group");
        this.group2 = root.getChild("group2");
        this.group3 = root.getChild("group3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        meshDefinition.getRoot().addOrReplaceChild("group", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-5.25F, -9.75F, -1.75F, 7.0F, 13.0F, 7.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(1.25F, 20.75F, -2.25F))
                .addOrReplaceChild("group2", CubeListBuilder.create().texOffs(0, 20)
                        .addBox(-2.25F, -11.75F, -2.75F, 5.0F, 7.0F, 5.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -5.0F, 2.0F))
                .addOrReplaceChild("group3", CubeListBuilder.create().texOffs(28, 5)
                        .addBox(-1.5F, -12.0F, -1.5F, 3.0F, 12.0F, 3.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(0.25F, -10.75F, -0.25F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.group2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.group3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}