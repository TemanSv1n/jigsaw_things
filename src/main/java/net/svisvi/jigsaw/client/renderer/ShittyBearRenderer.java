
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.ShittyBearEntity;
import net.svisvi.jigsaw.client.model.Modelfool_bear;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class ShittyBearRenderer extends MobRenderer<ShittyBearEntity, Modelfool_bear<ShittyBearEntity>> {
	public ShittyBearRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelfool_bear(context.bakeLayer(Modelfool_bear.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(ShittyBearEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/bear.png");
	}
}
