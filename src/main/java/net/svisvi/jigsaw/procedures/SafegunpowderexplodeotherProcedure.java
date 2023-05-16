package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class SafegunpowderexplodeotherProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -3;
		found = false;
		for (int index0 = 0; index0 < (int) (6); index0++) {
			sy = -3;
			for (int index1 = 0; index1 < (int) (6); index1++) {
				sz = -3;
				for (int index2 = 0; index2 < (int) (6); index2++) {
					if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == JigsawModBlocks.SAFEGUNPOWDERBARREL.get()) {
						SafegunpowderbarrelOnBlockRightClickedProcedure.execute(world, (x + sx), (y + sy), (z + sz));
					} else if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == JigsawModBlocks.GUNPOWDERBARREL.get()) {
						GunpowderbarrelOnBlockRightClickedProcedure.execute(world, (x + sx), (y + sy), (z + sz));
					} else if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == JigsawModBlocks.BEAVERGUNPOWDERBARREL.get()) {
						BeavergunpowderbarrelrightclickProcedure.execute(world, (x + sx), (y + sy), (z + sz));
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
