package net.svisvi.jigsaw.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class BeaweednutconsumableCanUseRangedItemProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) > 0) {
			return true;
		}
		return false;
	}
}
