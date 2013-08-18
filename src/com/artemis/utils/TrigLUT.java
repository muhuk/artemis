package com.artemis.utils;

// Thanks to Riven
// From: http://riven8192.blogspot.com/2009/08/fastmath-sincos-lookup-tables.html
public class TrigLUT {
	private static final int SIN_BITS = 12;
	private static final int SIN_MASK = ~(-1 << SIN_BITS);
	private static final int SIN_COUNT = SIN_MASK + 1;

	private static final float radFull = (float) (Math.PI * 2.0);
	private static final float radToIndex = SIN_COUNT / radFull;

	private static final float degFull = (float) 360.0;
	private static final float degToIndex = SIN_COUNT / degFull;

	private static final float[] sin = new float[SIN_COUNT];
	private static final float[] cos = new float[SIN_COUNT];

	static {
		for (int i = 0; i < SIN_COUNT; i++) {
			sin[i] = (float) Math.sin((i + 0.5f) / SIN_COUNT * radFull);
			cos[i] = (float) Math.cos((i + 0.5f) / SIN_COUNT * radFull);
		}
	}

	public static final float cos(float rad) {
		return cos[(int) (rad * radToIndex) & SIN_MASK];
	}

	public static final float cosDeg(float deg) {
		return cos[(int) (deg * degToIndex) & SIN_MASK];
	}

	public static void main(String[] args) {
		System.out.println(cos((float) Math.PI));
		System.out.println(cosDeg(180f));
	}

	public static final float sin(float rad) {
		return sin[(int) (rad * radToIndex) & SIN_MASK];
	}

	public static final float sinDeg(float deg) {
		return sin[(int) (deg * degToIndex) & SIN_MASK];
	}
}
