package com.suggest;

public class Test33 {

	/*
	 * 不要覆写静态方法
	 */
	public static void main(String[] args) {

		Base1 base=new Sub1();
		base.doAnything();
		base.doSomething();
		
	}

}

class Base1{
	public static void doSomething(){
		System.out.println("我是父类静态方法");
	}
	public void doAnything(){
		
		System.out.println("我是父类非静态方法");
	}
}

class Sub1 extends Base1{
	
	public static void doSomething(){
		System.out.println("我是子类静态方法");
	}
	public void doAnything(){
		
		System.out.println("我是子类非静态方法");
	}
}


































