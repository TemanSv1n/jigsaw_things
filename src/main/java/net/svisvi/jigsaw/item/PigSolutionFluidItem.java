
package net.svisvi.jigsaw.item;

import net.minecraft.network.chat.Component;

public class PigSolutionFluidItem extends BucketItem {

	public PigSolutionFluidItem() {
		super(JigsawModFluids.PIG_SOLUTION_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(JigsawModTabs.TAB_JIGSAW));
	}

}
