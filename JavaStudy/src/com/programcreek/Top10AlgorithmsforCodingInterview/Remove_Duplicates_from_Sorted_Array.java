package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.Arrays;

public class Remove_Duplicates_from_Sorted_Array {

	public static int removeDuplicatesNative1(int[] A){
		if(A.length<2)
			return A.length;
		int j=0;
		int i=1;
		while(i<A.length){
			if(A[i]==A[j]){
				i++;
			}else{
				j++;
				A[j]=A[i];
				i++;
			}
		}
		return j+1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static int[] removeDuplicates(int[] A){
		if(A.length<2)
			return A;
		int j=0;
		int i=1;
		
		while(i<A.length){
			if(A[i]==A[j]){
				i++;
			}else{
				j++;
				A[j]=A[i];
				i++;
			}
		
		}
		int[] B=Arrays.copyOf(A, j+1);
		return B;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
