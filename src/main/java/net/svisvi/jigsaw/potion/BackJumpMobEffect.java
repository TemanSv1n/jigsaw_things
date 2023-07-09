
package net.svisvi.jigsaw.potion;

import net.svisvi.jigsaw.procedures.BackJumpEffectExpiresProcedure;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BackJumpMobEffect extends MobEffect {
	public BackJumpMobEffect() {
		super(MobEffectCategory.NEUTRAL, -13261);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jigsaw.back_jump";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyInstantenousEffect(Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		BackJumpEffectExpiresProcedure.execute(entity, amplifier);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		BackJumpEffectExpiresProcedure.execute(entity, amplifier);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		BackJumpEffectExpiresProcedure.execute(entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
