package net.svisvi.jigsaw.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.Random;
import java.util.List;
import java.util.Comparator;

public class RadioBeaverOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		DamageSource beaver = new DamageSource("generic");
		String uuid = "";
		double speed2 = 0;
		double T = 0;
		double Zo = 0;
		double Yo = 0;
		double Za = 0;
		double Xo = 0;
		double Ya = 0;
		double Xa = 0;
		if (entity.getPersistentData().getBoolean("signum") == true) {
			entity.getPersistentData().putBoolean("signum", (false));
			beaver = new EntityDamageSource("generic.player", entity);
			{
				final Vec3 _center = new Vec3(
						(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
						(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
						(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						entityiterator.hurt(beaver, Mth.nextInt(new Random(), 1, 3));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.weak")), SoundSource.HOSTILE, 1, 1);
							} else {
								_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.weak")), SoundSource.HOSTILE, 1, 1, false);
							}
						}
						Xo = entity.getX()
								- entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
						Yo = entity.getY()
								- entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
						Zo = entity.getZ()
								- entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
						if (Math.floor(entity.getX()) <= Math
								.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX())) {
							if (Math.floor(entity.getX()) == Math.floor(
									entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX())) {
								if (Math.floor(entity.getY()) == Math.floor(entity.level
										.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY())) {
									if (Math.floor(entity.getZ()) <= Math.floor(entity.level
											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ())) {
										Za = Math.floor(entity.getZ()) + 0.2;
										while (Za <= Math.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.CRIT, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Za = 0.2 + Za;
										}
									} else {
										Za = Math.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getZ()) + 0.2;
										while (Za <= Math.floor(entity.getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.CRIT, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Za = 0.2 + Za;
										}
									}
								} else {
									if (Math.floor(entity.getY()) <= Math.floor(entity.level
											.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY())) {
										Ya = Math.floor(entity.getY()) + 0.2;
										while (Ya <= Math.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.CRIT, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Ya = 0.2 + Ya;
										}
									} else {
										Ya = Math.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
												.getBlockPos().getY()) + 0.2;
										while (Ya <= Math.floor(entity.getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.CRIT, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Ya = 0.2 + Ya;
										}
									}
								}
							} else {
								Xa = Math.floor(entity.getX()) + 0.2;
								while (Xa <= Math.floor(entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getX())) {
									T = (Xa - entity.getX()) / Xo;
									Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
									Za = entity.getZ() + Zo * T;
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.CRIT, Xa, Ya, Za, 1, 0, 0, 0, 0);
									Xa = 0.2 + Xa;
								}
							}
						} else {
							Xa = entity.level.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(1)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 0.2;
							while (Xa < Math.floor(entity.getX())) {
								T = (Xa - entity.getX()) / Xo;
								Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
								Za = entity.getZ() + Zo * T;
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CRIT, Xa, Ya, Za, 1, 0, 0, 0, 0);
								Xa = 0.2 + Xa;
							}
						}
					}
				}
			}
		}
	}
}
