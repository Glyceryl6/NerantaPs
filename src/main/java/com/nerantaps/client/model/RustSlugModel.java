package com.nerantaps.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.nerantaps.entity.monster.RustSlug;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class RustSlugModel<T extends RustSlug> extends EntityModel<T> {

    private final ModelPart all;
    private final ModelPart bb_main;

    public RustSlugModel(ModelPart root) {
        this.all = root.getChild("all");
        this.bb_main = root.getChild("bb_main");
    }

    @SuppressWarnings("unused")
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition all = partDefinition.addOrReplaceChild("all", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition bone9 = all.addOrReplaceChild("bone9", CubeListBuilder.create().texOffs(0, 13)
                .addBox(-3.0F, -16.0F, -3.0F, 6.0F, 6.0F, 6.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition bone3 = all.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(24, 13)
                .addBox(-1.5F, -0.25F, -1.5F, 3.0F, 5.0F, 3.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(2.5F, -8.75F, 2.5F));
        PartDefinition bone8 = bone3.addOrReplaceChild("bone8", CubeListBuilder.create().texOffs(0, 25)
                .addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 4.75F, -0.5F));
        PartDefinition bone2 = all.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(24, 13).mirror()
                .addBox(-1.5F, -0.25F, -1.5F, 3.0F, 5.0F, 3.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -8.75F, 2.5F));
        PartDefinition bone = bone2.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(0, 25).mirror()
                .addBox(-1.0F, -1.0F, -1.0F, 2.0F, 6.0F, 2.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 4.75F, -0.5F));
        PartDefinition bone4 = all.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(21, 22)
                .addBox(-1.5F, -0.25F, -1.5F, 3.0F, 5.0F, 3.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(-2.5F, -8.75F, -2.5F));
        PartDefinition bone6 = bone4.addOrReplaceChild("bone6", CubeListBuilder.create().texOffs(0, 0).mirror()
                .addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.5F, 5.75F, 0.5F));
        PartDefinition bone5 = all.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(21, 22).mirror()
                .addBox(-1.5F, -0.25F, -1.5F, 3.0F, 5.0F, 3.0F,
                        new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, -8.75F, -2.5F));
        PartDefinition bone7 = bone5.addOrReplaceChild("bone7", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-1.5F, -1.5F, -0.5F, 2.0F, 6.0F, 2.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.25F, 0.0F));
        PartDefinition bb_main = partDefinition.addOrReplaceChild("bb_main", CubeListBuilder.create().texOffs(0, 0)
                .addBox(-5.0F, -12.0F, -5.0F, 10.0F, 3.0F, 10.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(T pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        this.all.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }

}