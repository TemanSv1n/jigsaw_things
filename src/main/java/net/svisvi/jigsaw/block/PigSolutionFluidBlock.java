
package net.svisvi.jigsaw.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class PigSolutionFluidBlock extends LiquidBlock {
	public PigSolutionFluidBlock() {
		super(() -> (FlowingFluid) JigsawModFluids.PIG_SOLUTION_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}

}