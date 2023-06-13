package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;
import net.svisvi.jigsaw.init.JigsawModBlocks;
import net.svisvi.jigsaw.entity.PoopsRocketEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class EmptyRocketOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getDeltaMovement().y() == -0.005) {
			entity.hurt(DamageSource.DRY_OUT, 1024);
		}
		if (entity instanceof LivingEntity _entity)
			_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 255, (false), (false)));
		if (entity.getPersistentData().getBoolean("fused") == true && entity.getPersistentData().getBoolean("fall_rocket") == false) {
			entity.getPersistentData().putDouble("rocket_counter1", (entity.getPersistentData().getDouble("rocket_counter1") + 1));
			if (entity.getPersistentData().getDouble("rocket_counter1") >= 200) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.4, (entity.getDeltaMovement().z())));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.FLAME, x, (y - 2.8), z, 60, 0.1, 1.4, 0.1, 0.1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), x, (y - 4), z, 80, 0.3, 2, 0.3, 0.1);
				if (entity.getPersistentData().getDouble("rocket_counter1") % 5 == 0) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.milk")), SoundSource.BLOCKS, 1, -1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.cow.milk")), SoundSource.BLOCKS, 1, -1, false);
						}
					}
					if ((world.getBlockState(new BlockPos(x, y, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
						if (entity.getDeltaMovement().y() > 0 && entity.getPersistentData().getBoolean("fall_rocket") == false) {
							world.setBlock(new BlockPos(x, y, z), JigsawModBlocks.PONOS.get().defaultBlockState(), 3);
						}
					}
				}
				if (y >= 319) {
					if (entity instanceof PoopsRocketEntity) {
						{
							Entity _ent = entity;
							_ent.teleportTo((entity.getPersistentData().getDouble("xdst")), (y - 1), (entity.getPersistentData().getDouble("zdst")));
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport((entity.getPersistentData().getDouble("xdst")), (y - 1), (entity.getPersistentData().getDouble("zdst")), _ent.getYRot(), _ent.getXRot());
						}
						entity.getPersistentData().putBoolean("fall_rocket", (true));
					} else {
						entity.hurt(DamageSource.DRY_OUT, 1024);
					}
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.POOF, x, y, z, 60, 2, 0.4, 2, 0.1);
				if (entity.getPersistentData().getDouble("rocket_counter1") % 5 == 0) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.break")), SoundSource.BLOCKS, 1, -1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wool.break")), SoundSource.BLOCKS, 1, -1, false);
						}
					}
				}
			}
		} else if (entity.getPersistentData().getBoolean("fused") == true && entity.getPersistentData().getBoolean("fall_rocket") == true) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (-1.4), (entity.getDeltaMovement().z())));
			entity.setSecondsOnFire(1);
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.FLAME, x, (y + 2.3), z, 30, 0.1, 1.4, 0.1, 0.1);
			if (entity.isOnGround()) {
				entity.hurt(DamageSource.DRY_OUT, 1024);
			}
		}
	}
}
