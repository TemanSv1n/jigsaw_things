package net.svisvi.jigsaw.block.entity;

import net.svisvi.jigsaw.init.JigsawModBlockEntities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class Beaweedstage2BlockEntity extends BlockEntity {
	public Beaweedstage2BlockEntity(BlockPos pos, BlockState state) {
		super(JigsawModBlockEntities.BEAWEEDSTAGE_2.get(), pos, state);
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
	}
}
