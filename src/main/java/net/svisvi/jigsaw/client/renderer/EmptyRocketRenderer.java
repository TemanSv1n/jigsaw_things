
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.EmptyRocketEntity;
import net.svisvi.jigsaw.client.model.Modelrocket;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class EmptyRocketRenderer extends MobRenderer<EmptyRocketEntity, Modelrocket<EmptyRocketEntity>> {
	public EmptyRocketRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelrocket(context.bakeLayer(Modelrocket.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(EmptyRocketEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/rocket_open.png");
	}
}
