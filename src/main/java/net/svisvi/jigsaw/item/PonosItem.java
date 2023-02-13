
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.init.JigsawModTabs;
import net.svisvi.jigsaw.init.JigsawModFluids;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class PonosItem extends BucketItem {
	public PonosItem() {
		super(JigsawModFluids.PONOS, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).rarity(Rarity.COMMON).tab(JigsawModTabs.TAB_JIGSAW));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Hold bucket when you have diarrhea to get it"));
	}
}
