
package net.svisvi.jigsaw.block;

import net.svisvi.jigsaw.procedures.PonosMobplayerCollidesBlockProcedure;
import net.svisvi.jigsaw.init.JigsawModFluids;

import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class PonosBlock extends LiquidBlock {
	public PonosBlock() {
		super(() -> (FlowingFluid) JigsawModFluids.PONOS.get(), BlockBehaviour.Properties.of(Material.WATER, MaterialColor.PODZOL).strength(100f)

		);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 50;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 50;
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public void entityInside(BlockState blockstate, Level world, BlockPos pos, Entity entity) {
		super.entityInside(blockstate, world, pos, entity);
		PonosMobplayerCollidesBlockProcedure.execute(entity);
	}
}
