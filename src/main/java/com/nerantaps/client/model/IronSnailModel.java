package com.nerantaps.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nerantaps.entity.animal.IronSnail;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

public class IronSnailModel<T extends IronSnail> extends EntityModel<T> {

    private final ModelPart bone4;
    private final ModelPart shell;
    private final ModelPart head;
    private final ModelPart ass;

    public IronSnailModel(ModelPart root) {
        this.bone4 = root.getChild("bone4");
        this.shell = root.getChild("shell");
        this.head = root.getChild("head");
        this.ass = root.getChild("ass");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("bone4", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition shell = partDefinition.addOrReplaceChild("shell", CubeListBuilder.create(), PartPose.offset(-1.0F, 20.0F, 3.0F));
        shell.addOrReplaceChild("shell_r1", CubeListBuilder.create()
                .texOffs(0, 0).addBox(-1.0F, -15.0F, -5.0F, 1.0F, 17.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-5.0F, -15.0F, -1.0F, 10.0F, 17.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.0F, -16.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(22, 30).addBox(-2.0F, -13.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(30, 12).addBox(-3.0F, -8.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.257F, 0.0179F, 0.0082F));
        PartDefinition head = partDefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(16, 21)
                .addBox(-3.0F, 0.0F, -4.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 21.0F, 0.0F));
        head.addOrReplaceChild("head_r1", CubeListBuilder.create().texOffs(48, 25)
                        .addBox(-3.0F, -1.0F, -2.0F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0F, 1.0F, -4.0F, -0.6981F, 0.0F, 0.0F));
        partDefinition.addOrReplaceChild("ass", CubeListBuilder.create().texOffs(16, 21)
                .addBox(-2.0F, -1.0F, 0.0F, 4.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 22.0F, 2.0F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.shell.zRot = Mth.cos(limbSwing * 0.625F) * 0.5F * limbSwingAmount;
        this.head.yRot = Mth.cos(limbSwing * 0.625F) * 0.5F * limbSwingAmount;
        this.ass.yRot = Mth.cos(limbSwing * 0.625F) * 0.2F * limbSwingAmount;
        this.shell.yRot = -1.0265F * (float) Math.PI / 180.0F;
        if (entity.getRetractionTime() > 0) {
            float f = entity.getRetractionTime();
            if (f > 180) {
                this.shell.xRot += this.degree(0.25F);
                this.head.xRot -= this.degree(-1.5F);
                this.ass.xRot -= this.degree(1.0F);
                this.shell.y += 0.05F;
                this.head.z += 0.05F;
            } else if (f > 40) {
                this.head.xRot = (float) Math.PI / 2.0F;
                this.ass.xRot = this.degree(-67.5F);
            } else if (f > 20) {
                this.shell.xRot -= this.degree(0.25F);
                this.head.xRot += this.degree(-1.5F);
                this.ass.xRot += this.degree(1.0F);
                this.shell.y -= 0.05F;
                this.head.z -= 0.05F;
            }
        } else {
            this.shell.xRot = 0.0F;
            this.head.xRot = 0.0F;
            this.ass.xRot = 0.0F;
            this.shell.y = 20.0F;
            this.head.y = 21.0F;
            this.head.z = 0.0F;
            this.ass.y = 22.0F;
        }
    }
    
    private float degree(float f) {
        return f * ((float) Math.PI / 180.0F);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.bone4.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.shell.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.ass.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}