package net.svisvi.jigsaw.procedures;

import net.minecraft.world.entity.Entity;

public class EmptyRocketEntityShakingConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getPersistentData().getBoolean("fused") == true) {
			return true;
		}
		return false;
	}
}
