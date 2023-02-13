package net.svisvi.jigsaw.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.Mth;
import net.minecraft.client.Minecraft;

import java.util.Random;

public class BeaverknifeLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		{
			ItemStack _ist = itemstack;
			if (_ist.hurt(1, new Random(), null)) {
				_ist.shrink(1);
				_ist.setDamageValue(0);
			}
		}
		if (Mth.nextInt(new Random(), 1, 2) == 1) {
			itemstack.getOrCreateTag().putBoolean("chance", (true));
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
		} else {
			itemstack.getOrCreateTag().putBoolean("chance", (false));
		}
	}
}
