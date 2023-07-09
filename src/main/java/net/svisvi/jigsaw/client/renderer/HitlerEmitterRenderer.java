
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.HitlerEmitterEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

public class HitlerEmitterRenderer extends MobRenderer<HitlerEmitterEntity, CowModel<HitlerEmitterEntity>> {
	public HitlerEmitterRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(HitlerEmitterEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/skin-8uoo.png");
	}
}
