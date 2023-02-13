package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class PurgativeOnEffectActiveTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level.dimension()) == (Level.OVERWORLD)) {
			if ((world.getBlockState(new BlockPos(entity.getX(), entity.getY(), entity.getZ()))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
				world.setBlock(new BlockPos(x, y, z), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
			}
		} else {
			entity.setSecondsOnFire(1);
		}
	}
}
