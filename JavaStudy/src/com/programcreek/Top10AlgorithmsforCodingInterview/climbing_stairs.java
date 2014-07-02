package com.programcreek.Top10AlgorithmsforCodingInterview;

public class climbing_stairs {

	public int climbStairs(int n){
		if(n==0)
			return 1;
		
		int[] a=new int[n+1];
		
		a[0]=1;
		a[1]=1;
		
		for(int i=2;i<=n;i++){
			a[i]=a[i-1]+a[i-2];
		}
		return a[n];
	}
}
