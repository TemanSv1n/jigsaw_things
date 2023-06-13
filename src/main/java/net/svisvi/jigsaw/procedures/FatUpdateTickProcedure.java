package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModBlocks;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class FatUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getFluidState().isSource()) {
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
					if ((world.getFluidState(new BlockPos(x, y, z)).createLegacyBlock()).getBlock() == JigsawModBlocks.FAT.get()) {
						world.setBlock(new BlockPos(x, y, z), JigsawModBlocks.FAT_BLOCK.get().defaultBlockState(), 3);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.extinguish")), SoundSource.BLOCKS, 1, 1, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.ELECTRIC_SPARK, x, y, z, 5, 1, 1.2, 1, 0.2);
					}
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 20);
		}
	}
}
