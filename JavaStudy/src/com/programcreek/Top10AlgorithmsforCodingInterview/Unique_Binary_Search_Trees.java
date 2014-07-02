package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Unique_Binary_Search_Trees {

	public static int numTrees(int n){
		int i,j,dp[]=new int[n+1];
		
		if(n==0)return 1;
		
		dp[0]=dp[1]=1;
		
		for(i=2;i<=n;i++){
			dp[i]=0;
			for(j=0;j<i;j++){
				dp[i]+=dp[j]*dp[i-j-1];
			}
		}
		return dp[n];
	}
}
