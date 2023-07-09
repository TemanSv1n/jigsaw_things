package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.init.JigsawModEntities;
import net.svisvi.jigsaw.entity.PoopsRocketEntity;
import net.svisvi.jigsaw.entity.DristerTntEntity;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.LargeFireball;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
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
						if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
							if (Mth.nextInt(new Random(), 1, 100) >= 40) {
								world.setBlock(new BlockPos(x + sx, y + sy, z + sz), Blocks.FIRE.defaultBlockState(), 3);
							}
						}
						if (!world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)).canOcclude()) {
							if (Mth.nextInt(new Random(), 1, 100) >= 65) {
								if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
									Entity _entityForSpawning = new DristerTntEntity(JigsawModEntities.DRISTER_TNT.get(), _serverLevelForEntitySpawn);
									_entityForSpawning.moveTo((x + sx), (y + sy), (z + sz), world.getRandom().nextFloat() * 360F, 0);
									_entityForSpawning.getPersistentData().putDouble("timer", (Mth.nextInt(new Random(), 40, 158)));
									if (_entityForSpawning instanceof Mob _mobForSpawning)
										_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
									world.addFreshEntity(_entityForSpawning);
								}
							}
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			for (int index3 = 0; index3 < (int) (16); index3++) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getFireball(Level level, Entity shooter, double ax, double ay, double az) {
								AbstractHurtingProjectile entityToSpawn = new LargeFireball(EntityType.FIREBALL, level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.xPower = ax;
								entityToSpawn.yPower = ay;
								entityToSpawn.zPower = az;
								return entityToSpawn;
							}
						}.getFireball(projectileLevel, entity, 0, (-3), 0);
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 1, 5);
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		}
	}
}
