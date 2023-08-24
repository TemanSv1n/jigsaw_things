package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModMobEffects;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class LivingBeaverOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity Centurion = null;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(JigsawModMobEffects.PURGATIVE.get()) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 60, 200, (true), (false)));
		}
		if ((entity.getPersistentData().getString("legio_task")).equals("follow")) {
			Centurion = LegioFindCenturionProcedure.execute(world, x, y, z, entity);
			if (!(Centurion == null)) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((Centurion.getX()), (Centurion.getY()), (Centurion.getZ()), 2);
			}
		}
	}
}
