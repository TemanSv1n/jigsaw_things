package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.entity.PoopsRocketEntity;
import net.svisvi.jigsaw.entity.EmptyRocketEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class PoopsRemoteRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double rocket_remote_radius = 0;
		String str1 = "";
		rocket_remote_radius = 128;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 1200);
		str1 = (itemstack.getDisplayName().getString()).substring((int) 1, (int) ((itemstack.getDisplayName().getString()).length() - 1));
		if (!world.getEntitiesOfClass(EmptyRocketEntity.class, AABB.ofSize(new Vec3(x, y, z), rocket_remote_radius, rocket_remote_radius, rocket_remote_radius), e -> true).isEmpty()
				|| !world.getEntitiesOfClass(PoopsRocketEntity.class, AABB.ofSize(new Vec3(x, y, z), rocket_remote_radius, rocket_remote_radius, rocket_remote_radius), e -> true).isEmpty()) {
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(rocket_remote_radius / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof EmptyRocketEntity || entityiterator instanceof PoopsRocketEntity) {
						if ((entityiterator.getDisplayName().getString()).equals(str1)) {
							entityiterator.getPersistentData().putBoolean("fused", (true));
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.yes")), SoundSource.PLAYERS, 1, -1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.yes")), SoundSource.PLAYERS, 1, -1, false);
								}
							}
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, (entityiterator.getX()), (entityiterator.getY() + 4), (entityiterator.getZ()), 30, 0.2, 0.4, 0.2, 1);
						}
					}
				}
			}
		} else {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")), SoundSource.PLAYERS, 1, -1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.no")), SoundSource.PLAYERS, 1, -1, false);
				}
			}
		}
	}
}
