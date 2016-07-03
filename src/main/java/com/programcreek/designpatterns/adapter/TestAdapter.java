package com.programcreek.designpatterns.adapter;

class Apple {
	public void getAColor(String str) {
		System.out.println("Apple color is: " + str);
	}
}

class Orange {
	public void getOColor(String str) {
		System.out.println("Orange color is: " + str);
	}
}

class AppleAdapter extends Apple {
	private Orange orange;

	public AppleAdapter(Orange orange) {
		super();
		this.orange = orange;
	}

	public void getAColor(String str) {
		orange.getOColor(str);
	}
}

public class TestAdapter {
	public static void main(String[] args) {

		Apple apple1 = new Apple();
		Apple apple12 = new Apple();
		apple1.getAColor("green");

		Orange orange = new Orange();
		AppleAdapter aa = new AppleAdapter(orange);
		aa.getAColor("red");

	}
}
