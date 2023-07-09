package net.svisvi.jigsaw.procedures;

import org.checkerframework.checker.units.qual.s;

public class RotateAroundPointZProcedure {
	public static double execute(double anglee, double cx, double cz, double ppx, double ppz) {
		double s = 0;
		double c = 0;
		double px = 0;
		double pz = 0;
		double xnew = 0;
		double znew = 0;
		s = Math.sin(anglee);
		c = Math.cos(anglee);
		px = ppx - cx;
		pz = ppz - cz;
		xnew = px * c - pz * s;
		znew = px * s + pz * c;
		px = xnew + cx;
		pz = znew + cz;
		return pz;
	}
}
