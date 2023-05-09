package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.network.JigsawModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.animal.TropicalFish;
import net.minecraft.world.entity.animal.Salmon;
import net.minecraft.world.entity.animal.Pufferfish;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

import java.util.Random;

@Mod.EventBusSubscriber
public class FishmoonactiveProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double z, Entity entity) {
		execute(null, world, x, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double z, Entity entity) {
		if (entity == null)
			return;
		if (JigsawModVariables.WorldVariables.get(world).fish_moon == true && (entity.level.dimension()) == (Level.OVERWORLD)) {
			entity.getPersistentData().putDouble("counter1", (entity.getPersistentData().getDouble("counter1") + 1));
			if (entity.getPersistentData().getDouble("counter1") % 20 == 0) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Cod(EntityType.COD, _level);
					entityToSpawn.moveTo((x + Mth.nextInt(new Random(), -5, 5)), 100, (z + Mth.nextInt(new Random(), -5, 5)), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
			if (entity.getPersistentData().getDouble("counter1") % 13 == 0) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Salmon(EntityType.SALMON, _level);
					entityToSpawn.moveTo((x + Mth.nextInt(new Random(), -5, 5)), 100, (z + Mth.nextInt(new Random(), -5, 5)), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
			if (entity.getPersistentData().getDouble("counter1") % 11 == 0) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new TropicalFish(EntityType.TROPICAL_FISH, _level);
					entityToSpawn.moveTo((x + Mth.nextInt(new Random(), -5, 5)), 100, (z + Mth.nextInt(new Random(), -5, 5)), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
			if (entity.getPersistentData().getDouble("counter1") % 7 == 0) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new Pufferfish(EntityType.PUFFERFISH, _level);
					entityToSpawn.moveTo((x + Mth.nextInt(new Random(), -5, 5)), 100, (z + Mth.nextInt(new Random(), -5, 5)), world.getRandom().nextFloat() * 360F, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
		}
		if (!world.getLevelData().isRaining() && JigsawModVariables.WorldVariables.get(world).fish_moon == true && JigsawModVariables.WorldVariables.get(world).fish_moon == true && (entity.level.dimension()) == (Level.OVERWORLD)) {
			world.getLevelData().setRaining(true);
		}
	}
}
