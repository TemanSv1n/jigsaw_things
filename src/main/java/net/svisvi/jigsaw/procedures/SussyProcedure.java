package net.svisvi.jigsaw.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class SussyProcedure {
	public static void execute(ItemStack itemstack) {
		if (itemstack.is(ItemTags.create(new ResourceLocation("jigsaw:beaweed_block_drow")))) {
			(itemstack).shrink(1);
		}
	}
}
