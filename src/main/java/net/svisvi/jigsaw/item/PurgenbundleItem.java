
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.PurgenbundlePlayerFinishesUsingItemProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;
import net.svisvi.jigsaw.init.JigsawModItems;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class PurgenbundleItem extends Item {
	public PurgenbundleItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(16).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1f).alwaysEat()

				.build()));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getContainerItem(ItemStack itemstack) {
		return new ItemStack(JigsawModItems.PILULE.get());
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 16;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Not recommended to use anywhere except overworld..."));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = new ItemStack(JigsawModItems.PILULE.get());
		super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		PurgenbundlePlayerFinishesUsingItemProcedure.execute(entity);
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
