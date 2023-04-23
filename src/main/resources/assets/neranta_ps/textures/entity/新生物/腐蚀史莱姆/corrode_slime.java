// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class custom_model<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart inner;
	private final ModelPart outer;

	public custom_model(ModelPart root) {
		this.inner = root.getChild("inner");
		this.outer = root.getChild("outer");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition inner = partdefinition.addOrReplaceChild("inner", CubeListBuilder.create().texOffs(0, 16).addBox(-3.125F, -2.875F, -1.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(-3.425F, -1.875F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 4).addBox(1.175F, -1.875F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 8).addBox(-0.125F, 1.125F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.125F, 19.875F, -2.0F));

		PartDefinition outer = partdefinition.addOrReplaceChild("outer", CubeListBuilder.create().texOffs(0, 0).addBox(-4.125F, -3.875F, -2.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(32, 0).addBox(-3.425F, -1.875F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 4).addBox(1.175F, -1.875F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(32, 8).addBox(-0.125F, 1.125F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.125F, 19.875F, -2.0F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		inner.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		outer.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}