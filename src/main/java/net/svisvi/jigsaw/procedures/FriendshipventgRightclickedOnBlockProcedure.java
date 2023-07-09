package net.svisvi.jigsaw.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

public class FriendshipventgRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double nx1 = 0;
		double ny1 = 0;
		double nz1 = 0;
		double nx2 = 0;
		double ny2 = 0;
		double nz2 = 0;
		double anglee = 0;
		if (world instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.ASH, x, y, z, 1, 0, 0, 0, 0);
		entity.getPersistentData().putDouble("counter1", (entity.getPersistentData().getDouble("counter1") + 1));
		if (entity.getPersistentData().getDouble("counter1") % 10 == 0) {
			anglee = entity.getPersistentData().getDouble("counter1") * 1;
			nx1 = RotateAroundPointProcedure.execute(anglee, x, z, x + 3, z);
			nx2 = RotateAroundPointProcedure.execute(anglee, x, z, x - 3, z);
			nz1 = RotateAroundPointZProcedure.execute(anglee, x, z, x + 3, z);
			nz2 = RotateAroundPointZProcedure.execute(anglee, x, z, x - 3, z);
			ny1 = y + 0.7;
			ny2 = ny1;
			DrawLineProcedure.execute(world, nx1, nx2, ny1, ny2, nz1, nz2);
			nx1 = RotateAroundPointProcedure.execute(anglee, x, z, x, z + 3);
			nx2 = RotateAroundPointProcedure.execute(anglee, x, z, x, z - 3);
			nz1 = RotateAroundPointZProcedure.execute(anglee, x, z, x, z + 3);
			nz2 = RotateAroundPointZProcedure.execute(anglee, x, z, x, z - 3);
			DrawLineProcedure.execute(world, nx1, nx2, ny1, ny2, nz1, nz2);
		}
		if (entity.getPersistentData().getDouble("counter1") % 230 == 0) {
			if (!entity.level.isClientSide())
				entity.discard();
		}
	}
}
