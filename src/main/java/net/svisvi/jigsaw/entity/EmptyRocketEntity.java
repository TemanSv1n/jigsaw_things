
package net.svisvi.jigsaw.entity;

import net.svisvi.jigsaw.procedures.EmptyRocketRightClickedOnEntityProcedure;
import net.svisvi.jigsaw.procedures.EmptyRocketOnEntityTickUpdateProcedure;
import net.svisvi.jigsaw.procedures.EmptyRocketEntityDiesProcedure;
import net.svisvi.jigsaw.init.JigsawModEntities;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

public class EmptyRocketEntity extends PathfinderMob {
	public EmptyRocketEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(JigsawModEntities.EMPTY_ROCKET.get(), world);
	}

	public EmptyRocketEntity(EntityType<EmptyRocketEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setPathfindingMalus(BlockPathTypes.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (EmptyRocketEntity.this.isInWater())
					EmptyRocketEntity.this.setDeltaMovement(EmptyRocketEntity.this.getDeltaMovement().add(0, 0.005, 0));
				if (this.operation == MoveControl.Operation.MOVE_TO && !EmptyRocketEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - EmptyRocketEntity.this.getX();
					double dy = this.wantedY - EmptyRocketEntity.this.getY();
					double dz = this.wantedZ - EmptyRocketEntity.this.getZ();
					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * EmptyRocketEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
					EmptyRocketEntity.this.setYRot(this.rotlerp(EmptyRocketEntity.this.getYRot(), f, 10));
					EmptyRocketEntity.this.yBodyRot = EmptyRocketEntity.this.getYRot();
					EmptyRocketEntity.this.yHeadRot = EmptyRocketEntity.this.getYRot();
					if (EmptyRocketEntity.this.isInWater()) {
						EmptyRocketEntity.this.setSpeed((float) EmptyRocketEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						EmptyRocketEntity.this.setXRot(this.rotlerp(EmptyRocketEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(EmptyRocketEntity.this.getXRot() * (float) (Math.PI / 180.0));
						EmptyRocketEntity.this.setZza(f3 * f1);
						EmptyRocketEntity.this.setYya((float) (f1 * dy));
					} else {
						EmptyRocketEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					EmptyRocketEntity.this.setSpeed(0);
					EmptyRocketEntity.this.setYya(0);
					EmptyRocketEntity.this.setZza(0);
				}
			}
		};
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

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
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(""));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source.getDirectEntity() instanceof ThrownPotion || source.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (source == DamageSource.FALL)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		if (source == DamageSource.DROWN)
			return false;
		if (source == DamageSource.LIGHTNING_BOLT)
			return false;
		if (source == DamageSource.ANVIL)
			return false;
		if (source == DamageSource.DRAGON_BREATH)
			return false;
		if (source == DamageSource.WITHER)
			return false;
		if (source.getMsgId().equals("witherSkull"))
			return false;
		return super.hurt(source, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		EmptyRocketEntityDiesProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.sidedSuccess(this.level.isClientSide());
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level;

		EmptyRocketRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity, itemstack);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		EmptyRocketOnEntityTickUpdateProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public boolean canBreatheUnderwater() {
		return true;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean isPushedByFluid() {
		return false;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	@Override
	protected void pushEntities() {
	}

	@Override
	public boolean canCollideWith(Entity entity) {
		return true;
	}

	@Override
	public boolean canBeCollidedWith() {
		return true;
	}

	public static void init() {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 10);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 0);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 100);
		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0);
		return builder;
	}
}
