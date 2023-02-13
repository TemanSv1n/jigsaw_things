package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModMobEffects;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class UnlevitationOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double speed = 0;
		double Yaw = 0;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JigsawModMobEffects.UNLEVITATION.get()) ? _livEnt.getEffect(JigsawModMobEffects.UNLEVITATION.get()).getAmplifier() : 0) == 0) {
			entity.setDeltaMovement(new Vec3(0, (-0.2), 0));
		} else {
			entity.setDeltaMovement(new Vec3(0, ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JigsawModMobEffects.UNLEVITATION.get()) ? _livEnt.getEffect(JigsawModMobEffects.UNLEVITATION.get()).getAmplifier() : 0) * (-0.2)), 0));
		}
	}
}
