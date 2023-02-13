package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class WheatplacerBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y, z), JigsawModBlocks.INVISIBILITY_WHEAT_BOTTOM.get().defaultBlockState(), 3);
		world.setBlock(new BlockPos(x, y + 1, z), JigsawModBlocks.INVISIBILITY_WHEAT.get().defaultBlockState(), 3);
	}
}
