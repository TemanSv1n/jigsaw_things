
package net.svisvi.jigsaw.potion;

import net.svisvi.jigsaw.procedures.PonosmutagenOnEffectActiveTickProcedure;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PonosmutagenMobEffect extends MobEffect {
	public PonosmutagenMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -11914995);
	}

	@Override
	public String getDescriptionId() {
		return "effect.jigsaw.ponosmutagen";
	}

	@Override
	public boolean isInstantenous() {
		return true;
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		PonosmutagenOnEffectActiveTickProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
