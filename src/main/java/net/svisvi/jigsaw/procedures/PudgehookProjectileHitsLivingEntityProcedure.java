package net.svisvi.jigsaw.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class PudgehookProjectileHitsLivingEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double speed = 0;
		double Yaw = 0;
		double dx = 0;
		double dy = 0;
		double dz = 0;
		double dyaw = 0;
		double dpitch = 0;
		double dist_k = 0;
		dx = entity.getX() - sourceentity.getX();
		dy = entity.getY() - sourceentity.getY();
		dz = entity.getZ() - sourceentity.getZ();
		dyaw = Math.atan2(dz, dx);
		dpitch = Math.atan2(Math.sqrt(dz * dz + dx * dx), dy) + Math.PI;
		dist_k = Math.sqrt(dz * dz + dx * dx + dy * dy);
		speed = 0.3;
		entity.setDeltaMovement(new Vec3((Math.sin(dpitch) * Math.cos(dyaw) * speed * dist_k), (Math.cos(dpitch) * speed), (Math.sin(dpitch) * Math.sin(dyaw) * speed * dist_k)));
	}
}
