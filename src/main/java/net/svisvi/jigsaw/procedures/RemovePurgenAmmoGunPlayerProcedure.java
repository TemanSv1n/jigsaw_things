package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class RemovePurgenAmmoGunPlayerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(JigsawModItems.PURGEN_AMMO_GUN_SNIPER.get())) : false) {
			if (!(entity.getDisplayName().getString()).equals(" Graph_Bober_IV")) {
				JigsawMod.LOGGER.info(entity.getDisplayName().getString());
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(JigsawModItems.BEAVER_HELMET.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
			if (!(entity.getDisplayName().getString()).equals(" Dev")) {
				JigsawMod.LOGGER.info(entity.getDisplayName().getString());
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(Blocks.CHEST);
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
			}
		}
	}
}
