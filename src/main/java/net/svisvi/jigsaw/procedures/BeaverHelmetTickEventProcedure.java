package net.svisvi.jigsaw.procedures;

import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;

public class BeaverHelmetTickEventProcedure {
	public static void execute(ItemStack itemstack) {
		(itemstack).enchant(Enchantments.BINDING_CURSE, 1);
	}
}
