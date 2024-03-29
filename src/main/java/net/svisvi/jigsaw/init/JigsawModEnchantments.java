
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.enchantment.SruciblechargeEnchantment;
import net.svisvi.jigsaw.enchantment.ImmovableEnchantment;
import net.svisvi.jigsaw.enchantment.ArmorSlotEnchantment;
import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

public class JigsawModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, JigsawMod.MODID);
	public static final RegistryObject<Enchantment> IMMOVABLE = REGISTRY.register("immovable", () -> new ImmovableEnchantment());
	public static final RegistryObject<Enchantment> SRUCIBLECHARGE = REGISTRY.register("sruciblecharge", () -> new SruciblechargeEnchantment());
	public static final RegistryObject<Enchantment> ARMOR_SLOT = REGISTRY.register("armor_slot", () -> new ArmorSlotEnchantment());
}
