package net.svisvi.jigsaw.procedures;

import net.minecraft.world.entity.Entity;

public class BeaweednutconsumableWhileProjectileFlyingTickProcedure {
	public static void execute(Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		if (!immediatesourceentity.level.isClientSide())
			immediatesourceentity.discard();
	}
}
