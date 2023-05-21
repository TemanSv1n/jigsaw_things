
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.block.WheatplacerBlock;
import net.svisvi.jigsaw.block.TallowBlockBlock;
import net.svisvi.jigsaw.block.SafegunpowderbarrelBlock;
import net.svisvi.jigsaw.block.PonosBlock;
import net.svisvi.jigsaw.block.PWhatblockBlock;
import net.svisvi.jigsaw.block.InvisibilitywheatbottomBlock;
import net.svisvi.jigsaw.block.InvisibilitywheatBlock;
import net.svisvi.jigsaw.block.InvisibilitybushBlock;
import net.svisvi.jigsaw.block.GunpowderbarrelBlock;
import net.svisvi.jigsaw.block.FatBlockBlock;
import net.svisvi.jigsaw.block.FatBlock;
import net.svisvi.jigsaw.block.DristTntBlock;
import net.svisvi.jigsaw.block.Beaweedstage4Block;
import net.svisvi.jigsaw.block.Beaweedstage3Block;
import net.svisvi.jigsaw.block.Beaweedstage1Block;
import net.svisvi.jigsaw.block.BeaweedseedsBlock;
import net.svisvi.jigsaw.block.BeaweeddustblockBlock;
import net.svisvi.jigsaw.block.BeaweedBlock;
import net.svisvi.jigsaw.block.BeavertopolivecostylBlock;
import net.svisvi.jigsaw.block.BeavergunpowderbarrelBlock;
import net.svisvi.jigsaw.block.BeavercutcostylBlock;
import net.svisvi.jigsaw.block.BeavercomputerBlock;
import net.svisvi.jigsaw.block.BeaverblockBlock;
import net.svisvi.jigsaw.block.BeaverTopBlock;
import net.svisvi.jigsaw.block.BeaverLiveCostylBlock;
import net.svisvi.jigsaw.block.BeaverBottomBlock;
import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

public class JigsawModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, JigsawMod.MODID);
	public static final RegistryObject<Block> P_WHATBLOCK = REGISTRY.register("p_whatblock", () -> new PWhatblockBlock());
	public static final RegistryObject<Block> PONOS = REGISTRY.register("ponos", () -> new PonosBlock());
	public static final RegistryObject<Block> BEAWEED = REGISTRY.register("beaweed", () -> new BeaweedBlock());
	public static final RegistryObject<Block> BEAWEEDDUSTBLOCK = REGISTRY.register("beaweeddustblock", () -> new BeaweeddustblockBlock());
	public static final RegistryObject<Block> BEAVER_TOP = REGISTRY.register("beaver_top", () -> new BeaverTopBlock());
	public static final RegistryObject<Block> BEAVER_BOTTOM = REGISTRY.register("beaver_bottom", () -> new BeaverBottomBlock());
	public static final RegistryObject<Block> BEAVER_LIVE_COSTYL = REGISTRY.register("beaver_live_costyl", () -> new BeaverLiveCostylBlock());
	public static final RegistryObject<Block> BEAVERTOPOLIVECOSTYL = REGISTRY.register("beavertopolivecostyl", () -> new BeavertopolivecostylBlock());
	public static final RegistryObject<Block> BEAVERCUTCOSTYL = REGISTRY.register("beavercutcostyl", () -> new BeavercutcostylBlock());
	public static final RegistryObject<Block> BEAVERBLOCK = REGISTRY.register("beaverblock", () -> new BeaverblockBlock());
	public static final RegistryObject<Block> GUNPOWDERBARREL = REGISTRY.register("gunpowderbarrel", () -> new GunpowderbarrelBlock());
	public static final RegistryObject<Block> SAFEGUNPOWDERBARREL = REGISTRY.register("safegunpowderbarrel", () -> new SafegunpowderbarrelBlock());
	public static final RegistryObject<Block> BEAVERGUNPOWDERBARREL = REGISTRY.register("beavergunpowderbarrel", () -> new BeavergunpowderbarrelBlock());
	public static final RegistryObject<Block> BEAVERCOMPUTER = REGISTRY.register("beavercomputer", () -> new BeavercomputerBlock());
	public static final RegistryObject<Block> INVISIBILITY_WHEAT = REGISTRY.register("invisibility_wheat", () -> new InvisibilitywheatBlock());
	public static final RegistryObject<Block> INVISIBILITY_WHEAT_BOTTOM = REGISTRY.register("invisibility_wheat_bottom", () -> new InvisibilitywheatbottomBlock());
	public static final RegistryObject<Block> WHEATPLACER = REGISTRY.register("wheatplacer", () -> new WheatplacerBlock());
	public static final RegistryObject<Block> INVISIBILITYBUSH = REGISTRY.register("invisibilitybush", () -> new InvisibilitybushBlock());
	public static final RegistryObject<Block> BEAWEEDSEEDS = REGISTRY.register("beaweedseeds", () -> new BeaweedseedsBlock());
	public static final RegistryObject<Block> BEAWEEDSTAGE_1 = REGISTRY.register("beaweedstage_1", () -> new Beaweedstage1Block());
	public static final RegistryObject<Block> BEAWEEDSTAGE_3 = REGISTRY.register("beaweedstage_3", () -> new Beaweedstage3Block());
	public static final RegistryObject<Block> BEAWEEDSTAGE_4 = REGISTRY.register("beaweedstage_4", () -> new Beaweedstage4Block());
	public static final RegistryObject<Block> FAT = REGISTRY.register("fat", () -> new FatBlock());
	public static final RegistryObject<Block> FAT_BLOCK = REGISTRY.register("fat_block", () -> new FatBlockBlock());
	public static final RegistryObject<Block> TALLOW_BLOCK = REGISTRY.register("tallow_block", () -> new TallowBlockBlock());
	public static final RegistryObject<Block> DRIST_TNT = REGISTRY.register("drist_tnt", () -> new DristTntBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			PWhatblockBlock.registerRenderLayer();
			BeaweedBlock.registerRenderLayer();
			BeaverTopBlock.registerRenderLayer();
			BeaverBottomBlock.registerRenderLayer();
			BeaverLiveCostylBlock.registerRenderLayer();
			BeavercomputerBlock.registerRenderLayer();
			InvisibilitywheatBlock.registerRenderLayer();
			InvisibilitywheatbottomBlock.registerRenderLayer();
			WheatplacerBlock.registerRenderLayer();
			BeaweedseedsBlock.registerRenderLayer();
			Beaweedstage1Block.registerRenderLayer();
			Beaweedstage3Block.registerRenderLayer();
			Beaweedstage4Block.registerRenderLayer();
		}

		@SubscribeEvent
		public static void blockColorLoad(ColorHandlerEvent.Block event) {
			InvisibilitybushBlock.blockColorLoad(event);
		}

		@SubscribeEvent
		public static void itemColorLoad(ColorHandlerEvent.Item event) {
			InvisibilitybushBlock.itemColorLoad(event);
		}
	}
}
