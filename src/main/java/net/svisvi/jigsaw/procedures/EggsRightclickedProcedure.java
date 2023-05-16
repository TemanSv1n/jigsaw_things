package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;
import net.svisvi.jigsaw.init.JigsawModMobEffects;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.EntityDamageSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.Random;
import java.util.List;
import java.util.Comparator;

public class EggsRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		DamageSource egged = new DamageSource("generic");
		boolean holder123 = false;
		double speed = 0;
		double Yaw = 0;
		double xRadius = 0;
		double loop = 0;
		double zRadius = 0;
		double particleAmount = 0;
		double loop_big = 0;
		double speed2 = 0;
		egged = new EntityDamageSource("cramming.player", entity);
		egged = egged.bypassArmor();
		speed = 2;
		speed2 = 1.3;
		Yaw = entity.getYRot();
		if (!entity.isShiftKeyDown()) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(JigsawModMobEffects.EGGED.get(), 600, 0, (true), (true)));
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, 5);
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(2, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 80);
			entity.setDeltaMovement(new Vec3((speed * Math.cos((Yaw + 90) * (Math.PI / 180))), (speed * 0.7), (speed * Math.sin((Yaw + 90) * (Math.PI / 180)))));
			loop = 0;
			particleAmount = 64;
			xRadius = 1.5;
			zRadius = 1.5;
			while (loop < particleAmount) {
				world.addParticle((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), (entity.getX() + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (entity.getY() + 0.02),
						(entity.getZ() + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius), 0, 0.05, 0);
				loop = loop + 1;
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(entity.getX(), entity.getY(), entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.PLAYERS, 2, -1);
				} else {
					_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.basalt.break")), SoundSource.PLAYERS, 2, -1, false);
				}
			}
			{
				final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (!(entityiterator == entity)) {
						entityiterator.hurt(egged, 5);
					}
				}
			}
		} else if (entity.isShiftKeyDown()) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 40);
			loop = 0;
			particleAmount = 64;
			xRadius = 2;
			zRadius = 2;
			while (loop < particleAmount) {
				world.addParticle((SimpleParticleType) (JigsawModParticleTypes.SHIT.get()), (x + Math.cos(((Math.PI * 2) / particleAmount) * loop) * xRadius), (entity.getY() + 0.02), (z + Math.sin(((Math.PI * 2) / particleAmount) * loop) * zRadius),
						0, 0.05, 0);
				loop = loop + 1;
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.PLAYERS, 2, -1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.PLAYERS, 2, -1, false);
				}
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
						.collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 3, (false), (false)));
					if (!(entityiterator == entity)) {
						entityiterator.hurt(egged, 7);
						entityiterator.setDeltaMovement(new Vec3((speed2 * Math.cos((Yaw + 90) * (Math.PI / 180))), (speed2 * 0.5), (speed2 * Math.sin((Yaw + 90) * (Math.PI / 180)))));
					}
				}
			}
		}
	}
}
