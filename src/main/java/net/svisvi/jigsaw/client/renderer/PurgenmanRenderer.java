
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.PurgenmanEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

public class PurgenmanRenderer extends HumanoidMobRenderer<PurgenmanEntity, HumanoidModel<PurgenmanEntity>> {
	public PurgenmanRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR))));
		this.addLayer(new EyesLayer<PurgenmanEntity, HumanoidModel<PurgenmanEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("jigsaw:textures/entities/skin-8uoo.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(PurgenmanEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/skin-nbec.png");
	}
}
