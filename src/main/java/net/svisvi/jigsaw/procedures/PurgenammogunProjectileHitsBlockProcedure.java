package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

public class PurgenammogunProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(new BlockPos(x, y, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
			world.setBlock(new BlockPos(x, y, z), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y + 1, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
			world.setBlock(new BlockPos(x, y + 1, z), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x + 1, y, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
			world.setBlock(new BlockPos(x + 1, y, z), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x - 1, y, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
			world.setBlock(new BlockPos(x - 1, y, z), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
			world.setBlock(new BlockPos(x, y, z - 1), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
		}
		if ((world.getBlockState(new BlockPos(x, y, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
			world.setBlock(new BlockPos(x, y, z + 1), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
		}
	}
}
