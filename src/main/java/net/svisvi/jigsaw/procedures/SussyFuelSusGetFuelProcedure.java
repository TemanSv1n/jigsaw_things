package net.svisvi.jigsaw.procedures;

import net.minecraftforge.common.ForgeHooks;

import net.minecraft.world.item.ItemStack;

public class SussyFuelSusGetFuelProcedure {
	public static void execute(ItemStack itemstack) {
		double cookan = 0;
		cookan = ForgeHooks.getBurnTime(itemstack, null);
	}
}
