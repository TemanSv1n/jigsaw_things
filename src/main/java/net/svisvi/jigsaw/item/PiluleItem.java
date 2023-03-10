
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PiluleItem extends Item {
	public PiluleItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(64).rarity(Rarity.COMMON));
	}
}
