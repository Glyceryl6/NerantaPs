// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class eternal_butterfly - Converted<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "eternal_butterfly_- converted"), "main");
	private final ModelPart bone3;

	public eternal_butterfly - Converted(ModelPart root) {
		this.bone3 = root.getChild("bone3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bone3 = partdefinition.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 22).addBox(-2.0F, -8.0F, -5.0F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(2.0F, -10.0F, -8.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-2.0F, -10.0F, -8.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = bone3.addOrReplaceChild("body", CubeListBuilder.create().texOffs(18, 13).addBox(-1.5F, -2.0F, 0.0F, 4.0F, 5.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -5.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

		PartDefinition leftwing_bone = body.addOrReplaceChild("leftwing_bone", CubeListBuilder.create(), PartPose.offsetAndRotation(1.5F, -4.0F, -3.0F, 0.2618F, 0.2618F, 0.0F));

		PartDefinition leg_front = body.addOrReplaceChild("leg_front", CubeListBuilder.create().texOffs(27, 11).addBox(-4.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 3.0F, -2.0F));

		PartDefinition leg_mid = body.addOrReplaceChild("leg_mid", CubeListBuilder.create().texOffs(27, 11).addBox(-4.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 3.0F, 0.0F));

		PartDefinition leg_back = body.addOrReplaceChild("leg_back", CubeListBuilder.create().texOffs(27, 11).addBox(-4.0F, 0.0F, 2.0F, 6.0F, 2.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 3.0F, 2.0F));

		PartDefinition bone = body.addOrReplaceChild("bone", CubeListBuilder.create(), PartPose.offset(-1.5F, -3.0F, 2.0F));

		PartDefinition cube_r1 = bone.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-14.0F, 1.0F, -7.0F, 15.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 11).mirror().addBox(-7.0F, 1.0F, 4.0F, 8.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5672F));

		PartDefinition bone2 = body.addOrReplaceChild("bone2", CubeListBuilder.create(), PartPose.offset(2.5F, -3.0F, 2.0F));

		PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 1.0F, -7.0F, 15.0F, 0.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(0, 11).addBox(-1.0F, 1.0F, 4.0F, 8.0F, 0.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5672F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bone3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}