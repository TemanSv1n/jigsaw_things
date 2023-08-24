
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.JetstreamChairEmergencyEntitySwingsItemProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;

import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

public class JetstreamChairEmergencyItem extends Item {
	public JetstreamChairEmergencyItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(1).rarity(Rarity.EPIC));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BLOCK;
	}

	@Override
	public boolean onEntitySwing(ItemStack itemstack, LivingEntity entity) {
		boolean retval = super.onEntitySwing(itemstack, entity);
		JetstreamChairEmergencyEntitySwingsItemProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}
}
