package com.suggest;

public class Test35 {

	/*
	 * 避免在构造函数中初始化其他类
	 */
	public static void main(String[] args) {

		Son s=new Son();
		s.doSomething();
	}

}
class Father{
	Father(){
		new Other();
	}
}

class Son extends Father{
	public void doSomething(){
		System.out.println("show me something");
	}
}

class Other{
	public Other(){
		new Son();
	}
}















