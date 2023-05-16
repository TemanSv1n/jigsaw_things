package net.svisvi.jigsaw.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class PoopsWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
		if (entity == null || immediatesourceentity == null)
			return;
		double dis = 0;
		double speeed = 0;
		speeed = 0.5;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!(immediatesourceentity == entityiterator) && !(entity == entityiterator)) {
					if (((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) == entityiterator) {
						dis = Math.sqrt(Math.pow(entityiterator.getX() - immediatesourceentity.getX(), 2) + Math.pow(entityiterator.getY() - immediatesourceentity.getY(), 2) + Math.pow(entityiterator.getZ() - immediatesourceentity.getZ(), 2));
						immediatesourceentity.setDeltaMovement(new Vec3((((entityiterator.getX() - immediatesourceentity.getX()) / dis) * speeed), (((entityiterator.getY() - immediatesourceentity.getY()) / dis) * speeed),
								(((entityiterator.getZ() - immediatesourceentity.getZ()) / dis) * speeed)));
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.FLASH, x, y, z, 15, 0.7, 0.7, 0.7, 0.2);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.SMOKE, x, y, z, 15, 0.7, 0.7, 0.7, 0.2);
						if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, z), 5, 5, 5), e -> true).isEmpty()) {
							speeed = speeed * 1.2;
						}
					}
				}
			}
		}
	}
}
