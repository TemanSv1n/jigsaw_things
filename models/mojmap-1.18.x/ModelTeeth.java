// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelTeeth<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "teeth"), "main");
	private final ModelPart Head;

	public ModelTeeth(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(27, 27)
						.addBox(-4.0F, -5.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 52)
						.addBox(-4.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(35, 37)
						.addBox(-3.0F, -4.0F, -4.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(35, 37)
						.addBox(-1.0F, -4.0F, -4.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(35, 37)
						.addBox(1.0F, -4.0F, -4.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(35, 37)
						.addBox(3.0F, -4.0F, -4.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(35, 37)
						.addBox(2.0F, -2.0F, -4.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(35, 37)
						.addBox(0.0F, -2.0F, -4.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(35, 37)
						.addBox(-2.0F, -2.0F, -4.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(35, 37)
						.addBox(-4.0F, -2.0F, -4.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 52)
						.addBox(-2.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 52)
						.addBox(0.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 52)
						.addBox(2.0F, -4.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 52)
						.addBox(3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 52)
						.addBox(-1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 52)
						.addBox(-3.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(38, 52)
						.addBox(1.0F, -2.0F, -5.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(28, 26)
						.addBox(-4.0F, -1.0F, -5.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}