package net.svisvi.jigsaw.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class PudgehookWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		boolean sw = false;
		double T = 0;
		double Zo = 0;
		double Yo = 0;
		double Za = 0;
		double Xo = 0;
		double Ya = 0;
		double Xa = 0;
		double speeed = 0;
		double dis = 0;
		immediatesourceentity.getPersistentData().putString("j_proj_owner", (entity.getStringUUID()));
		if (!immediatesourceentity.isNoGravity()) {
			immediatesourceentity.setNoGravity((true));
		}
		Xo = entity.getX() - immediatesourceentity.getX();
		Yo = entity.getY() - immediatesourceentity.getY();
		Zo = entity.getZ() - immediatesourceentity.getZ();
		if (Math.sqrt(Math.pow(immediatesourceentity.getDeltaMovement().x(), 2) + Math.pow(immediatesourceentity.getDeltaMovement().y(), 2) + Math.pow(immediatesourceentity.getDeltaMovement().z(), 2)) <= 0.4) {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
		Xo = entity.getX() - immediatesourceentity.getX();
		Yo = entity.getY() - immediatesourceentity.getY();
		Zo = entity.getZ() - immediatesourceentity.getZ();
		speeed = 0.5;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(immediatesourceentity == entityiterator) && !(entity == entityiterator)) {
					if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 3, 3, 3), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) == entityiterator) {
						dis = Math.sqrt(Math.pow(entityiterator.getX() - immediatesourceentity.getX(), 2) + Math.pow(entityiterator.getY() - immediatesourceentity.getY(), 2) + Math.pow(entityiterator.getZ() - immediatesourceentity.getZ(), 2));
						immediatesourceentity.setDeltaMovement(new Vec3((((entityiterator.getX() - immediatesourceentity.getX()) / dis) * speeed), (((entityiterator.getY() - immediatesourceentity.getY()) / dis) * speeed),
								(((entityiterator.getZ() - immediatesourceentity.getZ()) / dis) * speeed)));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 15, 0.7, 0.7, 0.7, 0.2);
						if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty()) {
							speeed = speeed * 1.2;
						}
					}
				}
			}
		}
		if (Math.floor(entity.getX()) <= Math.floor(immediatesourceentity.getX())) {
			if (Math.floor(entity.getX()) == Math.floor(immediatesourceentity.getX())) {
				if (Math.floor(entity.getY()) == Math.floor(immediatesourceentity.getY())) {
					if (Math.floor(entity.getZ()) <= Math.floor(immediatesourceentity.getZ())) {
						Za = Math.floor(entity.getZ()) + 0.2;
						while (Za <= Math.floor(immediatesourceentity.getZ())) {
							T = (Za - entity.getZ()) / Zo;
							Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
							Xa = entity.getX() + Xo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CRIT, Xa, Ya, Za, 1, 0, 0, 0, 0);
							Za = 0.2 + Za;
						}
					} else {
						Za = Math.floor(immediatesourceentity.getZ()) + 0.2;
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
					if (Math.floor(entity.getY()) <= Math.floor(immediatesourceentity.getY())) {
						Ya = Math.floor(entity.getY()) + 0.2;
						while (Ya <= Math.floor(immediatesourceentity.getY())) {
							T = (Ya - entity.getY()) / Yo;
							Xa = entity.getX() + Xo * T;
							Za = entity.getZ() + Zo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CRIT, Xa, Ya, Za, 1, 0, 0, 0, 0);
							Ya = 0.2 + Ya;
						}
					} else {
						Ya = Math.floor(immediatesourceentity.getY()) + 0.2;
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
				while (Xa <= Math.floor(immediatesourceentity.getX())) {
					T = (Xa - entity.getX()) / Xo;
					Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
					Za = entity.getZ() + Zo * T;
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.CRIT, Xa, Ya, Za, 1, 0, 0, 0, 0);
					Xa = 0.2 + Xa;
				}
			}
		} else {
			Xa = immediatesourceentity.getX() + 0.2;
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
