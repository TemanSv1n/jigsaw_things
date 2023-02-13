package net.svisvi.jigsaw.client.model;

import net.minecraft.world.entity.Entity;
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
public class Modelsubpants<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jigsaw", "modelsubpants"), "main");
	public final ModelPart waist;
	public final ModelPart left_leg;
	public final ModelPart right_leg;

	public Modelsubpants(ModelPart root) {
		this.waist = root.getChild("waist");
		this.left_leg = root.getChild("left_leg");
		this.right_leg = root.getChild("right_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition waist = partdefinition.addOrReplaceChild("waist",
				CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(37, 3).addBox(-4.0F, 1.0F, 3.0F, 8.0F, 8.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(0, -2)
						.addBox(-4.5F, 8.25F, -2.0F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.5F)).texOffs(0, -2).addBox(4.5F, 8.25F, -2.0F, 0.0F, 1.0F, 9.0F, new CubeDeformation(0.5F)).texOffs(0, 0)
						.addBox(-3.75F, 1.0F, 7.25F, 0.0F, 8.0F, 0.0F, new CubeDeformation(0.5F)).texOffs(0, 0).addBox(-3.75F, 0.5F, 3.25F, 0.0F, 0.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(0, 0)
						.addBox(3.75F, 0.5F, 3.25F, 0.0F, 0.0F, 4.0F, new CubeDeformation(0.5F)).texOffs(0, 0).addBox(3.75F, 1.0F, 7.25F, 0.0F, 8.0F, 0.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, 0.0F, 0.0F));
		PartDefinition hexadecagon = waist.addOrReplaceChild("hexadecagon",
				CubeListBuilder.create().texOffs(0, 0).addBox(-8.3978F, -10.0F, 7.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-10.0F, -8.3978F, 7.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offset(8.0F, 13.0F, -0.75F));
		PartDefinition hexadecagon_r1 = hexadecagon.addOrReplaceChild("hexadecagon_r1",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.3978F, -0.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-0.3978F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.0F, 0.3927F));
		PartDefinition hexadecagon_r2 = hexadecagon.addOrReplaceChild("hexadecagon_r2",
				CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -0.3978F, -0.5F, 4.0F, 0.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(-0.3978F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.0F, -0.3927F));
		PartDefinition hexadecagon_r3 = hexadecagon.addOrReplaceChild("hexadecagon_r3", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3978F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.0F, 0.7854F));
		PartDefinition hexadecagon_r4 = hexadecagon.addOrReplaceChild("hexadecagon_r4", CubeListBuilder.create().texOffs(0, 0).addBox(-0.3978F, -2.0F, -0.5F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-8.0F, -8.0F, 8.0F, 0.0F, 0.0F, -0.7854F));
		PartDefinition left_leg = partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 16).mirror().addBox(2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)).mirror(false),
				PartPose.offset(-2.0F, 12.0F, 0.0F));
		PartDefinition cube_r1 = left_leg.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(49, 3).addBox(-0.5F, 3.5F, 1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(48, 2).mirror().addBox(-1.0F, 0.0F, 1.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));
		PartDefinition right_leg = partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 16).addBox(-6.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.5F)), PartPose.offset(2.0F, 12.0F, 0.0F));
		PartDefinition cube_r2 = right_leg.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(49, 3).addBox(1.5F, 3.5F, 4.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(48, 2).addBox(1.0F, 0.0F, 4.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		waist.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
