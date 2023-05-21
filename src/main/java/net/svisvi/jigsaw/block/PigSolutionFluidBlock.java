
package net.svisvi.jigsaw.block;

import net.svisvi.jigsaw.init.JigsawModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

public class PigSolutionFluidBlock extends LiquidBlock {
	public PigSolutionFluidBlock() {
		super(() -> (FlowingFluid) JigsawModFluids.PIG_SOLUTION_FLUID.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}
}
