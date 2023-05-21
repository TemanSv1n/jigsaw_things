
package net.svisvi.jigsaw.fluid;

public abstract class FartgasFluid extends ForgeFlowingFluid {

	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(JigsawModFluids.FARTGAS, JigsawModFluids.FLOWING_FARTGAS,
			FluidAttributes.builder(new ResourceLocation("jigsaw:blocks/fart_gas"), new ResourceLocation("jigsaw:blocks/fart_gas"))

	).explosionResistance(100f)

			.bucket(JigsawModItems.FARTGAS_BUCKET).block(() -> (LiquidBlock) JigsawModBlocks.FARTGAS.get());

	private FartgasFluid() {
		super(PROPERTIES);
	}

	public static class Source extends FartgasFluid {
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

	public static class Flowing extends FartgasFluid {
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
