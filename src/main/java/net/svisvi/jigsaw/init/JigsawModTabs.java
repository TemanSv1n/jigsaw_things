
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class JigsawModTabs {
	public static CreativeModeTab TAB_JIGSAW;

	public static void load() {
		TAB_JIGSAW = new CreativeModeTab("tabjigsaw") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(JigsawModItems.BEAVERBOMB.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
