
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.potion.XrenoderingMobEffect;
import net.svisvi.jigsaw.potion.UnlevitationMobEffect;
import net.svisvi.jigsaw.potion.PurgativeMobEffect;
import net.svisvi.jigsaw.potion.PoopMobEffect;
import net.svisvi.jigsaw.potion.PonosmutagenMobEffect;
import net.svisvi.jigsaw.potion.JudgementMobEffect;
import net.svisvi.jigsaw.potion.EggedMobEffect;
import net.svisvi.jigsaw.potion.BeaverSODeffectMobEffect;
import net.svisvi.jigsaw.potion.BackJumpMobEffect;
import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class JigsawModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, JigsawMod.MODID);
	public static final RegistryObject<MobEffect> POOP = REGISTRY.register("poop", () -> new PoopMobEffect());
	public static final RegistryObject<MobEffect> PURGATIVE = REGISTRY.register("purgative", () -> new PurgativeMobEffect());
	public static final RegistryObject<MobEffect> PONOSMUTAGEN = REGISTRY.register("ponosmutagen", () -> new PonosmutagenMobEffect());
	public static final RegistryObject<MobEffect> UNLEVITATION = REGISTRY.register("unlevitation", () -> new UnlevitationMobEffect());
	public static final RegistryObject<MobEffect> BEAVER_SO_DEFFECT = REGISTRY.register("beaver_so_deffect", () -> new BeaverSODeffectMobEffect());
	public static final RegistryObject<MobEffect> EGGED = REGISTRY.register("egged", () -> new EggedMobEffect());
	public static final RegistryObject<MobEffect> JUDGEMENT = REGISTRY.register("judgement", () -> new JudgementMobEffect());
	public static final RegistryObject<MobEffect> BACK_JUMP = REGISTRY.register("back_jump", () -> new BackJumpMobEffect());
	public static final RegistryObject<MobEffect> XRENODERING = REGISTRY.register("xrenodering", () -> new XrenoderingMobEffect());
}
