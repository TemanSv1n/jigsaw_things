
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.entity.LivingBeaverlegsEntity;
import net.svisvi.jigsaw.client.model.ModelBeaver_legs;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class LivingBeaverlegsRenderer extends MobRenderer<LivingBeaverlegsEntity, ModelBeaver_legs<LivingBeaverlegsEntity>> {
	public LivingBeaverlegsRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBeaver_legs(context.bakeLayer(ModelBeaver_legs.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(LivingBeaverlegsEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/beaver_exe.png");
	}
}
