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

// Made with Blockbench 4.6.0
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports
public class Modelpoop_smoke_grenade_entity<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jigsaw", "modelpoop_smoke_grenade_entity"), "main");
	public final ModelPart group;

	public Modelpoop_smoke_grenade_entity(ModelPart root) {
		this.group = root.getChild("group");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition group = partdefinition.addOrReplaceChild("group",
				CubeListBuilder.create().texOffs(21, 2).mirror().addBox(-1.0F, -3.6938F, -0.9562F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false).texOffs(4, 17)
						.addBox(-1.0F, -6.6938F, -0.9562F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0).addBox(0.25F, 1.0562F, -1.2062F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(0, 0)
						.addBox(0.25F, -1.1938F, -1.2062F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 0).addBox(-1.25F, -1.1938F, 0.2938F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 0)
						.addBox(-1.25F, 1.0562F, 0.2938F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 0).addBox(-1.25F, -1.1938F, -2.4562F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(8, 0)
						.addBox(-1.25F, 1.0562F, -2.4562F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(3, 0).addBox(-2.5F, -1.1938F, -1.2062F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(3, 0)
						.addBox(-2.5F, 1.0562F, -1.2062F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, 17.6938F, -0.0438F));
		PartDefinition cube_r1 = group.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(3, 0).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.25F, 4.3062F, 0.0438F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r2 = group.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(8, 0).addBox(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.3062F, -1.2062F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r3 = group.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(8, 0).addBox(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 4.3062F, 1.2938F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r4 = group.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(8, 0).addBox(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.4438F, 1.2938F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r5 = group.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(8, 0).addBox(-1.25F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -2.4438F, -1.2062F, -0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r6 = group.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(3, 0).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(-1.25F, -2.4438F, 0.0438F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r7 = group.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.25F, -2.4438F, 0.0438F, 0.0F, 0.0F, -0.3927F));
		PartDefinition cube_r8 = group.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(1.25F, 4.3062F, 0.0438F, 0.0F, 0.0F, 0.3927F));
		PartDefinition cube_r9 = group.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(5, 17).addBox(-1.0F, -1.25F, -1.25F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -5.4438F, 1.0438F, 0.3927F, 0.0F, 0.0F));
		PartDefinition cube_r10 = group.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(3, 18).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, -6.1938F, -1.9562F, 0.3927F, 0.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.group.yRot = netHeadYaw / (180F / (float) Math.PI);
		this.group.xRot = headPitch / (180F / (float) Math.PI);
	}
}
