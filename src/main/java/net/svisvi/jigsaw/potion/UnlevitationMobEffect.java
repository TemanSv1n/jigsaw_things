
package net.svisvi.jigsaw.potion;

import net.svisvi.jigsaw.procedures.UnlevitationOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class UnlevitationMobEffect extends MobEffect {
	public UnlevitationMobEffect() {
		super(MobEffectCategory.HARMFUL, -6951705);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jigsaw.unlevitation";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		UnlevitationOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
