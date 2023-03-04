package net.svisvi.jigsaw.block.entity;

import net.svisvi.jigsaw.init.JigsawModBlockEntities;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class Beaweedstage4BlockEntity extends BlockEntity {
	public Beaweedstage4BlockEntity(BlockPos pos, BlockState state) {
		super(JigsawModBlockEntities.BEAWEEDSTAGE_4.get(), pos, state);
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
