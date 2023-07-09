package net.svisvi.jigsaw.procedures;

import net.minecraft.world.item.ItemStack;

public class ShitSnipeCanUseRangedItemProcedure {
	public static boolean execute(ItemStack itemstack) {
		if ((itemstack).getDamageValue() < (itemstack).getMaxDamage() - 1) {
			return true;
		}
		return false;
	}
}
