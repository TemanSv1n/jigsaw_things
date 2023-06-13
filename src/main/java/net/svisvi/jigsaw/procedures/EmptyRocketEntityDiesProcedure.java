package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.entity.PoopsRocketEntity;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

import java.util.Random;

public class EmptyRocketEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack rocket_drop_rocket = ItemStack.EMPTY;
		ItemStack rocket_drop_poops = ItemStack.EMPTY;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (entity.getPersistentData().getBoolean("fused") == false) {
			rocket_drop_rocket = new ItemStack(JigsawModItems.EMPTY_ROCKET_SPAWN_EGG.get());
			(rocket_drop_rocket).setHoverName(new TextComponent((entity.getDisplayName().getString())));
			if (world instanceof Level _level && !_level.isClientSide()) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, rocket_drop_rocket);
				entityToSpawn.setPickUpDelay(10);
				entityToSpawn.setUnlimitedLifetime();
				_level.addFreshEntity(entityToSpawn);
			}
			if (entity instanceof PoopsRocketEntity) {
				rocket_drop_poops = new ItemStack(JigsawModItems.POOPS.get());
				(rocket_drop_poops).setHoverName(new TextComponent((entity.getPersistentData().getDouble("xdst") + "," + entity.getPersistentData().getDouble("zdst"))));
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, rocket_drop_poops);
					entityToSpawn.setPickUpDelay(10);
					entityToSpawn.setUnlimitedLifetime();
					_level.addFreshEntity(entityToSpawn);
				}
			}
		} else {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 14, Explosion.BlockInteraction.BREAK);
			sx = -3;
			found = false;
			for (int index0 = 0; index0 < (int) (6); index0++) {
				sy = -3;
				for (int index1 = 0; index1 < (int) (6); index1++) {
					sz = -3;
					for (int index2 = 0; index2 < (int) (6); index2++) {
						if (!world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).canOcclude()) {
							if (Mth.nextInt(new Random(), 1, 100) >= 65) {
								DristTntRedstoneOnProcedure.execute(world, (x + sx), (y + sy), (z + sz));
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
}
