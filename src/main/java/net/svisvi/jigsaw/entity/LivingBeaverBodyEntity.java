
package net.svisvi.jigsaw.entity;

import net.svisvi.jigsaw.procedures.PlayerNotWearingCaptainBeaverHatProcedure;
import net.svisvi.jigsaw.init.JigsawModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;
import net.minecraft.core.BlockPos;

public class LivingBeaverBodyEntity extends Wolf {
	public LivingBeaverBodyEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(JigsawModEntities.LIVING_BEAVER_BODY.get(), world);
	}

	public LivingBeaverBodyEntity(EntityType<LivingBeaverBodyEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, LivingBeaverlegsEntity.class, (float) 9, 1, 1.2));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = LivingBeaverBodyEntity.this.getX();
				double y = LivingBeaverBodyEntity.this.getY();
				double z = LivingBeaverBodyEntity.this.getZ();
				Entity entity = LivingBeaverBodyEntity.this;
				Level world = LivingBeaverBodyEntity.this.level;
				return super.canUse() && PlayerNotWearingCaptainBeaverHatProcedure.execute(world, x, y, z, entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = LivingBeaverBodyEntity.this.getX();
				double y = LivingBeaverBodyEntity.this.getY();
				double z = LivingBeaverBodyEntity.this.getZ();
				Entity entity = LivingBeaverBodyEntity.this;
				Level world = LivingBeaverBodyEntity.this.level;
				return super.canContinueToUse() && PlayerNotWearingCaptainBeaverHatProcedure.execute(world, x, y, z, entity);
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, ShittyBearEntity.class, false, false));
		this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}
		});
		this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(6, new FollowMobGoal(this, (float) 3, 10, 7));
		this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(8, new FloatGoal(this));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie_villager.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.villager.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.llama.death"));
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.2);
		builder = builder.add(Attributes.MAX_HEALTH, 8);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 5);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.19999999999999998);
		return builder;
	}
}
