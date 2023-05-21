
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class BeavermassBottleItem extends Item {
	public BeavermassBottleItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}
}
