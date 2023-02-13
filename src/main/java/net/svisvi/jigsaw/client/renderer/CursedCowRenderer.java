
package net.svisvi.jigsaw.client.renderer;

import net.svisvi.jigsaw.procedures.CursedcowEntityShakingConditionProcedure;
import net.svisvi.jigsaw.entity.CursedCowEntity;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.CowModel;

public class CursedCowRenderer extends MobRenderer<CursedCowEntity, CowModel<CursedCowEntity>> {
	public CursedCowRenderer(EntityRendererProvider.Context context) {
		super(context, new CowModel(context.bakeLayer(ModelLayers.COW)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CursedCowEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/cursed_cow.png");
	}

	@Override
	protected boolean isShaking(CursedCowEntity _ent) {
		Entity entity = _ent;
		Level world = entity.level;
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		return CursedcowEntityShakingConditionProcedure.execute(world, x, y, z);
	}
}
