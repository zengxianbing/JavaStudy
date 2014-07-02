package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Jump_Game {

	/*public boolean canJump(int[] A){
		if(A.length<=1)
			return true;
		
		if(A[0]>=(A.length-1))
			return true;
		
		int maxLength=A[0];
		if(maxLength==0)
			return false;
		
		for(int i=1;i<A.length-1;i++){
			if(maxLength>=1&&(i+A[i])>=A.length-1)
				return true;
			
			if(maxLength<=i&&A[i]==0)
				return false;
			
			if((i+A[i])>maxLength)
				maxLength=i+A[i];
		}
		return false;
	} */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public boolean canJump(int[] A){
		int n=A.length;
		int maxStep=0;
		for(int i=0;i<n;i++){
			if(maxStep>=n-1)
				return true;
			if(i>maxStep)
				return false;
			maxStep=Math.max(i+A[i], maxStep);
					
		}
		return true;
	} */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean canJump(int[] A){
		int len=A.length;
		int minJump=len-1;
		for(int i=len-2;i>=0;i--){
			if(A[i]>minJump-i){
				minJump=i;
			}
		}
		return minJump==0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
