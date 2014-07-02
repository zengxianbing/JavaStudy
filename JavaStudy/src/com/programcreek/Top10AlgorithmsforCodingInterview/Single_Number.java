package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Single_Number {

	public int singleNumber(int[] A){
		int x=0;
		
		for(int a:A){
			x=x^a;
		}
		return x;
	}
}
