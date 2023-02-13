package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.network.JigsawModVariables;
import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.entity.RadioBeaverEntity;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class MurasamjumpOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double speed = 0;
		double Yaw = 0;
		double speed2 = 0;
		speed2 = 1.3;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.MURASAM.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.MURASAM.get()) {
			if ((world.getBlockState(new BlockPos(x, y - 0.5, z))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
				if ((entity.getCapability(JigsawModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new JigsawModVariables.PlayerVariables())).Allow_Double_Jump == true
						&& ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.MURASAM.get()
								|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == JigsawModItems.MURASAM.get())) {
					if ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) >= 1) {
						speed = 1.5;
						entity.setDeltaMovement(new Vec3((Math.sin(Math.toRadians(entity.getYRot() + 180)) * 0.6), ((Math.sin(Math.toRadians(0 - entity.getXRot())) + 0.4) * speed), (Math.cos(Math.toRadians(entity.getYRot())) * 0.6)));
						if (entity instanceof Player _player)
							_player.getFoodData().setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - 1));
						{
							boolean _setval = false;
							entity.getCapability(JigsawModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
								capability.Allow_Double_Jump = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			}
		} else if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == JigsawModItems.RADIOHAT_HELMET.get()
				&& !world.getEntitiesOfClass(RadioBeaverEntity.class, AABB.ofSize(new Vec3(x, y, z), 128, 128, 128), e -> true).isEmpty()) {
			if (!entity.isShiftKeyDown()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof RadioBeaverEntity) {
							if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == JigsawModItems.RADIOHAT_HELMET.get()
									&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getDisplayName().getString())
											.equals((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getDisplayName().getString())) {
								if (entityiterator.isOnGround()) {
									entityiterator.setDeltaMovement(new Vec3((0.1 * Math.cos((entityiterator.getYRot() + 90) * (Math.PI / 180))), (speed2 * 0.4), (0.1 * Math.sin((entityiterator.getYRot() + 90) * (Math.PI / 180)))));
								}
							}
						}
					}
				}
			} else if (entity.isShiftKeyDown()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(128 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (entityiterator instanceof RadioBeaverEntity) {
							if ((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == JigsawModItems.RADIOHAT_HELMET.get()
									&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getDisplayName().getString())
											.equals((entityiterator instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getDisplayName().getString())) {
								if (entity instanceof Player _player) {
									BlockPos _bp = new BlockPos(entityiterator.level
											.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entityiterator))
											.getBlockPos().getX(),
											entityiterator.level.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getY(),
											entityiterator.level.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getZ());
									_player.level.getBlockState(_bp).use(_player.level, _player, InteractionHand.MAIN_HAND, BlockHitResult.miss(new Vec3(_bp.getX(), _bp.getY(), _bp.getZ()), Direction.UP, _bp));
								}
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.NOTE, (entityiterator.level
											.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entityiterator))
											.getBlockPos().getX()),
											(entityiterator.level.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getY() + 0.5),
											(entityiterator.level.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getZ()),
											5, 0, 0.3, 0, 0);
							}
						}
					}
				}
			}
		}
	}
}
