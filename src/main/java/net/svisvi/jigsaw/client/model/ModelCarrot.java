package net.svisvi.jigsaw.client.model;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.EntityModel;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

// Made with Blockbench 4.3.1
// Exported for Minecraft version 1.17 - 1.18 with Mojang mappings
// Paste this class into your mod and generate all required imports
public class ModelCarrot<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jigsaw", "model_carrot"), "main");
	public final ModelPart body;
	public final ModelPart head;
	public final ModelPart right_arm;
	public final ModelPart left_arm;
	public final ModelPart right_leg;
	public final ModelPart left_leg;

	public ModelCarrot(ModelPart root) {
		this.body = root.getChild("body");
		this.head = root.getChild("head");
		this.right_arm = root.getChild("right_arm");
		this.left_arm = root.getChild("left_arm");
		this.right_leg = root.getChild("right_leg");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition body = partdefinition.addOrReplaceChild(
				"body", CubeListBuilder.create().texOffs(46, 43).addBox(-7.05F, -14.0951F, -1.9543F, 14.0F, 5.0F, 12.0F, new CubeDeformation(0.0F)).texOffs(0, 55).mirror()
						.addBox(2.95F, -13.0951F, -4.9543F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 55).addBox(-5.05F, -13.0951F, -4.9543F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.05F, -13.9049F, -6.0457F));
		PartDefinition cube_r1 = body.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(0, 60).addBox(-4.25F, -35.0F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 60).mirror().addBox(0.5F, -35.0F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(0, 60).mirror().addBox(0.5F, -30.5F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(0, 60).addBox(-4.25F, -30.5F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 60)
						.addBox(-4.25F, -26.0F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 60).mirror().addBox(0.5F, -26.0F, -1.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(30, 55)
						.addBox(-10.0F, -46.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(30, 55).addBox(5.0F, -46.0F, -2.0F, 5.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(-15.0F, -49.0F, 0.0F, 30.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)).texOffs(0, 23).addBox(-8.0F, -39.0F, 0.0F, 16.0F, 19.0F, 13.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.05F, 37.9049F, 6.0457F, 0.1745F, 0.0F, 0.0F));
		PartDefinition cube_r2 = body.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 76).addBox(27.0F, -41.0F, -11.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.05F, 37.9049F, 6.0457F, 0.0F, 0.0F, -0.5236F));
		PartDefinition cube_r3 = body.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(28, 76).addBox(-29.0F, -41.0F, -11.0F, 2.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-0.05F, 37.9049F, 6.0457F, 0.0F, 0.0F, 0.5236F));
		PartDefinition pack = body.addOrReplaceChild("pack", CubeListBuilder.create(), PartPose.offset(-0.05F, 37.9049F, 6.0457F));
		PartDefinition cube_r4 = pack.addOrReplaceChild("cube_r4",
				CubeListBuilder.create().texOffs(0, 0).addBox(7.0F, -37.0F, 13.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 0).mirror().addBox(-9.0F, -37.0F, 13.0F, 2.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
						.texOffs(28, 88).addBox(-7.0F, -45.0F, 13.0F, 6.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(78, 23).addBox(-9.0F, -36.0F, 17.0F, 18.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(88, 75).mirror()
						.addBox(-6.0F, -47.0F, 13.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(88, 75).addBox(2.0F, -47.0F, 13.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(28, 88).mirror()
						.addBox(1.0F, -45.0F, 13.0F, 6.0F, 19.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.0F));
		PartDefinition head = partdefinition.addOrReplaceChild("head",
				CubeListBuilder.create().texOffs(50, 106).addBox(-4.8889F, -10.7222F, -5.5556F, 10.0F, 11.0F, 10.0F, new CubeDeformation(0.0F)).texOffs(0, 122).addBox(-1.8889F, -11.7222F, -3.5556F, 4.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
						.texOffs(0, 122).addBox(1.1111F, -12.7222F, -3.5556F, 5.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(0, 122).addBox(-5.8889F, -12.7222F, -0.5556F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 122)
						.addBox(-1.8889F, -12.7222F, -4.5556F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 122).addBox(-0.8889F, -12.7222F, 0.4444F, 2.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 122)
						.addBox(-0.8889F, -11.7222F, 3.4444F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 122).addBox(-6.8889F, -11.7222F, -1.5556F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(0, 122)
						.addBox(5.1111F, -11.7222F, -4.5556F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-0.1111F, -27.2778F, -1.4444F));
		PartDefinition right_arm = partdefinition.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 60).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(11.0F, -16.0F, -1.0F));
		PartDefinition left_arm = partdefinition.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 60).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 22.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-11.0F, -16.0F, -1.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(86, 0).addBox(-3.0F, 0.452F, -4.3557F, 6.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 96)
				.addBox(-3.0F, 17.452F, 3.6443F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(88, 60).addBox(-3.0F, 20.452F, -3.3557F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, 1.548F, 3.3557F));
		PartDefinition cube_r5 = right_leg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(86, 0).addBox(6.0F, -9.25F, 4.5F, 6.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-9.0F, 22.452F, -3.3557F, 0.5672F, 0.0F, 0.0F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(86, 0).addBox(-3.0F, 0.452F, -6.3557F, 6.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)).texOffs(0, 96)
				.addBox(-3.0F, 17.452F, 1.6443F, 6.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).texOffs(88, 60).addBox(-3.0F, 20.452F, -5.3557F, 6.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 1.548F, 5.3557F));
		PartDefinition cube_r6 = left_leg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(86, 0).addBox(-2.0F, -9.25F, 4.5F, 6.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.0F, 22.452F, -5.3557F, 0.5672F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_arm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.right_arm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * limbSwingAmount;
		this.left_leg.xRot = Mth.cos(limbSwing * 1.0F) * -1.0F * limbSwingAmount;
		this.left_arm.xRot = Mth.cos(limbSwing * 0.6662F) * limbSwingAmount;
		this.right_leg.xRot = Mth.cos(limbSwing * 1.0F) * 1.0F * limbSwingAmount;
	}
}
