
package net.svisvi.jigsaw.item;

import net.minecraft.sounds.SoundEvent;

public abstract class HazmatItem extends ArmorItem {

	public HazmatItem(EquipmentSlot slot, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForSlot(EquipmentSlot slot) {
				return new int[]{13, 15, 16, 11}[slot.getIndex()] * 6;
			}

			@Override
			public int getDefenseForSlot(EquipmentSlot slot) {
				return new int[]{2, 4, 5, 2}[slot.getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.DRIED_KELP));
			}

			@Override
			public String getName() {
				return "hazmat";
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

	public static class Helmet extends HazmatItem {

		public Helmet() {
			super(EquipmentSlot.HEAD, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jigsaw:textures/models/armor/hazm__layer_1.png";
		}

	}

	public static class Chestplate extends HazmatItem {

		public Chestplate() {
			super(EquipmentSlot.CHEST, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jigsaw:textures/models/armor/hazm__layer_1.png";
		}

	}

	public static class Leggings extends HazmatItem {

		public Leggings() {
			super(EquipmentSlot.LEGS, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jigsaw:textures/models/armor/hazm__layer_2.png";
		}

	}

	public static class Boots extends HazmatItem {

		public Boots() {
			super(EquipmentSlot.FEET, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "jigsaw:textures/models/armor/hazm__layer_1.png";
		}

	}

}
