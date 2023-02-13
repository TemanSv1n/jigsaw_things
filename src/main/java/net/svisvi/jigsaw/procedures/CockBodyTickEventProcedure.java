package net.svisvi.jigsaw.procedures;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class CockBodyTickEventProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Items.MILK_BUCKET)) : false) && entity.isShiftKeyDown()) {
			entity.setSecondsOnFire(1);
		}
	}
}
