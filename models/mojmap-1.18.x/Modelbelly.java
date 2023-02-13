// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbelly<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "belly"), "main");
	private final ModelPart Body;
	private final ModelPart bone1;
	private final ModelPart bone;

	public Modelbelly(ModelPart root) {
		this.Body = root.getChild("Body");
		this.bone1 = root.getChild("bone1");
		this.bone = root.getChild("bone");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body",
				CubeListBuilder.create().texOffs(16, 6)
						.addBox(-3.0F, 4.0F, -6.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(16, 6)
						.addBox(-3.0F, 3.0F, -5.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(20, 8)
						.addBox(3.0F, 4.0F, -4.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(20, 8)
						.addBox(-4.0F, 4.0F, -4.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition bone1 = partdefinition.addOrReplaceChild("bone1", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		bone.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}