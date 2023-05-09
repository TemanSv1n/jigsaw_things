package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModEnchantments;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

public class SupershotgunItemInHandTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double speed = 0;
		double Yaw = 0;
		if (EnchantmentHelper.getItemEnchantmentLevel(JigsawModEnchantments.SRUCIBLECHARGE.get(), itemstack) != 0) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("Bullet : " + "1")), true);
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("Bullet : " + "0")), true);
		}
	}
}
