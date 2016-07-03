package com.suggest;

import java.io.Serializable;

public class Test12 {

	public static void main(String[] args) {

	}

}

/*
 * 避免用序列化类在构造函数中为不变量赋值
 * 
 * 
 * 反序列化是final变量在一下情况不会被重新赋值： 通过构造函数为final变量赋值 通过方法返回值为final变量赋值 final修饰的属性不是基本类型
 */
class Person implements Serializable {
	private static final long serialVersionUID = 435L;

	public final String name;

	public Person() {
		name = "zxb";
	}
}
