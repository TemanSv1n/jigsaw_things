
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.JetstreamchairitemItemIsDroppedByPlayerProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import java.util.List;

public class JetstreamchairitemItem extends Item {
	public JetstreamchairitemItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Drop it. Put Beaweed dust in your hand..."));
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		JetstreamchairitemItemIsDroppedByPlayerProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), itemstack);
		return true;
	}
}
