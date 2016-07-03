package com.suggest;

import static java.lang.Double.*;
import static java.lang.Math.*;
import static java.lang.Integer.*;
import static java.text.NumberFormat.*;

import java.text.NumberFormat;

public class Test9 {

	/*
	 * 不使用*通配符静态导入
	 * 方法名是具有明确、清晰表象意义的工具类
	 */
	public static void main(String[] args) {

		double s = PI * parseDouble(args[0]);
		NumberFormat nf = getInstance();
		nf.setMaximumFractionDigits(parseInt(args[1]));
		formatMessage(nf.format(s));

	}

	public static void formatMessage(String s) {
		System.out.println("圆的面积：" + s);
	}

}
