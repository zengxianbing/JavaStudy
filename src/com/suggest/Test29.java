package com.suggest;

public class Test29 {

	/*
	 * 优先选择基本类型
	 */
	public static void main(String[] args) {

		int i = 140;
		f(i);
		f(Integer.valueOf(i));

	}

	public static void f(long a) {

	}

	public static void f(Long a) {

	}

}
