package com.programcreek.designpattern;

class AmericalPresident {
	private static final AmericalPresident thePresident = new AmericalPresident();

	private AmericalPresident() {
	}

	public static AmericalPresident getPresident() {
		return thePresident;
	}
}

public class Singleton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
