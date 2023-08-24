
package net.svisvi.jigsaw.potion;

import net.svisvi.jigsaw.procedures.XrenoderingOnEffectActiveTickProcedure;
import net.svisvi.jigsaw.procedures.XrenoderingEffectStartedappliedProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class XrenoderingMobEffect extends MobEffect {
	public XrenoderingMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -50688);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jigsaw.xrenodering";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		XrenoderingEffectStartedappliedProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		XrenoderingOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
