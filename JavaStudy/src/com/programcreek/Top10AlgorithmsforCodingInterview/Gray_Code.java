package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;

public class Gray_Code {

	public static ArrayList<Integer> grayCode(int n){
		int size=1<<n;
		ArrayList<Integer> ret=new
			ArrayList<Integer>();
		for(int i=0;i<size;i++){
			ret.add(i^(i>>i));
		}
		return ret;
	}
	
	
	
	
	public ArrayList<Integer> grayCode1(int n){
		if(n==0){
			ArrayList<Integer> result=
				new ArrayList<Integer>();
			
			result.add(0);
			return result;
		}
		
		
		ArrayList<Integer> tmp=grayCode(n-1);
		int addNumber=1<<(n-1);
		ArrayList<Integer> result=
		new ArrayList<Integer>(tmp);
		
		for(int i=tmp.size()-1;i>=0;i--){
			result.add(addNumber+tmp.get(i));
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
