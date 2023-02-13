// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports

public class ModelFoolBee<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "foolbee"), "main");
	private final ModelPart body;
	private final ModelPart left_wing;
	private final ModelPart right_wing;
	private final ModelPart left_antenna;
	private final ModelPart right_antenna;
	private final ModelPart rightArm1;
	private final ModelPart rightArm2;
	private final ModelPart rightArm3;
	private final ModelPart LeftArm1;
	private final ModelPart LeftArm2;
	private final ModelPart LeftArm3;

	public ModelFoolBee(ModelPart root) {
		this.body = root.getChild("body");
		this.left_wing = root.getChild("left_wing");
		this.right_wing = root.getChild("right_wing");
		this.left_antenna = root.getChild("left_antenna");
		this.right_antenna = root.getChild("right_antenna");
		this.rightArm1 = root.getChild("rightArm1");
		this.rightArm2 = root.getChild("rightArm2");
		this.rightArm3 = root.getChild("rightArm3");
		this.LeftArm1 = root.getChild("LeftArm1");
		this.LeftArm2 = root.getChild("LeftArm2");
		this.LeftArm3 = root.getChild("LeftArm3");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(),
				PartPose.offset(0.0F, 17.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso",
				CubeListBuilder.create().texOffs(58, 58)
						.addBox(-3.25F, -4.0F, -5.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(58, 58)
						.addBox(2.25F, -4.0F, -5.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(58, 58)
						.addBox(1.0F, -4.0F, -5.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(58, 58)
						.addBox(-2.0F, -4.0F, -5.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(58, 58)
						.addBox(-0.5F, -4.0F, -5.75F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 2.0F, 0.0F));

		PartDefinition torso_r1 = torso.addOrReplaceChild("torso_r1",
				CubeListBuilder.create().texOffs(3, 56).addBox(-3.5F, -8.5F, -6.5F, 7.0F, 4.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, -0.2182F, 0.0F, 0.0F));

		PartDefinition torso_r2 = torso
				.addOrReplaceChild("torso_r2",
						CubeListBuilder.create().texOffs(5, 54).addBox(-2.5F, -7.5F, 0.5F, 5.0F, 5.0F, 5.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, -0.829F, 0.0F, 0.0F));

		PartDefinition torso_r3 = torso
				.addOrReplaceChild("torso_r3",
						CubeListBuilder.create().texOffs(2, 2).addBox(-3.5F, -7.5F, -4.5F, 7.0F, 7.0F, 8.0F,
								new CubeDeformation(0.0F)),
						PartPose.offsetAndRotation(0.0F, 2.0F, -1.0F, -0.48F, 0.0F, 0.0F));

		PartDefinition mouth = torso.addOrReplaceChild("mouth",
				CubeListBuilder.create().texOffs(3, 58)
						.addBox(-3.5F, -1.25F, -3.0F, 7.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(46, 50)
						.addBox(-3.0F, -1.5F, -2.75F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -1.0F, -4.0F));

		PartDefinition stinger = torso.addOrReplaceChild("stinger", CubeListBuilder.create(),
				PartPose.offset(0.0F, 3.0F, 6.0F));

		PartDefinition torso_r4 = stinger.addOrReplaceChild("torso_r4",
				CubeListBuilder.create().texOffs(52, 38).addBox(-0.5F, -6.5F, 3.5F, 1.0F, 1.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -1.0F, -7.0F, -1.0472F, 0.0F, 0.0F));

		PartDefinition RightDye = body.addOrReplaceChild("RightDye",
				CubeListBuilder.create().texOffs(56, 60)
						.addBox(-1.0F, -1.0F, -1.625F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(51, 59)
						.addBox(-0.5F, -0.5F, -1.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(3.0F, -3.5F, -5.625F));

		PartDefinition LeftDye = body.addOrReplaceChild("LeftDye",
				CubeListBuilder.create().texOffs(56, 60)
						.addBox(-1.0F, -1.0F, -1.625F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(51, 59)
						.addBox(-0.5F, -0.5F, -1.875F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-3.0F, -3.5F, -5.625F));

		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing",
				CubeListBuilder.create().texOffs(0, 18).mirror()
						.addBox(0.0F, 0.0F, -2.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offset(1.5F, 12.0F, -2.0F));

		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing", CubeListBuilder.create()
				.texOffs(0, 18).addBox(-9.0F, 0.0F, -2.0F, 9.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.5F, 12.0F, -2.0F));

		PartDefinition left_antenna = partdefinition.addOrReplaceChild("left_antenna",
				CubeListBuilder.create().texOffs(2, 0).addBox(-0.5F, -0.9626F, -3.1003F, 1.0F, 2.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(2.0F, 13.0F, -5.5F, -0.6981F, 0.0F, 0.0F));

		PartDefinition right_antenna = partdefinition.addOrReplaceChild("right_antenna",
				CubeListBuilder.create().texOffs(2, 3).addBox(-0.5F, -0.8019F, -3.2919F, 1.0F, 2.0F, 3.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-2.0F, 13.0F, -5.25F, -0.6981F, 0.0F, 0.0F));

		PartDefinition rightArm1 = partdefinition.addOrReplaceChild("rightArm1", CubeListBuilder.create(),
				PartPose.offset(3.0F, 16.75F, -2.5F));

		PartDefinition cube_r1 = rightArm1.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(6, 12).addBox(0.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 1.0F, 0.0F, -0.3927F, 0.1776F, 1.0123F));

		PartDefinition cube_r2 = rightArm1.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(6, 12).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 1.0F, 0.0F, -0.3927F, 0.0F, 0.5672F));

		PartDefinition rightArm2 = partdefinition.addOrReplaceChild("rightArm2", CubeListBuilder.create(),
				PartPose.offset(3.0F, 18.5F, 0.0F));

		PartDefinition cube_r3 = rightArm2.addOrReplaceChild("cube_r3",
				CubeListBuilder.create().texOffs(6, 12).addBox(0.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.25F, 0.0F, -0.3927F, 0.1776F, 1.0123F));

		PartDefinition cube_r4 = rightArm2.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(6, 12).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.25F, 0.0F, -0.3927F, 0.0F, 0.5672F));

		PartDefinition rightArm3 = partdefinition.addOrReplaceChild("rightArm3", CubeListBuilder.create(),
				PartPose.offset(3.0F, 19.75F, 1.25F));

		PartDefinition cube_r5 = rightArm3.addOrReplaceChild("cube_r5",
				CubeListBuilder.create().texOffs(6, 12).addBox(0.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.0F, 1.0F, -0.3927F, 0.1776F, 1.0123F));

		PartDefinition cube_r6 = rightArm3.addOrReplaceChild("cube_r6",
				CubeListBuilder.create().texOffs(6, 12).addBox(-2.0F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.5F, 0.0F, 1.0F, -0.3927F, 0.0F, 0.5672F));

		PartDefinition LeftArm1 = partdefinition.addOrReplaceChild("LeftArm1", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.9845F, 17.3413F, -2.3418F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r7 = LeftArm1.addOrReplaceChild("cube_r7",
				CubeListBuilder.create().texOffs(6, 12).addBox(-1.8111F, -1.9101F, 1.4572F, 3.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4845F, 3.4087F, -0.9082F, 0.3927F, -0.1889F, 1.0123F));

		PartDefinition cube_r8 = LeftArm1.addOrReplaceChild("cube_r8",
				CubeListBuilder.create().texOffs(6, 12).addBox(-3.6119F, -2.9549F, 0.8921F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4845F, 3.4087F, -0.9082F, 0.3927F, 0.0F, 0.5672F));

		PartDefinition LeftArm2 = partdefinition.addOrReplaceChild("LeftArm2", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.9845F, 18.3413F, 0.1582F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r9 = LeftArm2.addOrReplaceChild("cube_r9",
				CubeListBuilder.create().texOffs(6, 12).addBox(-1.8111F, -1.9101F, 1.4572F, 3.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4845F, 3.4087F, -0.9082F, 0.3927F, -0.1889F, 1.0123F));

		PartDefinition cube_r10 = LeftArm2.addOrReplaceChild("cube_r10",
				CubeListBuilder.create().texOffs(6, 12).addBox(-3.6119F, -2.9549F, 0.8921F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4845F, 3.4087F, -0.9082F, 0.3927F, 0.0F, 0.5672F));

		PartDefinition LeftArm3 = partdefinition.addOrReplaceChild("LeftArm3", CubeListBuilder.create(),
				PartPose.offsetAndRotation(-2.9845F, 19.3413F, 2.4082F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r11 = LeftArm3.addOrReplaceChild("cube_r11",
				CubeListBuilder.create().texOffs(6, 12).addBox(-1.8111F, -1.9101F, 1.4572F, 3.0F, 1.0F, 1.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4845F, 3.4087F, -0.9082F, 0.3927F, -0.1889F, 1.0123F));

		PartDefinition cube_r12 = LeftArm3.addOrReplaceChild("cube_r12",
				CubeListBuilder.create().texOffs(6, 12).addBox(-3.6119F, -2.9549F, 0.8921F, 3.0F, 2.0F, 2.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.4845F, 3.4087F, -0.9082F, 0.3927F, 0.0F, 0.5672F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_antenna.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_antenna.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rightArm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LeftArm3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
		this.LeftArm3.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.rightArm1.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.rightArm2.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftArm1.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.rightArm3.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.LeftArm2.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_wing.zRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
		this.right_antenna.xRot = headPitch / (180F / (float) Math.PI);
		this.left_wing.yRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.body.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.body.xRot = headPitch / (180F / (float) Math.PI);
		this.left_antenna.xRot = headPitch / (180F / (float) Math.PI);
	}
}