package com.nerantaps.client.model;

import com.nerantaps.client.animation.IronSnailAnimation;
import com.nerantaps.entity.animal.IronSnail;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IronSnailModel<T extends IronSnail> extends HierarchicalModel<T> {

    private final ModelPart root;
    protected final ModelPart bone4;
    protected final ModelPart shell;
    protected final ModelPart head;
    protected final ModelPart ass;

    public IronSnailModel(ModelPart root) {
        this.root = root;
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
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.shell.yRot = -1.0265F * (float) Math.PI / 180.0F;
        this.shell.zRot = Mth.cos(limbSwing * 0.625F) * 0.5F * limbSwingAmount;
        this.head.yRot = Mth.cos(limbSwing * 0.625F) * 0.5F * limbSwingAmount;
        this.ass.yRot = Mth.cos(limbSwing * 0.625F) * 0.2F * limbSwingAmount;
        this.animate(entity.inShellAnimationState, IronSnailAnimation.IN_SHELL, ageInTicks);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

}