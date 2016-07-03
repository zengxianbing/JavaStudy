package com.mainshi;

import java.util.Properties;

public class qunaerwang7 {

	
	
	static final Properties PROPERTIES=new Properties(System.getProperties());
	
	public static  String getLineSeparator(){
		return PROPERTIES.getProperty("line.separator");
	}
	
	
	public static String getPathSeparator(){
		return PROPERTIES.getProperty("path.separator");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		System.out.println("Line separator is:"+qunaerwang7.getLineSeparator());
		System.out.println("Path separator is:"+qunaerwang7.getPathSeparator());
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
