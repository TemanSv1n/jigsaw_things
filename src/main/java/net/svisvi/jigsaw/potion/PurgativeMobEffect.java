
package net.svisvi.jigsaw.potion;

import net.svisvi.jigsaw.procedures.PurgativeOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PurgativeMobEffect extends MobEffect {
	public PurgativeMobEffect() {
		super(MobEffectCategory.HARMFUL, -15134203);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jigsaw.purgative";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PurgativeOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
