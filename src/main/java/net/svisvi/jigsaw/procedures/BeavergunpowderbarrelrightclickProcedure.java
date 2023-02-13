package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModEntities;
import net.svisvi.jigsaw.entity.BeaverbombEntity;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class BeavergunpowderbarrelrightclickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		if (world instanceof ServerLevel projectileLevel) {
			Projectile _entityToSpawn = new Object() {
				public Projectile getArrow(Level level, float damage, int knockback) {
					AbstractArrow entityToSpawn = new BeaverbombEntity(JigsawModEntities.BEAVERBOMB.get(), level);
					entityToSpawn.setBaseDamage(damage);
					entityToSpawn.setKnockback(knockback);
					entityToSpawn.setSilent(true);
					return entityToSpawn;
				}
			}.getArrow(projectileLevel, (float) 0.2, 0);
			_entityToSpawn.setPos(x, y, z);
			_entityToSpawn.shoot(0, 0, 0, (float) 0.6, 0);
			projectileLevel.addFreshEntity(_entityToSpawn);
		}
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, (float) 0.3, Explosion.BlockInteraction.NONE);
		SafegunpowderexplodeotherProcedure.execute(world, x, y, z);
	}
}
