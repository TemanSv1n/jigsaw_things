package net.svisvi.jigsaw.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class OnionHelmetTickEventProcedure {
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
		itemstack.getOrCreateTag().putDouble("cc2", (itemstack.getOrCreateTag().getDouble("cc2") + 1));
		if (itemstack.getOrCreateTag().getDouble("cc2") % 60 == 0) {
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(32 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Cow) {
						if (entityiterator instanceof Mob _entity)
							_entity.getNavigation().moveTo((entity.getX()), (entity.getY()), (entity.getZ()), 3);
						Xo = entity.getX() - entityiterator.getX();
						Yo = entity.getY() - entityiterator.getY();
						Zo = entity.getZ() - entityiterator.getZ();
						if (Math.floor(entity.getX()) <= Math.floor(entityiterator.getX())) {
							if (Math.floor(entity.getX()) == Math.floor(entityiterator.getX())) {
								if (Math.floor(entity.getY()) == Math.floor(entityiterator.getY())) {
									if (Math.floor(entity.getZ()) <= Math.floor(entityiterator.getZ())) {
										Za = Math.floor(entity.getZ()) + 0.2;
										while (Za <= Math.floor(entityiterator.getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Za = 0.2 + Za;
										}
									} else {
										Za = Math.floor(entityiterator.getZ()) + 0.2;
										while (Za <= Math.floor(entity.getZ())) {
											T = (Za - entity.getZ()) / Zo;
											Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
											Xa = entity.getX() + Xo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Za = 0.2 + Za;
										}
									}
								} else {
									if (Math.floor(entity.getY()) <= Math.floor(entityiterator.getY())) {
										Ya = Math.floor(entity.getY()) + 0.2;
										while (Ya <= Math.floor(entityiterator.getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Ya = 0.2 + Ya;
										}
									} else {
										Ya = Math.floor(entityiterator.getY()) + 0.2;
										while (Ya <= Math.floor(entity.getY())) {
											T = (Ya - entity.getY()) / Yo;
											Xa = entity.getX() + Xo * T;
											Za = entity.getZ() + Zo * T;
											if (world instanceof ServerLevel _level)
												_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, Xa, Ya, Za, 1, 0, 0, 0, 0);
											Ya = 0.2 + Ya;
										}
									}
								}
							} else {
								Xa = Math.floor(entity.getX()) + 0.2;
								while (Xa <= Math.floor(entityiterator.getX())) {
									T = (Xa - entity.getX()) / Xo;
									Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
									Za = entity.getZ() + Zo * T;
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, Xa, Ya, Za, 1, 0, 0, 0, 0);
									Xa = 0.2 + Xa;
								}
							}
						} else {
							Xa = entityiterator.getX() + 0.2;
							while (Xa < Math.floor(entity.getX())) {
								T = (Xa - entity.getX()) / Xo;
								Ya = entity.getBbHeight() / 2 + entity.getY() + Yo * T;
								Za = entity.getZ() + Zo * T;
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, Xa, Ya, Za, 1, 0, 0, 0, 0);
								Xa = 0.2 + Xa;
							}
						}
					}
				}
			}
		}
	}
}
