
package net.svisvi.jigsaw.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class DvoretskiyItem extends SwordItem {
	public DvoretskiyItem() {
		super(new Tier() {
			public int getUses() {
				return 438;
			}

			public float getSpeed() {
				return 3f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.BOOK));
			}
		},

				3, -2.7f,

				new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).fireResistant());
	}

}
