
package net.svisvi.jigsaw.potion;

import net.svisvi.jigsaw.procedures.EggedOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class EggedMobEffect extends MobEffect {
	public EggedMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10743135);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jigsaw.egged";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		EggedOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
