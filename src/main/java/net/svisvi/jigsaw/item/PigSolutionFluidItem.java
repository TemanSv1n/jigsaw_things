
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.init.JigsawModTabs;
import net.svisvi.jigsaw.init.JigsawModFluids;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

public class PigSolutionFluidItem extends BucketItem {
	public PigSolutionFluidItem() {
		super(JigsawModFluids.PIG_SOLUTION_FLUID, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(JigsawModTabs.TAB_JIGSAW));
	}
}
