package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModMobEffects;
import net.svisvi.jigsaw.init.JigsawModItems;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class ShitAmmoGunProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level && !_level.isClientSide())
			_level.explode(null, x, y, z, 1, Explosion.BlockInteraction.NONE);
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (!((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == JigsawModItems.HAZMAT_HELMET.get()
						&& (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == JigsawModItems.HAZMAT_CHESTPLATE.get()
						&& (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == JigsawModItems.HAZMAT_LEGGINGS.get()
						&& (entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == JigsawModItems.HAZMAT_BOOTS.get())) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(JigsawModMobEffects.POOP.get(), 120, 1));
				}
			}
		}
	}
}
