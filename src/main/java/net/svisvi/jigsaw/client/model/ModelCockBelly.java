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
public class ModelCockBelly<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("jigsaw", "model_cock_belly"), "main");
	public final ModelPart Body;
	public final ModelPart ArmsL;
	public final ModelPart ArmsR;

	public ModelCockBelly(ModelPart root) {
		this.Body = root.getChild("Body");
		this.ArmsL = root.getChild("ArmsL");
		this.ArmsR = root.getChild("ArmsR");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(1, 17).addBox(-4.25F, 10.0F, -6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(0, 9)
				.addBox(-2.0F, 8.75F, -18.0F, 4.0F, 4.0F, 16.0F, new CubeDeformation(0.0F)).texOffs(0, 16).addBox(0.25F, 10.0F, -6.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 2.0F, 0.0F));
		PartDefinition Body2 = Body.addOrReplaceChild("Body2",
				CubeListBuilder.create().texOffs(43, 51).addBox(-3.0F, 4.0F, -6.0F, 6.0F, 8.0F, 4.0F, new CubeDeformation(0.0F)).texOffs(43, 51).addBox(-3.0F, 3.0F, -5.0F, 6.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).texOffs(47, 53)
						.addBox(3.0F, 4.0F, -4.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)).texOffs(47, 53).addBox(-4.0F, 4.0F, -4.0F, 1.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(0.0F, -2.0F, 0.0F));
		PartDefinition ArmsL = partdefinition.addOrReplaceChild("ArmsL", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		PartDefinition ArmsR = partdefinition.addOrReplaceChild("ArmsR", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ArmsL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		ArmsR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
}
