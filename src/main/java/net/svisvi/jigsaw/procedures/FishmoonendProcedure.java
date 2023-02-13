package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.network.JigsawModVariables;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FishmoonendProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.world);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world instanceof Level _lvl && _lvl.isDay() && JigsawModVariables.WorldVariables.get(world).fish_moon == true) {
			JigsawModVariables.WorldVariables.get(world).fish_moon = false;
			JigsawModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
