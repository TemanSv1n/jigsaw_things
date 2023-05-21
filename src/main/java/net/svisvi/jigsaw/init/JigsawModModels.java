
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.svisvi.jigsaw.init;

import net.svisvi.jigsaw.client.model.Modelsubpants;
import net.svisvi.jigsaw.client.model.Modelshit_rocket;
import net.svisvi.jigsaw.client.model.Modelradio_hat;
import net.svisvi.jigsaw.client.model.Modelpoop_smoke_grenade_entity;
import net.svisvi.jigsaw.client.model.Modelonion_Converted;
import net.svisvi.jigsaw.client.model.Modelmerchant_mask;
import net.svisvi.jigsaw.client.model.Modelmaznya_slayer;
import net.svisvi.jigsaw.client.model.Modeljetstream_chair;
import net.svisvi.jigsaw.client.model.Modelhitler_moustache;
import net.svisvi.jigsaw.client.model.Modelfool_bear;
import net.svisvi.jigsaw.client.model.Modeldrist_tnt;
import net.svisvi.jigsaw.client.model.Modelcustom_model;
import net.svisvi.jigsaw.client.model.Modelcaptain_beaver;
import net.svisvi.jigsaw.client.model.Modelbelly;
import net.svisvi.jigsaw.client.model.ModelTeeth;
import net.svisvi.jigsaw.client.model.ModelNanomachines;
import net.svisvi.jigsaw.client.model.ModelFoolBee;
import net.svisvi.jigsaw.client.model.ModelCockBelly;
import net.svisvi.jigsaw.client.model.ModelCock;
import net.svisvi.jigsaw.client.model.ModelClownNoseJoker;
import net.svisvi.jigsaw.client.model.ModelClownNose;
import net.svisvi.jigsaw.client.model.ModelCarrot;
import net.svisvi.jigsaw.client.model.ModelBeaver_legs;
import net.svisvi.jigsaw.client.model.ModelBeaver_hat_proj;
import net.svisvi.jigsaw.client.model.ModelBeaver_hat;
import net.svisvi.jigsaw.client.model.ModelBeaver_boots;
import net.svisvi.jigsaw.client.model.ModelBeaver_body_armor;
import net.svisvi.jigsaw.client.model.ModelBeaver_body;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class JigsawModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelmerchant_mask.LAYER_LOCATION, Modelmerchant_mask::createBodyLayer);
		event.registerLayerDefinition(Modelradio_hat.LAYER_LOCATION, Modelradio_hat::createBodyLayer);
		event.registerLayerDefinition(Modelhitler_moustache.LAYER_LOCATION, Modelhitler_moustache::createBodyLayer);
		event.registerLayerDefinition(ModelBeaver_legs.LAYER_LOCATION, ModelBeaver_legs::createBodyLayer);
		event.registerLayerDefinition(Modelonion_Converted.LAYER_LOCATION, Modelonion_Converted::createBodyLayer);
		event.registerLayerDefinition(Modelmaznya_slayer.LAYER_LOCATION, Modelmaznya_slayer::createBodyLayer);
		event.registerLayerDefinition(Modelsubpants.LAYER_LOCATION, Modelsubpants::createBodyLayer);
		event.registerLayerDefinition(Modelpoop_smoke_grenade_entity.LAYER_LOCATION, Modelpoop_smoke_grenade_entity::createBodyLayer);
		event.registerLayerDefinition(Modeldrist_tnt.LAYER_LOCATION, Modeldrist_tnt::createBodyLayer);
		event.registerLayerDefinition(ModelFoolBee.LAYER_LOCATION, ModelFoolBee::createBodyLayer);
		event.registerLayerDefinition(ModelTeeth.LAYER_LOCATION, ModelTeeth::createBodyLayer);
		event.registerLayerDefinition(ModelCockBelly.LAYER_LOCATION, ModelCockBelly::createBodyLayer);
		event.registerLayerDefinition(ModelNanomachines.LAYER_LOCATION, ModelNanomachines::createBodyLayer);
		event.registerLayerDefinition(ModelClownNoseJoker.LAYER_LOCATION, ModelClownNoseJoker::createBodyLayer);
		event.registerLayerDefinition(ModelBeaver_hat_proj.LAYER_LOCATION, ModelBeaver_hat_proj::createBodyLayer);
		event.registerLayerDefinition(Modelshit_rocket.LAYER_LOCATION, Modelshit_rocket::createBodyLayer);
		event.registerLayerDefinition(Modelfool_bear.LAYER_LOCATION, Modelfool_bear::createBodyLayer);
		event.registerLayerDefinition(ModelCarrot.LAYER_LOCATION, ModelCarrot::createBodyLayer);
		event.registerLayerDefinition(ModelCock.LAYER_LOCATION, ModelCock::createBodyLayer);
		event.registerLayerDefinition(Modeljetstream_chair.LAYER_LOCATION, Modeljetstream_chair::createBodyLayer);
		event.registerLayerDefinition(ModelBeaver_hat.LAYER_LOCATION, ModelBeaver_hat::createBodyLayer);
		event.registerLayerDefinition(ModelBeaver_body.LAYER_LOCATION, ModelBeaver_body::createBodyLayer);
		event.registerLayerDefinition(Modelcustom_model.LAYER_LOCATION, Modelcustom_model::createBodyLayer);
		event.registerLayerDefinition(Modelbelly.LAYER_LOCATION, Modelbelly::createBodyLayer);
		event.registerLayerDefinition(ModelBeaver_body_armor.LAYER_LOCATION, ModelBeaver_body_armor::createBodyLayer);
		event.registerLayerDefinition(Modelcaptain_beaver.LAYER_LOCATION, Modelcaptain_beaver::createBodyLayer);
		event.registerLayerDefinition(ModelBeaver_boots.LAYER_LOCATION, ModelBeaver_boots::createBodyLayer);
		event.registerLayerDefinition(ModelClownNose.LAYER_LOCATION, ModelClownNose::createBodyLayer);
	}
}
