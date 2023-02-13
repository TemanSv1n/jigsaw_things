package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModEntities;
import net.svisvi.jigsaw.entity.JetstreamchairEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import java.util.Random;

public class JetstreamchairitemItemIsDroppedByPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = new JetstreamchairEntity(JigsawModEntities.JETSTREAMCHAIR.get(), _level);
			entityToSpawn.moveTo(x, y, z, Mth.nextInt(new Random(), 1, 360), 0);
			entityToSpawn.setYBodyRot(Mth.nextInt(new Random(), 1, 360));
			entityToSpawn.setYHeadRot(Mth.nextInt(new Random(), 1, 360));
			if (entityToSpawn instanceof Mob _mobToSpawn)
				_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(entityToSpawn);
		}
		(itemstack).shrink(1);
	}
}
