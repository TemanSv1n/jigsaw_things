package net.svisvi.jigsaw.procedures;

import net.svisvi.jigsaw.init.JigsawModParticleTypes;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import java.util.Random;

public class LinearProjectorUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double x1 = 0;
		double y1 = 0;
		double z1 = 0;
		double x2 = 0;
		double y2 = 0;
		double z2 = 0;
		double T = 0;
		double Zo = 0;
		double Yo = 0;
		double Xo = 0;
		double Za = 0;
		double Ya = 0;
		double Xa = 0;
		double rangee = 0;
		double lenggth = 0;
		double eSpawn = 0;
		double fSpawn = 0;
		rangee = 6;
		lenggth = 5;
		eSpawn = 6;
		fSpawn = 0;
		while (!(Math.max(Math.abs(y1), Math.abs(y2)) - Math.min(Math.abs(y1), Math.abs(y2)) >= lenggth - 3 || Math.max(Math.abs(x1), Math.abs(x2)) - Math.min(Math.abs(x1), Math.abs(x2)) >= lenggth
				|| Math.max(Math.abs(z1), Math.abs(z2)) - Math.min(Math.abs(z1), Math.abs(z2)) >= lenggth)) {
			x1 = x + Mth.nextDouble(new Random(), rangee * (-1), rangee);
			x2 = x + Mth.nextDouble(new Random(), rangee * (-1), rangee);
			z1 = z + Mth.nextDouble(new Random(), rangee * (-1), rangee);
			z2 = z + Mth.nextDouble(new Random(), rangee * (-1), rangee);
			y1 = y + Mth.nextDouble(new Random(), (rangee - 5) * (-1), rangee - 1);
			y2 = y + Mth.nextDouble(new Random(), (rangee - 5) * (-1), rangee - 1);
		}
		Xo = x1 - x2;
		Yo = y1 - y2;
		Zo = z1 - z2;
		if (Math.floor(x1) <= Math.floor(x2)) {
			if (Math.floor(x1) == Math.floor(x2)) {
				if (Math.floor(y1) == Math.floor(y2)) {
					if (Math.floor(z1) <= Math.floor(z2)) {
						Za = Math.floor(z1) + 0.2;
						while (Za <= Math.floor(z2)) {
							T = (Za - z1) / Zo;
							Ya = y1 + Yo * T;
							Xa = x1 + Xo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.PIG_CUT.get()), Xa, Ya, Za, (int) eSpawn, 0, 0, 0, 0);
							Za = 0.2 + Za;
						}
					} else {
						Za = Math.floor(z2) + 0.2;
						while (Za <= Math.floor(z1)) {
							T = (Za - z1) / Zo;
							Ya = y1 + Yo * T;
							Xa = x1 + Xo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.PIG_CUT.get()), Xa, Ya, Za, (int) eSpawn, 0, 0, 0, 0);
							Za = 0.2 + Za;
						}
					}
				} else {
					if (Math.floor(y1) <= Math.floor(y2)) {
						Ya = Math.floor(y1) + 0.2;
						while (Ya <= Math.floor(y2)) {
							T = (Ya - y1) / Yo;
							Xa = x1 + Xo * T;
							Za = z1 + Zo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.PIG_CUT.get()), Xa, Ya, Za, (int) eSpawn, 0, 0, 0, 0);
							Ya = 0.2 + Ya;
						}
					} else {
						Ya = Math.floor(y2) + 0.2;
						while (Ya <= Math.floor(y1)) {
							T = (Ya - y1) / Yo;
							Xa = x1 + Xo * T;
							Za = z1 + Zo * T;
							if (world instanceof ServerLevel _level)
								_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.PIG_CUT.get()), Xa, Ya, Za, (int) eSpawn, 0, 0, 0, 0);
							Ya = 0.2 + Ya;
						}
					}
				}
			} else {
				Xa = Math.floor(x1) + 0.2;
				while (Xa <= Math.floor(x2)) {
					T = (Xa - x1) / Xo;
					Ya = y1 + Yo * T;
					Za = z1 + Zo * T;
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.PIG_CUT.get()), Xa, Ya, Za, (int) eSpawn, 0, 0, 0, 0);
					Xa = 0.2 + Xa;
				}
			}
		} else {
			Xa = x2 + 0.2;
			while (Xa < Math.floor(x1)) {
				T = (Xa - x1) / Xo;
				Ya = y1 + Yo * T;
				Za = z1 + Zo * T;
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (JigsawModParticleTypes.PIG_CUT.get()), Xa, Ya, Za, (int) eSpawn, 0, 0, 0, 0);
				Xa = 0.2 + Xa;
			}
		}
	}
}
