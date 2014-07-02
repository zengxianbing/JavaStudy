package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Valid_Number {

	
	
	public boolean isNumber(String s){
		if(s.trim().isEmpty())
			return false;
		
		String regex="[-+]?(\\d+\\.?|\\.\\d+)\\d*(e[-+]?\\d+)?";
		if(s.trim().matches(regex))
			return true;
		else
			return false;
		
	}
}
