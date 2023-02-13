
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

public class JigsawModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, JigsawMod.MODID);
	public static final RegistryObject<ParticleType<?>> SHIT = REGISTRY.register("shit", () -> new SimpleParticleType(false));
	public static final RegistryObject<ParticleType<?>> POOPCLOUD = REGISTRY.register("poopcloud", () -> new SimpleParticleType(false));
}
