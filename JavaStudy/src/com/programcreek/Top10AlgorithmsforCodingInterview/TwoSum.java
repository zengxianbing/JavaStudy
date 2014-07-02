package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.HashMap;

public class TwoSum {

	public static int[] twoSum(int[] numbers,int target){
		int[] ret=new int[2];
		for(int i=0;i<numbers.length;i++){
			for(int j=i+1;j<numbers.length;j++){
				if(numbers[i]+numbers[j]==target){
					ret[0]=i+1;
					ret[1]=j+1;
				}
			}
			
		}
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int[] twoSum1(int[] numbers,int target){
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();

		int[] result=new int[2];
		for(int i=0;i<numbers.length;i++){
			if(map.containsKey(numbers[i])){
				int index=map.get(numbers[i]);
				result[0]=index+1;
				result[1]=i+1;
			}else{
				map.put(target-numbers[i], i);
			}
		}
		return result;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
