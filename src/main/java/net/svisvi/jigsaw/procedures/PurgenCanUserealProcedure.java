package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class PurgenCanUserealProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(JigsawModItems.SHITAMMO.get())) : false)
				&& !(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(JigsawModItems.PURGENBUNDLE.get())) : false)) {
			return true;
		} else if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(JigsawModItems.PURGENBUNDLE.get())) : false)
				&& !(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(JigsawModItems.SHITAMMO.get())) : false)) {
			return true;
		} else if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(JigsawModItems.PURGENBUNDLE.get())) : false)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.SHITAMMO.get()) {
			return true;
		} else if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(JigsawModItems.SHITAMMO.get())) : false)
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.PURGENBUNDLE.get()) {
			return true;
		}
		return false;
	}
}
