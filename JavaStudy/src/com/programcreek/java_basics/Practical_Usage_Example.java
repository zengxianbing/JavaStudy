package com.programcreek.java_basics;

import java.util.Random;
 
public class Practical_Usage_Example {

	public static int[] getNRandom(int n,int max){
		Random random=new Random();
		int[] randomArr=new int[n];
		
		for(int j=0;j<n;){
			int thisOne=random.nextInt(max-1);
			
			boolean markDup=false;
			for(int indexRandomArr=0;indexRandomArr<n;
					indexRandomArr++){
				if(randomArr[indexRandomArr]==thisOne){
					markDup=true;
					break;
				}
			}
			
			if(!markDup){
				randomArr[j]=thisOne;
				j++;
			}
		}
		
		return randomArr;
	}
	
	
}
