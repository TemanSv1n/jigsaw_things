
package net.svisvi.jigsaw.item;

import net.minecraft.network.chat.Component;

public class BeaverMassItem extends BucketItem {

	public BeaverMassItem() {
		super(JigsawModFluids.BEAVER_MASS, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(JigsawModTabs.TAB_JIGSAW));
	}

}
