
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;

public class LadleItem extends AxeItem {
	public LadleItem() {
		super(new Tier() {
			public int getUses() {
				return 512;
			}

			public float getSpeed() {
				return 7f;
			}

			public float getAttackDamageBonus() {
				return 4f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.IRON_INGOT));
			}
		}, 1, -2.6f, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
	}
}
