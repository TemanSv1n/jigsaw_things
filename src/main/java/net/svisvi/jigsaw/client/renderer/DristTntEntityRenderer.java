
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.DristTntEntityEntity;
import net.svisvi.jigsaw.client.model.Modeldrist_tnt;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DristTntEntityRenderer extends MobRenderer<DristTntEntityEntity, Modeldrist_tnt<DristTntEntityEntity>> {
	public DristTntEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldrist_tnt(context.bakeLayer(Modeldrist_tnt.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DristTntEntityEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/texturetnt.png");
	}
}
