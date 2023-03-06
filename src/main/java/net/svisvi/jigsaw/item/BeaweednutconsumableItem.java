
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.BeaweednutconsumableRangedItemUsedProcedure;
import net.svisvi.jigsaw.procedures.BeaweednutconsumableCanUseRangedItemProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;
import net.svisvi.jigsaw.entity.BeaweednutconsumableEntity;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;

public class BeaweednutconsumableItem extends Item {
	public BeaweednutconsumableItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).durability(16));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		entity.startUsingItem(hand);
		return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 72000;
	}

	@Override
	public void releaseUsing(ItemStack itemstack, Level world, LivingEntity entityLiving, int timeLeft) {
		if (!world.isClientSide() && entityLiving instanceof ServerPlayer entity) {
			double x = entity.getX();
			double y = entity.getY();
			double z = entity.getZ();
			if (BeaweednutconsumableCanUseRangedItemProcedure.execute(entity)) {
				BeaweednutconsumableEntity entityarrow = BeaweednutconsumableEntity.shoot(world, entity, world.getRandom(), 0f, 0, 0);
				itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
				entityarrow.pickup = AbstractArrow.Pickup.DISALLOWED;

				BeaweednutconsumableRangedItemUsedProcedure.execute(entity);
			}
		}
	}
}
