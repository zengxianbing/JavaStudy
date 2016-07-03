package com.suggest;

public class Test37 {

	/*
	 * 构造代码块会想你所想
	 */
	public static void main(String[] args) {

		new Base2();
		new Base2("");
		new Base2(0);
		System.out.println(Base2.getNumOfObjects());

	}

}

class Base2 {
	private static int numOfObjects = 0;
	{
		numOfObjects++;
	}

	public Base2() {
	}

	public Base2(String _str) {
		this();
	}

	public Base2(int _i) {
	}

	public static int getNumOfObjects() {
		return numOfObjects;
	}
}
