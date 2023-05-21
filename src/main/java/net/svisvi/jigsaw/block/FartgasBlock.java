
package net.svisvi.jigsaw.block;

import net.svisvi.jigsaw.init.JigsawModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

public class FartgasBlock extends LiquidBlock {
	public FartgasBlock() {
		super(() -> (FlowingFluid) JigsawModFluids.FARTGAS.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}
}
