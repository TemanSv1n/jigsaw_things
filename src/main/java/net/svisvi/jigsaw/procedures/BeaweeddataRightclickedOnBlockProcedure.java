package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

public class BeaweeddataRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos(x, y, z))).getBlock() == JigsawModBlocks.BEAWEEDSEEDS.get() || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == JigsawModBlocks.BEAWEEDSTAGE_1.get()
				|| (world.getBlockState(new BlockPos(x, y, z))).getBlock() == JigsawModBlocks.BEAWEEDSTAGE_3.get() || (world.getBlockState(new BlockPos(x, y, z))).getBlock() == JigsawModBlocks.BEAWEEDSTAGE_4.get()) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("\"age\" = " + "" + (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "counter1")) + " " + "\"required\" = " + (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "rand_gr")))), true);
		}
	}
}
