package net.svisvi.jigsaw.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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

public class SrucibleLivingEntityIsHitWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		DamageSource srucible = new DamageSource("generic");
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
	}
}
