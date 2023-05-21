
package net.svisvi.jigsaw.fluid;

import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.init.JigsawModFluids;
import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

public abstract class PigSolutionFluidFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(JigsawModFluids.PIG_SOLUTION_FLUID, JigsawModFluids.FLOWING_PIG_SOLUTION_FLUID,
			FluidAttributes.builder(new ResourceLocation("jigsaw:blocks/pig_solution"), new ResourceLocation("jigsaw:blocks/pig_solution"))

	).explosionResistance(100f)

			.bucket(JigsawModItems.PIG_SOLUTION_FLUID_BUCKET).block(() -> (LiquidBlock) JigsawModBlocks.PIG_SOLUTION_FLUID.get());

	private PigSolutionFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends PigSolutionFluidFluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends PigSolutionFluidFluid {
		public Flowing() {
			super();
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
