
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.JetstreamchairEntity;
import net.svisvi.jigsaw.client.model.Modeljetstream_chair;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class JetstreamchairRenderer extends MobRenderer<JetstreamchairEntity, Modeljetstream_chair<JetstreamchairEntity>> {
	public JetstreamchairRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeljetstream_chair(context.bakeLayer(Modeljetstream_chair.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(JetstreamchairEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/texturejsc.png");
	}
}
