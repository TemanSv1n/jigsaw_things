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

// Made with Blockbench 4.6.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelradio_hat<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jigsaw", "modelradio_hat"), "main");
	public final ModelPart Head;

	public Modelradio_hat(ModelPart root) {
		this.Head = root.getChild("Head");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Head = partdefinition.addOrReplaceChild("Head",
				CubeListBuilder.create().texOffs(0, 49).addBox(-4.5F, -15.0F, -4.5F, 9.0F, 6.0F, 9.0F, new CubeDeformation(0.0F)).texOffs(57, 49).addBox(-0.5F, -17.0F, -3.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(40, 35)
						.addBox(-5.5F, -16.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(50, 33).addBox(-5.5F, -16.0F, -2.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(45, 37)
						.addBox(-4.5F, -16.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(48, 28).addBox(-4.5F, -16.0F, -2.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(21, 45)
						.addBox(-5.0F, -24.0F, 4.0F, 1.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(19, 40).addBox(-5.5F, -26.0F, 3.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(3, 33)
						.addBox(-1.0F, -16.0F, 1.75F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(18, 46).addBox(-6.0F, -9.0F, -5.5F, 12.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition cube_r1 = Head.addOrReplaceChild("cube_r1",
				CubeListBuilder.create().texOffs(56, 58).addBox(-5.5F, -6.5F, -4.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(46, 6).addBox(-0.75F, -1.25F, -1.25F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(5.0F, -12.5F, 1.0F, -0.7854F, 0.0F, 0.0F));
		PartDefinition cube_r2 = Head.addOrReplaceChild("cube_r2",
				CubeListBuilder.create().texOffs(3, 44).addBox(-1.5F, -3.0F, 0.25F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).texOffs(3, 35).addBox(-1.0F, -2.25F, -1.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -13.0F, -5.5F, 2.0071F, 0.0F, 0.0F));
		PartDefinition cube_r3 = Head.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(2, 34).addBox(-1.0F, -0.75F, -2.5F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -13.0F, -5.5F, 1.3526F, 0.0F, 0.0F));
		PartDefinition cube_r4 = Head.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(3, 35).addBox(-1.0F, -0.75F, -0.25F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -13.0F, -5.5F, 0.48F, 0.0F, 0.0F));
		PartDefinition cube_r5 = Head.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(55, 45).addBox(-0.75F, 0.0F, -1.25F, 2.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.2262F, -17.797F, -2.6674F, 1.3631F, 0.9682F, 1.0361F));
		PartDefinition cube_r6 = Head.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(57, 43).addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -17.5F, -3.0F, 0.695F, 0.5235F, 0.1106F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
