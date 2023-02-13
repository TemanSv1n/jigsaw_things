
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import org.lwjgl.glfw.GLFW;

import net.svisvi.jigsaw.network.WbeaverMessage;
import net.svisvi.jigsaw.network.SbeaverMessage;
import net.svisvi.jigsaw.network.MurasamjumpMessage;
import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class JigsawModKeyMappings {
	public static final KeyMapping MURASAMJUMP = new KeyMapping("key.jigsaw.murasamjump", GLFW.GLFW_KEY_SPACE, "key.categories.movement");
	public static final KeyMapping WBEAVER = new KeyMapping("key.jigsaw.wbeaver", GLFW.GLFW_KEY_W, "key.categories.misc");
	public static final KeyMapping SBEAVER = new KeyMapping("key.jigsaw.sbeaver", GLFW.GLFW_KEY_S, "key.categories.misc");
	private static long MURASAMJUMP_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(MURASAMJUMP);
		ClientRegistry.registerKeyBinding(WBEAVER);
		ClientRegistry.registerKeyBinding(SBEAVER);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == MURASAMJUMP.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						MURASAMJUMP_LASTPRESS = System.currentTimeMillis();
					} else if (event.getAction() == GLFW.GLFW_RELEASE) {
						int dt = (int) (System.currentTimeMillis() - MURASAMJUMP_LASTPRESS);
						JigsawMod.PACKET_HANDLER.sendToServer(new MurasamjumpMessage(1, dt));
						MurasamjumpMessage.pressAction(Minecraft.getInstance().player, 1, dt);
					}
				}
				if (event.getKey() == WBEAVER.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						JigsawMod.PACKET_HANDLER.sendToServer(new WbeaverMessage(0, 0));
						WbeaverMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
				if (event.getKey() == SBEAVER.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						JigsawMod.PACKET_HANDLER.sendToServer(new SbeaverMessage(0, 0));
						SbeaverMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
