package net.svisvi.jigsaw.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class BackJumpEffectExpiresProcedure {
	public static void execute(Entity entity, double amplifier) {
		if (entity == null)
			return;
		double speed = 0;
		double Yaw = 0;
		speed = amplifier / 10;
		Yaw = entity.getYRot();
		entity.setDeltaMovement(new Vec3((speed * Math.cos((Yaw - 90) * (Math.PI / 180))), (speed * Math.cos(entity.getXRot() * (Math.PI / 180))), (speed * Math.sin((Yaw - 90) * (Math.PI / 180)))));
	}
}
