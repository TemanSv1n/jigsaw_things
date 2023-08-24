package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.entity.PoopsRocketEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class RocketLocatorEmittedRedstonePowerProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double sussy = 0;
		if (!world.getEntitiesOfClass(PoopsRocketEntity.class, AABB.ofSize(new Vec3(x, y, z), 64, 64, 64), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof PoopsRocketEntity) {
						if (entityiterator.getPersistentData().getBoolean("fall_rocket")) {
							if (world instanceof Level _level)
								_level.updateNeighborsAt(new BlockPos(x, y, z), _level.getBlockState(new BlockPos(x, y, z)).getBlock());
							sussy = 15;
						} else {
							sussy = 0;
						}
					}
				}
			}
		}
		return sussy;
	}
}
