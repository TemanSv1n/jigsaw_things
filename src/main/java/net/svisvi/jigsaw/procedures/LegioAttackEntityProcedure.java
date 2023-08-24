package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.entity.LivingBeaverEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class LegioAttackEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity Atta, Entity Centu) {
		if (Atta == null || Centu == null)
			return;
		Entity Centurion = null;
		Entity Attackable = null;
		Centurion = Centu;
		Attackable = Atta;
		{
			final Vec3 _center = new Vec3(x, y, z);
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(64 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).collect(Collectors.toList());
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingBeaverEntity) {
					if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("minecraft:banners")))) {
						if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
								.getItem() == (Centurion instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()) {
							if (JigsawModItems.LEGIO_ARMOR_CHESTPLATE.get() == (Centurion instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem()) {
								if (entityiterator instanceof Mob _entity && Attackable instanceof LivingEntity _ent)
									_entity.setTarget(_ent);
							}
						}
					}
				}
			}
		}
	}
}
