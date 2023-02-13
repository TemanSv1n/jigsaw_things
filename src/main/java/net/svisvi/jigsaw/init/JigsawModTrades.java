
/*
*    MCreator note: This file will be REGENERATED on each build.
*/
package net.svisvi.jigsaw.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class JigsawModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.LEATHERWORKER) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6),

					new ItemStack(JigsawModItems.SLAVE_HELMET.get()), 3, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 9),

					new ItemStack(JigsawModItems.SLAVE_CHESTPLATE.get()), 3, 5, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 7),

					new ItemStack(JigsawModItems.SLAVE_LEGGINGS.get()), 10, 5, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6),

					new ItemStack(JigsawModItems.SLAVE_BOOTS.get()), 10, 5, 0.05f));
		}
	}
}
