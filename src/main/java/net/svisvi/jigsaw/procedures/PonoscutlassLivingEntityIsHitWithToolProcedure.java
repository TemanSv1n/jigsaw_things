package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;
import net.svisvi.jigsaw.init.JigsawModMobEffects;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PonoscutlassLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double T = 0;
		double Zo = 0;
		double Yo = 0;
		double Za = 0;
		double Xo = 0;
		double Ya = 0;
		double Xa = 0;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(JigsawModMobEffects.POOP.get()) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(JigsawModMobEffects.POOP.get());
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 0, false, true));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 20, 0.7, 0.7, 0.7, 0.2);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jigsaw:clown_horn")), SoundSource.PLAYERS, 1, -1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jigsaw:clown_horn")), SoundSource.PLAYERS, 1, -1, false);
				}
			}
		} else if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(JigsawModMobEffects.PURGATIVE.get()) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(JigsawModMobEffects.PURGATIVE.get());
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60, 1, false, true));
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 50, 0.7, 0.7, 0.7, 0.2);
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.POOPCLOUD.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 20, 1, 1, 1, 0.1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jigsaw:clown_horn")), SoundSource.PLAYERS, 1, -1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("jigsaw:clown_horn")), SoundSource.PLAYERS, 1, -1, false);
				}
			}
		} else if (entity instanceof Player) {
			if ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) >= 2) {
				if (entity instanceof Player _player)
					_player.getFoodData().setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - 1));
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ASH, (entity.getX()), (entity.getY()), (entity.getZ()), 15, 0.7, 0.7, 0.7, 0.2);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.PLAYERS, 1, -1);
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.burp")), SoundSource.PLAYERS, 1, -1, false);
					}
				}
			}
		}
	}
}
