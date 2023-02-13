
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.SniperBeaverEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class SniperBeaverRenderer extends HumanoidMobRenderer<SniperBeaverEntity, HumanoidModel<SniperBeaverEntity>> {
	public SniperBeaverRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
	}

	@Override
	public ResourceLocation getTextureLocation(SniperBeaverEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/d41fb99355c78d33_3.png");
	}
}
