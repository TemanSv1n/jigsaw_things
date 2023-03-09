
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.client.particle.ShitParticle;
import net.svisvi.jigsaw.client.particle.PoopcloudParticle;
import net.svisvi.jigsaw.client.particle.FlyParticle;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class JigsawModParticles {
	@SubscribeEvent
	public static void registerParticles(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) JigsawModParticleTypes.SHIT.get(), ShitParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) JigsawModParticleTypes.POOPCLOUD.get(), PoopcloudParticle::provider);
		Minecraft.getInstance().particleEngine.register((SimpleParticleType) JigsawModParticleTypes.FLY.get(), FlyParticle::provider);
	}
}
