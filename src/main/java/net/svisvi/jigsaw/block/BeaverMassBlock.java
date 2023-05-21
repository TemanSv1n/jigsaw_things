
package net.svisvi.jigsaw.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BeaverMassBlock extends LiquidBlock {
	public BeaverMassBlock() {
		super(() -> (FlowingFluid) JigsawModFluids.BEAVER_MASS.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}

}