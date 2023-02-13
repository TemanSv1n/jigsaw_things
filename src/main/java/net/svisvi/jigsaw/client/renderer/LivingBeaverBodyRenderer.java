
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.LivingBeaverBodyEntity;
import net.svisvi.jigsaw.client.model.ModelBeaver_body;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class LivingBeaverBodyRenderer extends MobRenderer<LivingBeaverBodyEntity, ModelBeaver_body<LivingBeaverBodyEntity>> {
	public LivingBeaverBodyRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBeaver_body(context.bakeLayer(ModelBeaver_body.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LivingBeaverBodyEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/beaver_exe.png");
	}
}
