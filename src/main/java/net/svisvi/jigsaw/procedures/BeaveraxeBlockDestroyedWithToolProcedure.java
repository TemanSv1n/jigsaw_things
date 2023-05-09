package net.svisvi.jigsaw.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.Map;

public class BeaveraxeBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if ((new ItemStack((world.getBlockState(new BlockPos(x, y, z))).getBlock())).is(ItemTags.create(new ResourceLocation("minecraft:logs")))) {
			sx = -3;
			found = false;
			for (int index0 = 0; index0 < 6; index0++) {
				sy = -3;
				for (int index1 = 0; index1 < 6; index1++) {
					sz = -3;
					for (int index2 = 0; index2 < 6; index2++) {
						if ((new ItemStack((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock())).is(ItemTags.create(new ResourceLocation("minecraft:logs")))) {
							if (!(ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock()).toString()).contains("stripped")) {
								world.levelEvent(2001, new BlockPos(x + sx, y + sy, z + sz), Block.getId((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz)))));
								{
									BlockPos _bp = new BlockPos(x + sx, y + sy, z + sz);
									BlockState _bs = ForgeRegistries.BLOCKS.getValue(new ResourceLocation((("stripped_" + (ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock()).toString()).substring(10,
											(int) (ForgeRegistries.BLOCKS.getKey((world.getBlockState(new BlockPos(x + sx, y + sy, z + sz))).getBlock()).toString()).length()))).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState();
									BlockState _bso = world.getBlockState(_bp);
									for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
										Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
										if (_property != null && _bs.getValue(_property) != null)
											try {
												_bs = _bs.setValue(_property, (Comparable) entry.getValue());
											} catch (Exception e) {
											}
									}
									world.setBlock(_bp, _bs, 3);
								}
								{
									ItemStack _ist = itemstack;
									if (_ist.hurt(1, new Random(), null)) {
										_ist.shrink(1);
										_ist.setDamageValue(0);
									}
								}
							}
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
		}
	}
}
