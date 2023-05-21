
package net.svisvi.jigsaw.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class FartDebugItem extends Item {
	public FartDebugItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.COMMON));
	}
}
