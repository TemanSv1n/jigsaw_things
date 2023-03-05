
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.BeaweednutPlayerFinishesUsingItemProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;
import net.svisvi.jigsaw.init.JigsawModItems;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;

public class BeaweednutItem extends Item {
	public BeaweednutItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).durability(16).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(-1).saturationMod(0f).alwaysEat()

				.build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(JigsawModItems.BEAWEEDNUT.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		BeaweednutPlayerFinishesUsingItemProcedure.execute(world, itemstack);
		if (itemstack.isEmpty()) {
			return retval;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retval))
					player.drop(retval, false);
			}
			return itemstack;
		}
	}
}
