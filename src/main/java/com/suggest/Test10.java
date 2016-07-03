package com.suggest;

import static java.lang.Math.PI;
import static java.lang.Math.abs;

public class Test10 {

	public final static String PI = "zxb";

	public static int abs(int abs) {
		return 0;
	}

	/*
	 * 不要在本类中覆盖静态导入的变量和方法
	 */
	public static void main(String[] args) {

		System.out.println("PI=" + PI);
		System.out.println("abs(100)" + abs(-100));

	}

}
