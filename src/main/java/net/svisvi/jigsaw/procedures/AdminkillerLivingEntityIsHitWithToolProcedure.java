package net.svisvi.jigsaw.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;

public class AdminkillerLivingEntityIsHitWithToolProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player || entity instanceof ServerPlayer) {
			entity.hurt(DamageSource.FREEZE, 99999);
		}
		if (!entity.level.isClientSide())
			entity.discard();
	}
}
