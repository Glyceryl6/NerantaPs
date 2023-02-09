package com.nerantaps.client.model;

import com.nerantaps.client.animation.TubeWormAnimation;
import com.nerantaps.entity.animal.TubeWorm;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class TubeWormModel<T extends TubeWorm> extends HierarchicalModel<T> {

    private final ModelPart root;
    protected final ModelPart group;
    protected final ModelPart group2;
    protected final ModelPart group3;

    public TubeWormModel(ModelPart root) {
        this.root = root;
        this.group = root.getChild("group");
        this.group2 = root.getChild("group2");
        this.group3 = root.getChild("group3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("group", CubeListBuilder.create().texOffs(28, 5)
                .addBox(-1.5F, -12.0F, -1.5F, 3.0F, 12.0F, 3.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(-0.5F, 5.0F, -0.5F));
        partDefinition.addOrReplaceChild("group3", CubeListBuilder.create().texOffs(0, 20)
                .addBox(-2.25F, -11.75F, -2.75F, 5.0F, 7.0F, 5.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(-0.75F, 15.75F, -0.25F));
        partDefinition.addOrReplaceChild("group2", CubeListBuilder.create().texOffs(0, 0).
                addBox(-5.25F, -9.75F, -1.75F, 7.0F, 13.0F, 7.0F,
                        new CubeDeformation(0.0F)), PartPose.offset(1.25F, 20.75F, -2.25F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.animate(entity.idleAnimationState, TubeWormAnimation.IDLE, ageInTicks);
        this.animate(entity.swimAnimationState, TubeWormAnimation.SWIM, ageInTicks);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

}