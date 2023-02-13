package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

public class ShitAmmoGunWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), x, y, z, 5, 1, 1, 1, 1);
	}
}
