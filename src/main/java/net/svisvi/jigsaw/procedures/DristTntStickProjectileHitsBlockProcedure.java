package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;
import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class DristTntStickProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, (y + 1), z, 2, Explosion.BlockInteraction.NONE);
		SafegunpowderexplodeotherProcedure.execute(world, x, (y + 1), z);
		sx = -2;
		found = false;
		for (int index0 = 0; index0 < (int) (4); index0++) {
			sy = -2;
			for (int index1 = 0; index1 < (int) (4); index1++) {
				sz = -2;
				for (int index2 = 0; index2 < (int) (4); index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + 1 + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
						if (Mth.nextInt(new Random(), 0, 100) >= 93) {
							world.setBlock(new BlockPos(x + sx, y + 1 + sy, z + sz), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), (x + sx), (y + 1 + sy), (z + sz), 15, 1, 1, 1, 0);
						}
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
