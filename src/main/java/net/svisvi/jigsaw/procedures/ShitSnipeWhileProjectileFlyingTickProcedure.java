package net.svisvi.jigsaw.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class ShitSnipeWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double bullet_damage = 0;
		bullet_damage = Math.ceil(Math.sqrt(Math.pow(entity.getX() - immediatesourceentity.getX(), 2) + Math.pow(entity.getY() - immediatesourceentity.getY(), 2) + Math.pow(entity.getZ() - immediatesourceentity.getZ(), 2)) / 1.7);
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.FLAME, x, y, z, (int) Math.ceil(bullet_damage / 1.5), 0.4, 0.4, 0.4, 0);
	}
}
