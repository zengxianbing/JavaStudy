package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.Arrays;

public class Trapping_Rain_Water {
	/*public static void main(String[] args) {
		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] A = {2,0,2};
		System.out.println(trap(A));
	}

	// 关键是在于找到规律：
	// 即第i块地方的存水量 = min(第i块左边最高的bar高度, 第i块右边最高的bar的高度) - 第i块地方bar的高度
	// 例如图中，第5块地方的存水量 = min(2,3)-0 = 2
	// 2为其左边最高的bar，即第3块地方的bar
	// 3为其右边最高的bar，即第7块地方的bar，
	// 0为其自身的bar高度
	public static int trap(int[] A) {
		if(A.length == 0){
			return 0;
		}
		
		// 先用DP算出left, right数组
		// left数组记录到当前i为止，左边最高的bar
		// right数组记录到当前i为止，右边最高的bar
		int[] left = new int[A.length];
		int[] right = new int[A.length];
		
		left[0] = A[0];
		for(int i=1; i<A.length; i++){
			left[i] = Math.max(left[i-1], A[i]);
		}
		right[A.length-1] = A[A.length-1];
		for(int i=A.length-2; i>=0; i--){
			right[i] = Math.max(right[i+1], A[i]);
		}
		
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		
		int sum = 0;
		for(int i=1; i<A.length-1; i++){
			sum += Math.min(left[i], right[i]) - A[i];
		}
		
		return sum;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int trap(int[] A){
		if(A.length==0){
			return 0;
		}
		int[] left=new int[A.length];
		int[] right=new int[A.length];
		
		left[0]=A[0];
		for(int i=1;i<A.length;i++){
			left[i]=Math.max(left[i-1],A[i]);
		}
		right[A.length-1]=A[A.length-1];
		for(int i=A.length-2;i>=0;i--){
			right[i]=Math.max(right[i+1], A[i]);
		}
		
		int sum=0;
		for(int i=1;i<A.length-1;i++){
			sum+=Math.min(left[i], right[i])-A[i];
		}
		return sum;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
