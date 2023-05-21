
/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.fluid.PonosFluid;
import net.svisvi.jigsaw.fluid.PigSolutionFluidFluid;
import net.svisvi.jigsaw.fluid.FatFluid;
import net.svisvi.jigsaw.fluid.FartgasFluid;
import net.svisvi.jigsaw.fluid.BeaverMassFluid;
import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

public class JigsawModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(ForgeRegistries.FLUIDS, JigsawMod.MODID);
	public static final RegistryObject<Fluid> PONOS = REGISTRY.register("ponos", () -> new PonosFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_PONOS = REGISTRY.register("flowing_ponos", () -> new PonosFluid.Flowing());
	public static final RegistryObject<Fluid> FAT = REGISTRY.register("fat", () -> new FatFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_FAT = REGISTRY.register("flowing_fat", () -> new FatFluid.Flowing());
	public static final RegistryObject<Fluid> BEAVER_MASS = REGISTRY.register("beaver_mass", () -> new BeaverMassFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_BEAVER_MASS = REGISTRY.register("flowing_beaver_mass", () -> new BeaverMassFluid.Flowing());
	public static final RegistryObject<Fluid> FARTGAS = REGISTRY.register("fartgas", () -> new FartgasFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_FARTGAS = REGISTRY.register("flowing_fartgas", () -> new FartgasFluid.Flowing());
	public static final RegistryObject<Fluid> PIG_SOLUTION_FLUID = REGISTRY.register("pig_solution_fluid", () -> new PigSolutionFluidFluid.Source());
	public static final RegistryObject<Fluid> FLOWING_PIG_SOLUTION_FLUID = REGISTRY.register("flowing_pig_solution_fluid", () -> new PigSolutionFluidFluid.Flowing());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(PONOS.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PONOS.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FAT.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FAT.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(BEAVER_MASS.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_BEAVER_MASS.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FARTGAS.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_FARTGAS.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(PIG_SOLUTION_FLUID.get(), renderType -> renderType == RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PIG_SOLUTION_FLUID.get(), renderType -> renderType == RenderType.translucent());
		}
	}
}
