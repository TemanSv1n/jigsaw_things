
package net.svisvi.jigsaw.item;

import net.svisvi.jigsaw.procedures.MagicJarPlayerFinishesUsingItemProcedure;
import net.svisvi.jigsaw.init.JigsawModTabs;
import net.svisvi.jigsaw.init.JigsawModItems;


import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import java.util.Iterator;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.PotionEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;
import net.minecraft.world.item.UseAnim;





public class MagicJarItem extends Item {
	public MagicJarItem() {
		super(new Item.Properties().tab(JigsawModTabs.TAB_JIGSAW).stacksTo(1).rarity(Rarity.UNCOMMON).food((new FoodProperties.Builder()).nutrition(0).saturationMod(0f).alwaysEat()


				.build()));	
	}

		@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		curePotionEffects(entity, itemstack);
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		ItemStack retvalsus = new ItemStack(JigsawModItems.MAGIC_JAR.get());
		
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		MagicJarPlayerFinishesUsingItemProcedure.execute(world, x, y, z, entity, itemstack);
		if (itemstack.isEmpty()) {
			return retvalsus;
		} else {
			if (entity instanceof Player player && !player.getAbilities().instabuild) {
				if (!player.getInventory().add(retvalsus))
					player.drop(retvalsus, false);
			}
			return itemstack;
		}

	}
	private boolean curePotionEffects(LivingEntity entityLiving, ItemStack curativeItem) {
    boolean ret = false;
    Iterator<MobEffectInstance> itr = entityLiving.getActiveEffectsMap().values().iterator();
    while (itr.hasNext()) {
      MobEffectInstance effect = itr.next();
      if (MinecraftForge.EVENT_BUS.post(new PotionEvent.PotionRemoveEvent(entityLiving, effect))) {
        continue;
      }
      if (effect.getEffect().isBeneficial() == false) {
        //dont remove beneficial potions though such as speed, fire prot, night vision 
        effect.getEffect().removeAttributeModifiers(entityLiving, entityLiving.getAttributes(), effect.getAmplifier());
        itr.remove();
        ret = true;
        //entityLiving.effectsDirty = true;
        if (entityLiving instanceof Player) {
          ((Player) entityLiving).getCooldowns().addCooldown(this, 30);
        }
      }
    }
    return ret;
  }
}