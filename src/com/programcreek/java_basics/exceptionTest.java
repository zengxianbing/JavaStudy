package com.programcreek.java_basics;

import junit.framework.TestCase;

public class exceptionTest extends TestCase {

	private static Exception exception;
	
	public void test1() throws Exception{
		callDoOne();
	}
	
	
	public static void doOne() throws Exception{
		throw exception;
	}
	
	public static void callDoOne() throws Exception{
		doOne();
	}
}
