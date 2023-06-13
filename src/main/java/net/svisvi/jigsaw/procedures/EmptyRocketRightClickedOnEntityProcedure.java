package net.svisvi.jigsaw.procedures;

import org.checkerframework.checker.units.qual.s;

import net.svisvi.jigsaw.init.JigsawModItems;
import net.svisvi.jigsaw.init.JigsawModEntities;
import net.svisvi.jigsaw.entity.PoopsRocketEntity;
import net.svisvi.jigsaw.entity.EmptyRocketEntity;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.core.BlockPos;

public class EmptyRocketRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		double iindex1 = 0;
		String str1 = "";
		String Xdst = "";
		String Zdst = "";
		boolean xdst_c = false;
		boolean zdst_c = false;
		if (entity.getPersistentData().getBoolean("fused") == false) {
			if (sourceentity.isShiftKeyDown()) {
				if (entity instanceof EmptyRocketEntity) {
					if (itemstack.getItem() == JigsawModItems.POOPS.get()) {
						str1 = (itemstack.getDisplayName().getString()).substring((int) 1, (int) ((itemstack.getDisplayName().getString()).length() - 1));
						if (str1.contains(",")) {
							iindex1 = str1.indexOf(',');
							Xdst = str1.substring((int) 0, (int) iindex1);
							Zdst = str1.substring((int) (iindex1 + 1), (int) (str1).length());
							try {
								Double.parseDouble(Xdst);
								xdst_c = true;
							} catch (NumberFormatException e) {
								xdst_c = false;
							}
							try {
								Double.parseDouble(Zdst);
								zdst_c = true;
							} catch (NumberFormatException e) {
								zdst_c = false;
							}
							if ((xdst_c && zdst_c) == true) {
								if (world instanceof ServerLevel _serverLevel) {
									Entity _spawnentity = new PoopsRocketEntity(JigsawModEntities.POOPS_ROCKET.get(), _serverLevel);
									_spawnentity.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
									_spawnentity.getPersistentData().putDouble("xdst", new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(Xdst));
									_spawnentity.getPersistentData().putDouble("zdst", new Object() {
										double convert(String s) {
											try {
												return Double.parseDouble(s.trim());
											} catch (Exception e) {
											}
											return 0;
										}
									}.convert(Zdst));
									_spawnentity.setCustomName(new TextComponent((entity.getDisplayName().getString())));
									if (_spawnentity instanceof LivingEntity _entity)
										_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1);
									{
										Entity _ent = _spawnentity;
										_ent.setYRot(entity.getYRot());
										_ent.setXRot(entity.getXRot());
										_ent.setYBodyRot(_ent.getYRot());
										_ent.setYHeadRot(_ent.getYRot());
										_ent.yRotO = _ent.getYRot();
										_ent.xRotO = _ent.getXRot();
										if (_ent instanceof LivingEntity _entity) {
											_entity.yBodyRotO = _entity.getYRot();
											_entity.yHeadRotO = _entity.getYRot();
										}
									}
									_spawnentity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
									if (sourceentity instanceof Player _player && !_player.level.isClientSide())
										_player.displayClientMessage(
												new TextComponent((("var " + "xdst" + " = " + str1.substring((int) 0, (int) iindex1)) + "" + ("; var " + "zdst" + " = " + str1.substring((int) (iindex1 + 1), (int) (str1).length())))), (true));
									if (_spawnentity instanceof Mob _spawnmob)
										_spawnmob.finalizeSpawn(_serverLevel, world.getCurrentDifficultyAt(_spawnentity.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
									world.addFreshEntity(_spawnentity);
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, 1, -1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.experience_orb.pickup")), SoundSource.PLAYERS, 1, -1, false);
									}
								}
								if (!entity.level.isClientSide())
									entity.discard();
								(itemstack).shrink(1);
							} else {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.PLAYERS, 1, -1);
									} else {
										_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.PLAYERS, 1, -1, false);
									}
								}
							}
						} else {
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.PLAYERS, 1, -1);
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.land")), SoundSource.PLAYERS, 1, -1, false);
								}
							}
						}
					}
				}
			}
		}
	}
}
