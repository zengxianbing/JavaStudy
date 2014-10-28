package com.programcreek.simpleJAVA;

public class InstanceInitializer {

	public static void main(String[] args) {

		new Foo();
		new Foo();
	}
}

class Foo {
	String s = "abc";

	public Foo() {
		System.out.println("cons t ruc tor c a l l ed");
	}

	static {
		System.out.println(" s t a t i c i n i t i a l i z e r c a l l ed ");
	}
	{
		System.out.println(" ins t anc e i n i t i a l i z e r c a l l ed ");
	}
}