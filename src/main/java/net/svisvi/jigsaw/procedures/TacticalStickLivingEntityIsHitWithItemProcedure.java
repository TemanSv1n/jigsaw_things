package net.svisvi.jigsaw.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.List;
import java.util.Comparator;

import com.mojang.util.UUIDTypeAdapter;

public class TacticalStickLivingEntityIsHitWithItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (sourceentity.isShiftKeyDown()) {
			itemstack.getOrCreateTag().putString("entity_uuid", (entity.getStringUUID()));
		} else {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator == (world instanceof ServerLevel _serverLevelForGettingEntity ? (new Function<String, Entity>() {
						@Override
						public Entity apply(String _uuidForEntity) {
							Entity _entityFromUUID = null;
							try {
								_entityFromUUID = _serverLevelForGettingEntity.getEntity(UUIDTypeAdapter.fromString(_uuidForEntity));
							} catch (Exception e) {
								_entityFromUUID = null;
							}
							return _entityFromUUID;
						}
					}).apply((itemstack.getOrCreateTag().getString("entity_uuid"))) : null)) {
						(world instanceof ServerLevel _serverLevelForGettingEntity ? (new Function<String, Entity>() {
							@Override
							public Entity apply(String _uuidForEntity) {
								Entity _entityFromUUID = null;
								try {
									_entityFromUUID = _serverLevelForGettingEntity.getEntity(UUIDTypeAdapter.fromString(_uuidForEntity));
								} catch (Exception e) {
									_entityFromUUID = null;
								}
								return _entityFromUUID;
							}
						}).apply((itemstack.getOrCreateTag().getString("entity_uuid"))) : null).startRiding(entity);
					}
				}
			}
		}
	}
}
