
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

public class JigsawModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, JigsawMod.MODID);
	public static final RegistryObject<Potion> SHITBOTTLE = REGISTRY.register("shitbottle", () -> new Potion(new MobEffectInstance(JigsawModMobEffects.POOP.get(), 1200, 0, false, true)));
	public static final RegistryObject<Potion> UNLEVITATIONPOTION = REGISTRY.register("unlevitationpotion", () -> new Potion(new MobEffectInstance(JigsawModMobEffects.UNLEVITATION.get(), 1200, 0, false, true)));
	public static final RegistryObject<Potion> PURGATIVESTRONG = REGISTRY.register("purgativestrong",
			() -> new Potion(new MobEffectInstance(JigsawModMobEffects.PURGATIVE.get(), 40, 0, false, true), new MobEffectInstance(JigsawModMobEffects.POOP.get(), 1200, 0, false, true), new MobEffectInstance(MobEffects.POISON, 600, 0, false, true)));
	public static final RegistryObject<Potion> MUTAGEN = REGISTRY.register("mutagen", () -> new Potion(new MobEffectInstance(JigsawModMobEffects.PONOSMUTAGEN.get(), 20, 0, false, true)));
}
