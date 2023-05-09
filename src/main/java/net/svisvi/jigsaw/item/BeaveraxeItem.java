
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.BeaveraxeBlockDestroyedWithToolProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.InteractionResult;

public class BeaveraxeItem extends AxeItem {
	public BeaveraxeItem() {
		super(new Tier() {
			public int getUses() {
				return 333;
			}

			public float getSpeed() {
				return 9f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 8;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, 1, -2.7999999999999998f, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		BeaveraxeBlockDestroyedWithToolProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
