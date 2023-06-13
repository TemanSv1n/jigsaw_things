
package net.svisvi.jigsaw.fluid;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;
import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.init.JigsawModFluids;
import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.BlockPos;

public abstract class PonosFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(JigsawModFluids.PONOS, JigsawModFluids.FLOWING_PONOS,
			FluidAttributes.builder(new ResourceLocation("jigsaw:blocks/drist_ponos_still"), new ResourceLocation("jigsaw:blocks/drist_ponos_flow"))

					.temperature(400)

					.sound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.bucket.empty_lava"))))
			.explosionResistance(100f)

			.tickRate(8).levelDecreasePerBlock(2).slopeFindDistance(6).bucket(JigsawModItems.PONOS_BUCKET).block(() -> (LiquidBlock) JigsawModBlocks.PONOS.get());

	private PonosFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (JigsawModParticleTypes.SHIT.get());
	}

	@Override
	public Vec3 getFlow(BlockGetter world, BlockPos pos, FluidState fluidstate) {
		return super.getFlow(world, pos, fluidstate).scale(-2);
	}

	public static class Source extends PonosFluid {
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

	public static class Flowing extends PonosFluid {
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
