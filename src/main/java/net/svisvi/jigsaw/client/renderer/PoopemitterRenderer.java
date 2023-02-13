
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.PoopemitterEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

public class PoopemitterRenderer extends MobRenderer<PoopemitterEntity, CowModel<PoopemitterEntity>> {
	public PoopemitterRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0f);
	}

	@Override
	public ResourceLocation getTextureLocation(PoopemitterEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/skin-8uoo.png");
	}
}
