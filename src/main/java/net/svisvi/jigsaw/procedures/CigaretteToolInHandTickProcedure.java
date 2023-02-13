package net.svisvi.jigsaw.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.Random;

public class CigaretteToolInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double T = 0;
		double Zo = 0;
		double Yo = 0;
		double Za = 0;
		double Xo = 0;
		double Ya = 0;
		double Xa = 0;
		if (itemstack.getOrCreateTag().getBoolean("active") == true) {
			entity.getPersistentData().putDouble("counter1", (entity.getPersistentData().getDouble("counter1") + 1));
			if (entity.getPersistentData().getDouble("counter1") % 5 == 0) {
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, new Random(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.LARGE_SMOKE,
						(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX()),
						(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getY()),
						(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getZ()), 25, 0,
						0, 0, 0);
			Xo = entity.getX() - entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX();
			Yo = entity.getY() - entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getY();
			Zo = entity.getZ() - entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getZ();
			if (Math.floor(entity.getX()) <= Math
					.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX())) {
				if (Math.floor(entity.getX()) == Math
						.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX())) {
					if (Math.floor(entity.getY()) == Math.floor(
							entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getY())) {
						if (Math.floor(entity.getZ()) <= Math.floor(entity.level
								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getZ())) {
							Za = Math.floor(entity.getZ()) + 0.2;
							while (Za <= Math.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity))
									.getBlockPos().getZ())) {
								T = (Za - entity.getZ()) / Zo;
								Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
								Xa = entity.getX() + Xo * T;
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SMOKE, Xa, Ya, Za, 1, 0, 0, 0, 0);
								Za = 0.2 + Za;
							}
						} else {
							Za = Math.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity))
									.getBlockPos().getZ()) + 0.2;
							while (Za <= Math.floor(entity.getZ())) {
								T = (Za - entity.getZ()) / Zo;
								Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
								Xa = entity.getX() + Xo * T;
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SMOKE, Xa, Ya, Za, 1, 0, 0, 0, 0);
								Za = 0.2 + Za;
							}
						}
					} else {
						if (Math.floor(entity.getY()) <= Math.floor(entity.level
								.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getY())) {
							Ya = Math.floor(entity.getY()) + 0.2;
							while (Ya <= Math.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity))
									.getBlockPos().getY())) {
								T = (Ya - entity.getY()) / Yo;
								Xa = entity.getX() + Xo * T;
								Za = entity.getZ() + Zo * T;
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SMOKE, Xa, Ya, Za, 1, 0, 0, 0, 0);
								Ya = 0.2 + Ya;
							}
						} else {
							Ya = Math.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity))
									.getBlockPos().getY()) + 0.2;
							while (Ya <= Math.floor(entity.getY())) {
								T = (Ya - entity.getY()) / Yo;
								Xa = entity.getX() + Xo * T;
								Za = entity.getZ() + Zo * T;
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.SMOKE, Xa, Ya, Za, 1, 0, 0, 0, 0);
								Ya = 0.2 + Ya;
							}
						}
					}
				} else {
					Xa = Math.floor(entity.getX()) + 0.2;
					while (Xa <= Math.floor(
							entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX())) {
						T = (Xa - entity.getX()) / Xo;
						Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
						Za = entity.getZ() + Zo * T;
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, Xa, Ya, Za, 1, 0, 0, 0, 0);
						Xa = 0.2 + Xa;
					}
				}
			} else {
				Xa = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(2)), ClipContext.Block.COLLIDER, ClipContext.Fluid.SOURCE_ONLY, entity)).getBlockPos().getX() + 0.2;
				while (Xa < Math.floor(entity.getX())) {
					T = (Xa - entity.getX()) / Xo;
					Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
					Za = entity.getZ() + Zo * T;
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.SMOKE, Xa, Ya, Za, 1, 0, 0, 0, 0);
					Xa = 0.2 + Xa;
				}
			}
		}
	}
}
