
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.entity.SupershotgunprEntity;
import net.svisvi.jigsaw.entity.SplashponosmutagenEntity;
import net.svisvi.jigsaw.entity.SniperBeaverEntity;
import net.svisvi.jigsaw.entity.ShittybeeEntity;
import net.svisvi.jigsaw.entity.ShittyBearEntity;
import net.svisvi.jigsaw.entity.ShitgrenadeEntity;
import net.svisvi.jigsaw.entity.ShitAmmoGunEntity;
import net.svisvi.jigsaw.entity.RickrollgunEntity;
import net.svisvi.jigsaw.entity.RadioBeaverEntity;
import net.svisvi.jigsaw.entity.PurgenmanEntity;
import net.svisvi.jigsaw.entity.PurgengunEntity;
import net.svisvi.jigsaw.entity.PurgenammogunEntity;
import net.svisvi.jigsaw.entity.PurgenAmmoGunSniperEntity;
import net.svisvi.jigsaw.entity.PudgehookEntity;
import net.svisvi.jigsaw.entity.PoopsEntity;
import net.svisvi.jigsaw.entity.PoopemitterEntity;
import net.svisvi.jigsaw.entity.LivingBeaverlegsEntity;
import net.svisvi.jigsaw.entity.LivingBeaverEntity;
import net.svisvi.jigsaw.entity.LivingBeaverBodyEntity;
import net.svisvi.jigsaw.entity.JetstreamchairEntity;
import net.svisvi.jigsaw.entity.CursedCowEntity;
import net.svisvi.jigsaw.entity.BeaweednutconsumableEntity;
import net.svisvi.jigsaw.entity.BeaverzookaEntity;
import net.svisvi.jigsaw.entity.BeaverbombEntity;
import net.svisvi.jigsaw.JigsawMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class JigsawModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITIES, JigsawMod.MODID);
	public static final RegistryObject<EntityType<RickrollgunEntity>> RICKROLLGUN = register("projectile_rickrollgun",
			EntityType.Builder.<RickrollgunEntity>of(RickrollgunEntity::new, MobCategory.MISC).setCustomClientFactory(RickrollgunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<CursedCowEntity>> CURSED_COW = register("cursed_cow",
			EntityType.Builder.<CursedCowEntity>of(CursedCowEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(CursedCowEntity::new)

					.sized(0.9f, 1.4f));
	public static final RegistryObject<EntityType<PurgengunEntity>> PURGENGUN = register("projectile_purgengun",
			EntityType.Builder.<PurgengunEntity>of(PurgengunEntity::new, MobCategory.MISC).setCustomClientFactory(PurgengunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShitAmmoGunEntity>> SHIT_AMMO_GUN = register("projectile_shit_ammo_gun",
			EntityType.Builder.<ShitAmmoGunEntity>of(ShitAmmoGunEntity::new, MobCategory.MISC).setCustomClientFactory(ShitAmmoGunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PurgenammogunEntity>> PURGENAMMOGUN = register("projectile_purgenammogun",
			EntityType.Builder.<PurgenammogunEntity>of(PurgenammogunEntity::new, MobCategory.MISC).setCustomClientFactory(PurgenammogunEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BeaverbombEntity>> BEAVERBOMB = register("projectile_beaverbomb",
			EntityType.Builder.<BeaverbombEntity>of(BeaverbombEntity::new, MobCategory.MISC).setCustomClientFactory(BeaverbombEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<ShittybeeEntity>> SHITTYBEE = register("shittybee",
			EntityType.Builder.<ShittybeeEntity>of(ShittybeeEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShittybeeEntity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<ShittyBearEntity>> SHITTY_BEAR = register("shitty_bear",
			EntityType.Builder.<ShittyBearEntity>of(ShittyBearEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(ShittyBearEntity::new)

					.sized(0.7999999999999999f, 2.3000000000000003f));
	public static final RegistryObject<EntityType<LivingBeaverEntity>> LIVING_BEAVER = register("living_beaver",
			EntityType.Builder.<LivingBeaverEntity>of(LivingBeaverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LivingBeaverEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<SplashponosmutagenEntity>> SPLASHPONOSMUTAGEN = register("projectile_splashponosmutagen", EntityType.Builder.<SplashponosmutagenEntity>of(SplashponosmutagenEntity::new, MobCategory.MISC)
			.setCustomClientFactory(SplashponosmutagenEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SniperBeaverEntity>> SNIPER_BEAVER = register("sniper_beaver",
			EntityType.Builder.<SniperBeaverEntity>of(SniperBeaverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(SniperBeaverEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PurgenAmmoGunSniperEntity>> PURGEN_AMMO_GUN_SNIPER = register("projectile_purgen_ammo_gun_sniper", EntityType.Builder.<PurgenAmmoGunSniperEntity>of(PurgenAmmoGunSniperEntity::new, MobCategory.MISC)
			.setCustomClientFactory(PurgenAmmoGunSniperEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PurgenmanEntity>> PURGENMAN = register("purgenman",
			EntityType.Builder.<PurgenmanEntity>of(PurgenmanEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PurgenmanEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<LivingBeaverlegsEntity>> LIVING_BEAVERLEGS = register("living_beaverlegs",
			EntityType.Builder.<LivingBeaverlegsEntity>of(LivingBeaverlegsEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LivingBeaverlegsEntity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<LivingBeaverBodyEntity>> LIVING_BEAVER_BODY = register("living_beaver_body",
			EntityType.Builder.<LivingBeaverBodyEntity>of(LivingBeaverBodyEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(LivingBeaverBodyEntity::new)

					.sized(0.6f, 1f));
	public static final RegistryObject<EntityType<BeaverzookaEntity>> BEAVERZOOKA = register("projectile_beaverzooka",
			EntityType.Builder.<BeaverzookaEntity>of(BeaverzookaEntity::new, MobCategory.MISC).setCustomClientFactory(BeaverzookaEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<JetstreamchairEntity>> JETSTREAMCHAIR = register("jetstreamchair",
			EntityType.Builder.<JetstreamchairEntity>of(JetstreamchairEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(JetstreamchairEntity::new)

					.sized(0.7f, 1.0999999999999999f));
	public static final RegistryObject<EntityType<ShitgrenadeEntity>> SHITGRENADE = register("projectile_shitgrenade",
			EntityType.Builder.<ShitgrenadeEntity>of(ShitgrenadeEntity::new, MobCategory.MISC).setCustomClientFactory(ShitgrenadeEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PoopemitterEntity>> POOPEMITTER = register("poopemitter", EntityType.Builder.<PoopemitterEntity>of(PoopemitterEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(0).setUpdateInterval(3).setCustomClientFactory(PoopemitterEntity::new).fireImmune().sized(0f, 0f));
	public static final RegistryObject<EntityType<RadioBeaverEntity>> RADIO_BEAVER = register("radio_beaver",
			EntityType.Builder.<RadioBeaverEntity>of(RadioBeaverEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(RadioBeaverEntity::new)

					.sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PudgehookEntity>> PUDGEHOOK = register("projectile_pudgehook",
			EntityType.Builder.<PudgehookEntity>of(PudgehookEntity::new, MobCategory.MISC).setCustomClientFactory(PudgehookEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<BeaweednutconsumableEntity>> BEAWEEDNUTCONSUMABLE = register("projectile_beaweednutconsumable", EntityType.Builder.<BeaweednutconsumableEntity>of(BeaweednutconsumableEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BeaweednutconsumableEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<SupershotgunprEntity>> SUPERSHOTGUNPR = register("projectile_supershotgunpr",
			EntityType.Builder.<SupershotgunprEntity>of(SupershotgunprEntity::new, MobCategory.MISC).setCustomClientFactory(SupershotgunprEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<PoopsEntity>> POOPS = register("projectile_poops",
			EntityType.Builder.<PoopsEntity>of(PoopsEntity::new, MobCategory.MISC).setCustomClientFactory(PoopsEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			CursedCowEntity.init();
			ShittybeeEntity.init();
			ShittyBearEntity.init();
			LivingBeaverEntity.init();
			SniperBeaverEntity.init();
			PurgenmanEntity.init();
			LivingBeaverlegsEntity.init();
			LivingBeaverBodyEntity.init();
			JetstreamchairEntity.init();
			PoopemitterEntity.init();
			RadioBeaverEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(CURSED_COW.get(), CursedCowEntity.createAttributes().build());
		event.put(SHITTYBEE.get(), ShittybeeEntity.createAttributes().build());
		event.put(SHITTY_BEAR.get(), ShittyBearEntity.createAttributes().build());
		event.put(LIVING_BEAVER.get(), LivingBeaverEntity.createAttributes().build());
		event.put(SNIPER_BEAVER.get(), SniperBeaverEntity.createAttributes().build());
		event.put(PURGENMAN.get(), PurgenmanEntity.createAttributes().build());
		event.put(LIVING_BEAVERLEGS.get(), LivingBeaverlegsEntity.createAttributes().build());
		event.put(LIVING_BEAVER_BODY.get(), LivingBeaverBodyEntity.createAttributes().build());
		event.put(JETSTREAMCHAIR.get(), JetstreamchairEntity.createAttributes().build());
		event.put(POOPEMITTER.get(), PoopemitterEntity.createAttributes().build());
		event.put(RADIO_BEAVER.get(), RadioBeaverEntity.createAttributes().build());
	}
}
