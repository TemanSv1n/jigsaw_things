
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class NoFuelRocketItem extends Item {
	public NoFuelRocketItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(1).rarity(Rarity.COMMON));
	}
}
