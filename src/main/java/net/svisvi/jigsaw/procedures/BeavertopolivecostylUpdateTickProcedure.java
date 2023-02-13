package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModEntities;
import net.svisvi.jigsaw.entity.LivingBeaverBodyEntity;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class BeavertopolivecostylUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new LivingBeaverBodyEntity(JigsawModEntities.LIVING_BEAVER_BODY.get(), _level);
			entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		world.setBlock(new BlockPos(x, y, z), Blocks.CAVE_AIR.defaultBlockState(), 3);
	}
}
