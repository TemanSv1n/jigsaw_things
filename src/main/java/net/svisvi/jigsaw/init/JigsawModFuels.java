
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;

import net.minecraft.world.item.ItemStack;

@Mod.EventBusSubscriber
public class JigsawModFuels {
	@SubscribeEvent
	public static void furnaceFuelBurnTimeEvent(FurnaceFuelBurnTimeEvent event) {
		ItemStack itemstack = event.getItemStack();
		if (itemstack.getItem() == JigsawModBlocks.BEAWEEDDUSTBLOCK.get().asItem())
			event.setBurnTime(2000);
		else if (itemstack.getItem() == JigsawModItems.BEAWEEDDUST.get())
			event.setBurnTime(200);
		else if (itemstack.getItem() == JigsawModBlocks.BEAWEEDSEEDS.get().asItem())
			event.setBurnTime(10);
		else if (itemstack.getItem() == JigsawModBlocks.BEAWEED.get().asItem())
			event.setBurnTime(100);
		else if (itemstack.getItem() == JigsawModItems.SUSSY_FUEL.get())
			event.setBurnTime(1600);
		else if (itemstack.getItem() == JigsawModItems.DRY_BIO_FUEL.get())
			event.setBurnTime(8000);
	}
}
