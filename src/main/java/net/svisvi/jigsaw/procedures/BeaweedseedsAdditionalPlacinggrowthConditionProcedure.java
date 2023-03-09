package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class BeaweedseedsAdditionalPlacinggrowthConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:dirt"))) || (world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == JigsawModBlocks.BEAWEEDDUSTBLOCK.get()) {
			return true;
		}
		return false;
	}
}
