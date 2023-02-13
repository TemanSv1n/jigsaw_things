
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.BeaverknifeLivingEntityIsHitWithToolProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

public class BeaverknifeItem extends SwordItem {
	public BeaverknifeItem() {
		super(new Tier() {
			public int getUses() {
				return 128;
			}

			public float getSpeed() {
				return 6f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 5;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.EMPTY;
			}
		}, 3, -2.2000000000000002f, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		BeaverknifeLivingEntityIsHitWithToolProcedure.execute(entity.level, itemstack);
		return retval;
	}
}
