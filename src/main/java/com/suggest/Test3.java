package com.suggest;

public class Test3 {

	public static void main(String[] args) {

		//三元操作符的类型必须一致
		int i=80;
		String s1=String.valueOf(i>90?90:100);
		String s2=String.valueOf(i>90?90:100.0);
		System.out.println(s1.equals(s2));
	}
	
	

}
