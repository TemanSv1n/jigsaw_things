
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.DristerTntEntity;
import net.svisvi.jigsaw.client.model.Modeldrist_tnt;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class DristerTntRenderer extends MobRenderer<DristerTntEntity, Modeldrist_tnt<DristerTntEntity>> {
	public DristerTntRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldrist_tnt(context.bakeLayer(Modeldrist_tnt.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(DristerTntEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/texturetnt.png");
	}
}
