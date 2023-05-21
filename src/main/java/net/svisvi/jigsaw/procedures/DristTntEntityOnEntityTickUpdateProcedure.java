package net.svisvi.jigsaw.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class DristTntEntityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("timer", (entity.getPersistentData().getDouble("timer") + 1));
		if (entity.getPersistentData().getDouble("timer") == 160) {
			if (world instanceof Level _level && !_level.isClientSide())
				_level.explode(null, x, y, z, 4, Explosion.BlockInteraction.NONE);
			SafegunpowderexplodeotherProcedure.execute(world, x, y, z);
		}
	}
}
