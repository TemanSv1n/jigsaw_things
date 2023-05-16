package net.svisvi.jigsaw.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ClownNoseHelmetTickEventProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean enable = false;
		if (itemstack.getOrCreateTag().getDouble("cc1") < 120) {
			itemstack.getOrCreateTag().putDouble("cc1", (itemstack.getOrCreateTag().getDouble("cc1") + 1));
		}
		if (!entity.isShiftKeyDown()) {
			itemstack.getOrCreateTag().putBoolean("sus", (false));
		} else if (itemstack.getOrCreateTag().getDouble("cc1") >= 60 && itemstack.getOrCreateTag().getBoolean("sus") == false && entity.isShiftKeyDown()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jigsaw:clown_horn")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jigsaw:clown_horn")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			itemstack.getOrCreateTag().putBoolean("sus", (true));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 60);
			itemstack.getOrCreateTag().putDouble("cc1", 0);
		}
	}
}
