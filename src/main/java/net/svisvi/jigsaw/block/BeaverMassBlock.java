
package net.svisvi.jigsaw.block;

import net.svisvi.jigsaw.init.JigsawModFluids;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;

public class BeaverMassBlock extends LiquidBlock {
	public BeaverMassBlock() {
		super(() -> (FlowingFluid) JigsawModFluids.BEAVER_MASS.get(), BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
	}
}
