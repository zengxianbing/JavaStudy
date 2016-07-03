package com.suggest;

public class Test6 {

	/*
	 * 覆写的方法参数与父类相同，不仅仅是类型、数量，还包括显示形式
	 */
	public static void main(String[] args) {

		Base base=new Sub();
		base.fun(100, 50);
		
	/*	Sub sub=new Sub();
		sub.fun(100, 50);*/
		
		
		
		
	}

	

}
class Base {
	void fun(int price, int... discounts) {
		System.out.println("Base");
	}
}

class Sub extends Base {

	void fun(int price, int[] discounts) {
		System.out.println("Sub");

	}

}
