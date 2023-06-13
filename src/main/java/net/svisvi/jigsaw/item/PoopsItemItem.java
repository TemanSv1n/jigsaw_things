
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class PoopsItemItem extends Item {
	public PoopsItemItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(1).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(-100).saturationMod(0f).alwaysEat().meat().build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Fucking DEBUG"));
		list.add(new TextComponent("then listen: use poops ranged (not this) to coordinate rocket. Rename it like this   x"));
		list.add(new TextComponent("z       (e.g. 11"));
		list.add(new TextComponent("67)"));
		list.add(new TextComponent("so it will be your cords. To connect rocket with remote just make same NAMES (rocket entity name and remote item name; you can rename rocket in fueled!!! item phase"));
	}
}
