package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;
import net.svisvi.jigsaw.init.JigsawModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.ArrayList;

public class JetstreamchairOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double speed = 0;
		double Yaw = 0;
		for (Entity entityiterator : new ArrayList<>(entity.getPassengers())) {
			if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.BEAWEEDDUST.get()
					&& !((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.BEAWEEDDUST.get())) {
				speed = 0.2;
				Yaw = entity.getYRot();
				entity.setDeltaMovement(new Vec3(0, (Mth.nextDouble(new Random(), 0.2, 0.4)), 0));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), x, (y - 1.3), z, 5, 0, (-0.7), 0, 0.1);
				entity.getPersistentData().putDouble("counter1", (entity.getPersistentData().getDouble("counter1") + 1));
				if (entity.getPersistentData().getDouble("counter1") % 20 == 0) {
					((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.shoot")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.shoot")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
			} else if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.BEAWEEDDUST.get()
					&& !((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.BEAWEEDDUST.get())) {
				speed = 0.2;
				Yaw = entity.getYRot();
				entity.setDeltaMovement(new Vec3(0, (Mth.nextDouble(new Random(), 0.2, 0.4)), 0));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), x, (y - 1.3), z, 5, 0, (-0.7), 0, 0.1);
				entity.getPersistentData().putDouble("counter1", (entity.getPersistentData().getDouble("counter1") + 1));
				if (entity.getPersistentData().getDouble("counter1") % 20 == 0) {
					((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).shrink(1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.shoot")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.shoot")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
			} else if ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.BEAWEEDDUST.get()
					&& (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.BEAWEEDDUST.get()) {
				speed = 0.2;
				Yaw = entity.getYRot();
				entity.setDeltaMovement(new Vec3(0, (Mth.nextDouble(new Random(), 0.2, 0.4)), 0));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), x, (y - 1.3), z, 5, 0, (-0.7), 0, 0.1);
				entity.getPersistentData().putDouble("counter1", (entity.getPersistentData().getDouble("counter1") + 1));
				if (entity.getPersistentData().getDouble("counter1") % 20 == 0) {
					((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).shrink(1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.shoot")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.shoot")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
			}
		}
	}
}
