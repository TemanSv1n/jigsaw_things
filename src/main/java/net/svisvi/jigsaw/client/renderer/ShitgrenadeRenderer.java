package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.ShitgrenadeEntity;
import net.svisvi.jigsaw.client.model.Modelpoop_smoke_grenade_entity;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.math.Vector3f;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class ShitgrenadeRenderer extends EntityRenderer<ShitgrenadeEntity> {
	private static final ResourceLocation texture = new ResourceLocation("jigsaw:textures/entities/stiched_texture_gr.png");
	private final Modelpoop_smoke_grenade_entity model;

	public ShitgrenadeRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelpoop_smoke_grenade_entity(context.bakeLayer(Modelpoop_smoke_grenade_entity.LAYER_LOCATION));
	}

	@Override
	public void render(ShitgrenadeEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.mulPose(Vector3f.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Vector3f.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(ShitgrenadeEntity entity) {
		return texture;
	}
}
