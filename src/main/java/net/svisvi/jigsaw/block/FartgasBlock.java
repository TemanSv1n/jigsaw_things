
package net.svisvi.jigsaw.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class FartgasBlock extends LiquidBlock {
	public FartgasBlock() {
		super(() -> (FlowingFluid) JigsawModFluids.FARTGAS.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}

}