package com.programcreek.designpatterns;

public class AmericaPresident {

	/*private static final AmericaPresident thePresident=new AmericaPresident();
	
	private static AmericaPresident getPresident(){
		
		return thePresident;
	}*/
	
	
	
	private static AmericaPresident thePresident;
	
	private AmericaPresident(){}
	
	public static AmericaPresident getPresident(){
		if(thePresident==null){
			thePresident=new AmericaPresident();
		}
		return thePresident;
	}
	
}
