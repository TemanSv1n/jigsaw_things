
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JigsawModSounds {
	public static Map<ResourceLocation, SoundEvent> REGISTRY = new HashMap<>();
	static {
		REGISTRY.put(new ResourceLocation("jigsaw", "rickroll"), new SoundEvent(new ResourceLocation("jigsaw", "rickroll")));
		REGISTRY.put(new ResourceLocation("jigsaw", "clown_horn"), new SoundEvent(new ResourceLocation("jigsaw", "clown_horn")));
		REGISTRY.put(new ResourceLocation("jigsaw", "fools_village"), new SoundEvent(new ResourceLocation("jigsaw", "fools_village")));
		REGISTRY.put(new ResourceLocation("jigsaw", "fargus"), new SoundEvent(new ResourceLocation("jigsaw", "fargus")));
		REGISTRY.put(new ResourceLocation("jigsaw", "ponos_sounds"), new SoundEvent(new ResourceLocation("jigsaw", "ponos_sounds")));
		REGISTRY.put(new ResourceLocation("jigsaw", "circus_theme"), new SoundEvent(new ResourceLocation("jigsaw", "circus_theme")));
	}

	@SubscribeEvent
	public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
		for (Map.Entry<ResourceLocation, SoundEvent> sound : REGISTRY.entrySet())
			event.getRegistry().register(sound.getValue().setRegistryName(sound.getKey()));
	}
}
