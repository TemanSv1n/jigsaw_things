package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;
import net.svisvi.jigsaw.init.JigsawModMobEffects;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class SupershotgunprProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.POOPCLOUD.get()), x, y, z, 40, 1, 1, 1, 0);
				if (entityiterator instanceof LivingEntity _entity)
					_entity.addEffect(new MobEffectInstance(JigsawModMobEffects.POOP.get(), 21, 0, (false), (false)));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), (entityiterator.getX()), (entityiterator.getY()), (entityiterator.getZ()), 20, 1, 1, 1, 0);
			}
		}
	}
}
