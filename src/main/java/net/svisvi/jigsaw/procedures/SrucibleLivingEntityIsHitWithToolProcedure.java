package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModEnchantments;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import java.util.Random;
import java.util.Map;

public class SrucibleLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		DamageSource srucible = new DamageSource("generic");
		double level = 0;
		srucible = new EntityDamageSource("generic.player", sourceentity);
		srucible = srucible.bypassArmor();
		srucible = srucible.damageHelmet();
		if (entity.isOnFire() || entity.fireImmune() || entity.isInLava() || (entity.level.dimension()) == (Level.NETHER)) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.DAMAGE_INDICATOR, (entity.getX()), (entity.getY()), (entity.getZ()), 30, 0.5, 0.5, 0.5, 0.1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.crit")), SoundSource.PLAYERS, 1, -1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.crit")), SoundSource.PLAYERS, 1, -1, false);
				}
			}
			entity.hurt(srucible, Mth.nextInt(new Random(), 1, 3));
		}
		if (sourceentity.isShiftKeyDown()) {
			if (EnchantmentHelper.getItemEnchantmentLevel(JigsawModEnchantments.SRUCIBLECHARGE.get(), itemstack) != 0) {
				if (EnchantmentHelper.getItemEnchantmentLevel(JigsawModEnchantments.SRUCIBLECHARGE.get(), itemstack) > 1) {
					level = EnchantmentHelper.getItemEnchantmentLevel(JigsawModEnchantments.SRUCIBLECHARGE.get(), itemstack);
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(JigsawModEnchantments.SRUCIBLECHARGE.get())) {
							_enchantments.remove(JigsawModEnchantments.SRUCIBLECHARGE.get());
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					(itemstack).enchant(JigsawModEnchantments.SRUCIBLECHARGE.get(), (int) (level - 1));
					entity.hurt(srucible, Mth.nextInt(new Random(), 60, 80));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.5, 0.5, 0.5, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.cure")), SoundSource.PLAYERS, 1, -1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.cure")), SoundSource.PLAYERS, 1, -1, false);
						}
					}
				} else if (EnchantmentHelper.getItemEnchantmentLevel(JigsawModEnchantments.SRUCIBLECHARGE.get(), itemstack) == 1) {
					{
						Map<Enchantment, Integer> _enchantments = EnchantmentHelper.getEnchantments(itemstack);
						if (_enchantments.containsKey(JigsawModEnchantments.SRUCIBLECHARGE.get())) {
							_enchantments.remove(JigsawModEnchantments.SRUCIBLECHARGE.get());
							EnchantmentHelper.setEnchantments(_enchantments, itemstack);
						}
					}
					entity.hurt(srucible, Mth.nextInt(new Random(), 60, 80));
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entity.getX()), (entity.getY()), (entity.getZ()), 100, 0.5, 0.5, 0.5, 0.1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.cure")), SoundSource.PLAYERS, 1, -1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.cure")), SoundSource.PLAYERS, 1, -1, false);
						}
					}
				}
			}
		}
	}
}
