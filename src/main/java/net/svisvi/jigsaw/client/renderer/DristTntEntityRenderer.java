
package net.svisvi.jigsaw.client.renderer;

public class DristTntEntityRenderer extends MobRenderer<DristTntEntityEntity, Modeldrist_tnt<DristTntEntityEntity>> {

	public DristTntEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldrist_tnt(context.bakeLayer(Modeldrist_tnt.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(DristTntEntityEntity entity) {
		return new ResourceLocation("jigsaw:textures/entities/texturetnt.png");
	}

}
