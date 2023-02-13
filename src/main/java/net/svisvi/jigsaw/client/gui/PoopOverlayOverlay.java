
package net.svisvi.jigsaw.client.gui;

import org.checkerframework.checker.units.qual.h;

import net.svisvi.jigsaw.procedures.PoopOverlayConditionProcedure;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class PoopOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGameOverlayEvent.Pre event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
			int w = event.getWindow().getGuiScaledWidth();
			int h = event.getWindow().getGuiScaledHeight();
			int posX = w / 2;
			int posY = h / 2;
			Level world = null;
			double x = 0;
			double y = 0;
			double z = 0;
			Player entity = Minecraft.getInstance().player;
			if (entity != null) {
				world = entity.level;
				x = entity.getX();
				y = entity.getY();
				z = entity.getZ();
			}
			RenderSystem.disableDepthTest();
			RenderSystem.depthMask(false);
			RenderSystem.enableBlend();
			RenderSystem.setShader(GameRenderer::getPositionTexShader);
			RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
			RenderSystem.setShaderColor(1, 1, 1, 1);
			if (PoopOverlayConditionProcedure.execute(entity)) {
				RenderSystem.setShaderTexture(0, new ResourceLocation("jigsaw:textures/screens/pumpkinblur_1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), 0, 0, 0, 0, w, h, w, h);
				RenderSystem.setShaderTexture(0, new ResourceLocation("jigsaw:textures/screens/pumpkinblur_1.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -130, posY + -126, 0, 0, 256, 256, 256, 256);

				RenderSystem.setShaderTexture(0, new ResourceLocation("jigsaw:textures/screens/ponos.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + -528, posY + -153, 0, 0, 400, 300, 400, 300);

				RenderSystem.setShaderTexture(0, new ResourceLocation("jigsaw:textures/screens/ponos.png"));
				Minecraft.getInstance().gui.blit(event.getMatrixStack(), posX + 125, posY + -154, 0, 0, 400, 300, 400, 300);

			}
			RenderSystem.depthMask(true);
			RenderSystem.defaultBlendFunc();
			RenderSystem.enableDepthTest();
			RenderSystem.disableBlend();
			RenderSystem.setShaderColor(1, 1, 1, 1);
		}
	}
}
