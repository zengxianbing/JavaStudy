package com.programcreek.simpleJAVA;

class Super{
	String s="Super";
}

class Sub extends Super{
	String s="Sub";
}
public class FieldOverride {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Sub c1=new Sub();
		System.out.println(c1.s);
		Super c2=new Sub();
		System.out.println(c2.s);
		System.out.println(((Super)c1).s);
	}

}
