
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.DristTntStickRangedItemUsedProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;
import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.entity.DristTntStickEntity;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;

public class DristTntStickItem extends Item {
	public DristTntStickItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(16));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		entity.startUsingItem(hand);
		return new InteractionResultHolder(InteractionResult.SUCCESS, entity.getItemInHand(hand));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.SPEAR;
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
			if (true) {
				ItemStack stack = ProjectileWeaponItem.getHeldProjectile(entity, e -> e.getItem() == JigsawModItems.DRIST_TNT_STICK.get());
				if (stack == ItemStack.EMPTY) {
					for (int i = 0; i < entity.getInventory().items.size(); i++) {
						ItemStack teststack = entity.getInventory().items.get(i);
						if (teststack != null && teststack.getItem() == JigsawModItems.DRIST_TNT_STICK.get()) {
							stack = teststack;
							break;
						}
					}
				}
				if (entity.getAbilities().instabuild || stack != ItemStack.EMPTY) {
					DristTntStickEntity entityarrow = DristTntStickEntity.shoot(world, entity, world.getRandom(), 0.6f, 0.30000000000000004, 0);
					itemstack.hurtAndBreak(1, entity, e -> e.broadcastBreakEvent(entity.getUsedItemHand()));
					if (entity.getAbilities().instabuild) {
						entityarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
					} else {
						if (new ItemStack(JigsawModItems.DRIST_TNT_STICK.get()).isDamageableItem()) {
							if (stack.hurt(1, world.getRandom(), entity)) {
								stack.shrink(1);
								stack.setDamageValue(0);
								if (stack.isEmpty())
									entity.getInventory().removeItem(stack);
							}
						} else {
							stack.shrink(1);
							if (stack.isEmpty())
								entity.getInventory().removeItem(stack);
						}
					}

					DristTntStickRangedItemUsedProcedure.execute(entity, itemstack);
				}
			}
		}
	}
}
