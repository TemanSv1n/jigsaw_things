package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.network.JigsawModVariables;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ShitStormWandAdminRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (JigsawModVariables.WorldVariables.get(world).shit_storm == true) {
			JigsawModVariables.WorldVariables.get(world).shit_storm = false;
			JigsawModVariables.WorldVariables.get(world).syncData(world);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		} else {
			JigsawModVariables.WorldVariables.get(world).shit_storm = true;
			JigsawModVariables.WorldVariables.get(world).syncData(world);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.yes")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.yes")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (world instanceof ServerLevel _level) {
				LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
				entityToSpawn.moveTo(Vec3.atBottomCenterOf(new BlockPos(x, y, z)));
				entityToSpawn.setVisualOnly(true);
				_level.addFreshEntity(entityToSpawn);
			}
		}
	}
}
