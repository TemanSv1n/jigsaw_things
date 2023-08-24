
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.block.entity.RocketLocatorBlockEntity;
import net.svisvi.jigsaw.block.entity.Beaweedstage4BlockEntity;
import net.svisvi.jigsaw.block.entity.Beaweedstage3BlockEntity;
import net.svisvi.jigsaw.block.entity.Beaweedstage1BlockEntity;
import net.svisvi.jigsaw.block.entity.BeaweedseedsBlockEntity;
import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class JigsawModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, JigsawMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> BEAWEEDSEEDS = register("beaweedseeds", JigsawModBlocks.BEAWEEDSEEDS, BeaweedseedsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BEAWEEDSTAGE_1 = register("beaweedstage_1", JigsawModBlocks.BEAWEEDSTAGE_1, Beaweedstage1BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BEAWEEDSTAGE_3 = register("beaweedstage_3", JigsawModBlocks.BEAWEEDSTAGE_3, Beaweedstage3BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BEAWEEDSTAGE_4 = register("beaweedstage_4", JigsawModBlocks.BEAWEEDSTAGE_4, Beaweedstage4BlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ROCKET_LOCATOR = register("rocket_locator", JigsawModBlocks.ROCKET_LOCATOR, RocketLocatorBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
