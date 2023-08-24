package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.init.JigsawModEntities;
import net.svisvi.jigsaw.entity.JetstreamchairEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class JetstreamChairEmergencyEntitySwingsItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		(itemstack).shrink(1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jigsaw:clown_horn")), SoundSource.PLAYERS, 1, -1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jigsaw:clown_horn")), SoundSource.PLAYERS, 1, -1, false);
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == (ItemStack.EMPTY).getItem()) {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(JigsawModItems.BEAWEEDDUST.get());
				_setstack.setCount(8);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		} else {
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack = new ItemStack(JigsawModItems.BEAWEEDDUST.get());
				_setstack.setCount(8);
				_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
		if (world instanceof ServerLevel _serverLevelForEntitySpawn) {
			Entity _entityForSpawning = new JetstreamchairEntity(JigsawModEntities.JETSTREAMCHAIR.get(), _serverLevelForEntitySpawn);
			_entityForSpawning.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
			entity.startRiding(_entityForSpawning);
			if (_entityForSpawning instanceof Mob _mobForSpawning)
				_mobForSpawning.finalizeSpawn(_serverLevelForEntitySpawn, world.getCurrentDifficultyAt(_entityForSpawning.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
			world.addFreshEntity(_entityForSpawning);
		}
	}
}
