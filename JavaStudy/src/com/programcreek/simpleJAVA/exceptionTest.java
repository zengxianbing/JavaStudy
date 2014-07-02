package com.programcreek.simpleJAVA;

class myException extends Exception{}
public class exceptionTest {

	private static Exception exception;
	
	private static myException myexception;
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		callDoOne();
	}
	
	public static void doOne() throws myException{
		throw  myexception;
	}
	
	public static void callDoOne() throws Exception{
		doOne();
		throw exception;
	}

}
