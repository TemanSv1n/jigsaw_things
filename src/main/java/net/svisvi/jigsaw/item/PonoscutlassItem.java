
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.PonoscutlassLivingEntityIsHitWithToolProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

public class PonoscutlassItem extends SwordItem {
	public PonoscutlassItem() {
		super(new Tier() {
			public int getUses() {
				return 1488;
			}

			public float getSpeed() {
				return 3f;
			}

			public float getAttackDamageBonus() {
				return 5f;
			}

			public int getLevel() {
				return 1;
			}

			public int getEnchantmentValue() {
				return 15;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(Items.NETHERITE_SCRAP));
			}
		}, 3, -2.4f, new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).fireResistant());
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		PonoscutlassLivingEntityIsHitWithToolProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}
}
