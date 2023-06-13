
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.procedures.EmptyRocketEntityShakingConditionProcedure;
import net.svisvi.jigsaw.entity.PoopsRocketEntity;
import net.svisvi.jigsaw.client.model.Modelrocket_2;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

public class PoopsRocketRenderer extends MobRenderer<PoopsRocketEntity, Modelrocket_2<PoopsRocketEntity>> {
	public PoopsRocketRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelrocket_2(context.bakeLayer(Modelrocket_2.LAYER_LOCATION)), 1f);
	}

	@Override
	public ResourceLocation getTextureLocation(PoopsRocketEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/rocket_closed.png");
	}

	@Override
	protected boolean isShaking(PoopsRocketEntity _ent) {
		Entity entity = _ent;
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return EmptyRocketEntityShakingConditionProcedure.execute(entity);
	}
}
