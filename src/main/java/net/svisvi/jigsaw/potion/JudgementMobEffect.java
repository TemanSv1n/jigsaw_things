
package net.svisvi.jigsaw.potion;

import net.svisvi.jigsaw.procedures.JudgementOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class JudgementMobEffect extends MobEffect {
	public JudgementMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -13408513);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jigsaw.judgement";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		JudgementOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
