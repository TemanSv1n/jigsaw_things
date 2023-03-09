
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.block.ComposterBlock;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JigsawModCompostableItems {
	@SubscribeEvent
	public static void addComposterItems(FMLCommonSetupEvent event) {
		ComposterBlock.COMPOSTABLES.put(JigsawModBlocks.BEAWEEDDUSTBLOCK.get().asItem(), 0.8f);
		ComposterBlock.COMPOSTABLES.put(JigsawModItems.BEAWEEDDUST.get(), 0.19999999999999998f);
		ComposterBlock.COMPOSTABLES.put(JigsawModBlocks.BEAWEEDSEEDS.get().asItem(), 0.1f);
		ComposterBlock.COMPOSTABLES.put(JigsawModBlocks.BEAWEED.get().asItem(), 0.4f);
	}
}
