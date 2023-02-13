
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

public abstract class SlaveItem extends ArmorItem {
	public SlaveItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 25;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{1, 2, 3, 1}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 0;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.LEATHER));
			}

			@Override
			public String getName() {
				return "slave";
			}

			@Override
			public float getToughness() {
				return 0f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, slot, properties);
	}

	public static class Helmet extends SlaveItem {
		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jigsaw:textures/models/armor/slave__layer_1.png";
		}
	}

	public static class Chestplate extends SlaveItem {
		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jigsaw:textures/models/armor/slave__layer_1.png";
		}
	}

	public static class Leggings extends SlaveItem {
		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jigsaw:textures/models/armor/slave__layer_2.png";
		}
	}

	public static class Boots extends SlaveItem {
		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jigsaw:textures/models/armor/slave__layer_1.png";
		}
	}
}
