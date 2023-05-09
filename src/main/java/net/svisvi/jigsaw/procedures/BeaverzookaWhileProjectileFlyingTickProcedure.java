package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;
import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class BeaverzookaWhileProjectileFlyingTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity) {
		if (immediatesourceentity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double despawn = 0;
		found = false;
		if (despawn >= 20) {
			if (!immediatesourceentity.level.isClientSide())
				immediatesourceentity.discard();
		}
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (!immediatesourceentity.level.isClientSide())
					immediatesourceentity.discard();
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 110);
		immediatesourceentity.setNoGravity(true);
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), x, y, z, 5, 0.1, 0.1, 0.1, 0);
		sx = -3;
		found = false;
		for (int index0 = 0; index0 < 6; index0++) {
			sy = -3;
			for (int index1 = 0; index1 < 6; index1++) {
				sz = -3;
				for (int index2 = 0; index2 < 6; index2++) {
					if (!((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == JigsawModBlocks.BEAVERGUNPOWDERBARREL.get())
							&& !((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == JigsawModBlocks.GUNPOWDERBARREL.get())
							&& !((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == JigsawModBlocks.SAFEGUNPOWDERBARREL.get())
							&& !(world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("forge:barrels/wooden")))
							&& !(world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).is(BlockTags.create(new ResourceLocation("forge:chests/wooden")))
							&& ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.WOOD
									|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.LEAVES
									|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.PLANT
									|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.REPLACEABLE_PLANT
									|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.NETHER_WOOD
									|| (world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getMaterial() == net.minecraft.world.level.material.Material.REPLACEABLE_FIREPROOF_PLANT)) {
						world.setBlock(new BlockPos(x + sx, y + sy, z + sz), Blocks.AIR.defaultBlockState(), 3);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CRIT, (x + sx), (y + sy), (z + sz), 2, 0.1, 0.1, 0.1, 0);
						despawn = despawn + 1;
					} else if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == JigsawModBlocks.GUNPOWDERBARREL.get()) {
						GunpowderbarrelOnBlockRightClickedProcedure.execute(world, (x + sx), (y + sy), (z + sz));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CRIT, (x + sx), (y + sy), (z + sz), 2, 0.1, 0.1, 0.1, 0);
						despawn = despawn + 1;
					} else if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == JigsawModBlocks.SAFEGUNPOWDERBARREL.get()) {
						SafegunpowderbarrelOnBlockRightClickedProcedure.execute(world, (x + sx), (y + sy), (z + sz));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CRIT, (x + sx), (y + sy), (z + sz), 2, 0.1, 0.1, 0.1, 0);
						despawn = despawn + 1;
					} else if ((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock() == JigsawModBlocks.BEAVERGUNPOWDERBARREL.get()) {
						BeavergunpowderbarrelrightclickProcedure.execute(world, (x + sx), (y + sy), (z + sz));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.step")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.wood.step")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CRIT, (x + sx), (y + sy), (z + sz), 2, 0.1, 0.1, 0.1, 0);
						despawn = despawn + 1;
					}
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
