
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.ShittybeeEntity;
import net.svisvi.jigsaw.client.model.ModelFoolBee;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ShittybeeRenderer extends MobRenderer<ShittybeeEntity, ModelFoolBee<ShittybeeEntity>> {
	public ShittybeeRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFoolBee(context.bakeLayer(ModelFoolBee.LAYER_LOCATION)), 0.30000000000000004f);
	}

	@Override
	public ResourceLocation getTextureLocation(ShittybeeEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/bee.png");
	}
}
