package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class InvisibilityRogozBottomValidPlacementProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getBlock() == JigsawModBlocks.INVISIBILITY_ROGOZ.get() && world.getBlockState(new BlockPos(x, y - 1, z)).canOcclude()) {
			return true;
		}
		return false;
	}
}
