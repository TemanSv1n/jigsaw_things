
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AmpouleItem extends Item {
	public AmpouleItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(16).rarity(Rarity.COMMON));
	}
}
