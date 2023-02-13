
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.client.renderer.SniperBeaverRenderer;
import net.svisvi.jigsaw.client.renderer.ShittybeeRenderer;
import net.svisvi.jigsaw.client.renderer.ShittyBearRenderer;
import net.svisvi.jigsaw.client.renderer.ShitgrenadeRenderer;
import net.svisvi.jigsaw.client.renderer.RadioBeaverRenderer;
import net.svisvi.jigsaw.client.renderer.PurgenmanRenderer;
import net.svisvi.jigsaw.client.renderer.PoopemitterRenderer;
import net.svisvi.jigsaw.client.renderer.LivingBeaverlegsRenderer;
import net.svisvi.jigsaw.client.renderer.LivingBeaverRenderer;
import net.svisvi.jigsaw.client.renderer.LivingBeaverBodyRenderer;
import net.svisvi.jigsaw.client.renderer.JetstreamchairRenderer;
import net.svisvi.jigsaw.client.renderer.CursedCowRenderer;
import net.svisvi.jigsaw.client.renderer.BeaverbombRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JigsawModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(JigsawModEntities.RICKROLLGUN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.CURSED_COW.get(), CursedCowRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.PURGENGUN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.SHIT_AMMO_GUN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.PURGENAMMOGUN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.BEAVERBOMB.get(), BeaverbombRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.SHITTYBEE.get(), ShittybeeRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.SHITTY_BEAR.get(), ShittyBearRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.LIVING_BEAVER.get(), LivingBeaverRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.SPLASHPONOSMUTAGEN.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.SNIPER_BEAVER.get(), SniperBeaverRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.PURGEN_AMMO_GUN_SNIPER.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.PURGENMAN.get(), PurgenmanRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.LIVING_BEAVERLEGS.get(), LivingBeaverlegsRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.LIVING_BEAVER_BODY.get(), LivingBeaverBodyRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.BEAVERZOOKA.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.JETSTREAMCHAIR.get(), JetstreamchairRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.SHITGRENADE.get(), ShitgrenadeRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.POOPEMITTER.get(), PoopemitterRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.RADIO_BEAVER.get(), RadioBeaverRenderer::new);
		event.registerEntityRenderer(JigsawModEntities.PUDGEHOOK.get(), ThrownItemRenderer::new);
	}
}
