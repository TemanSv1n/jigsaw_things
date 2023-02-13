package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModMobEffects;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class PoopOverlayConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(JigsawModMobEffects.POOP.get()) ? _livEnt.getEffect(JigsawModMobEffects.POOP.get()).getDuration() : 0) > 20) {
			return true;
		}
		return false;
	}
}
