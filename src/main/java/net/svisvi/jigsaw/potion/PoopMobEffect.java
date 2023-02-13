
package net.svisvi.jigsaw.potion;

import net.svisvi.jigsaw.procedures.PoopOnEffectActiveTickProcedure;
import net.svisvi.jigsaw.procedures.PoopEffectStartedappliedProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PoopMobEffect extends MobEffect {
	public PoopMobEffect() {
		super(MobEffectCategory.HARMFUL, -12372212);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jigsaw.poop";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		PoopEffectStartedappliedProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PoopOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
