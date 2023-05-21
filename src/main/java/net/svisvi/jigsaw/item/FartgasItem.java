
package net.svisvi.jigsaw.item;

import net.minecraft.network.chat.Component;

public class FartgasItem extends BucketItem {

	public FartgasItem() {
		super(JigsawModFluids.FARTGAS, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(JigsawModTabs.TAB_JIGSAW));
	}

}
