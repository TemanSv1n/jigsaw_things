package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class ShitterGunProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -1;
		for (int index0 = 0; index0 < (int) (3); index0++) {
			sy = -1;
			for (int index1 = 0; index1 < (int) (3); index1++) {
				sz = -1;
				for (int index2 = 0; index2 < (int) (3); index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
						world.setBlock(new BlockPos(x + sx, y + sy, z + sz), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
