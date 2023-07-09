package net.svisvi.jigsaw.procedures;

import net.minecraft.world.item.ItemStack;

public class YamatopigItemIsCraftedsmeltedProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putBoolean("pigged", (true));
	}
}
