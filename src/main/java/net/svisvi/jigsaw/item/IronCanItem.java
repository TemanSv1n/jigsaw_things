
package net.svisvi.jigsaw.item;

import net.minecraft.world.entity.ai.attributes.Attributes;
import javax.annotation.Nullable;

public class IronCanItem extends Item {

	public IronCanItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(64).rarity(Rarity.COMMON));
	}

}
