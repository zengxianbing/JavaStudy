package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Convert_Sorted_Array_to_Binary_Search_Tree {

	public TreeNode sortedArrayToBST(int[] num){
		if(num.length==0)
			return null;
		return sortedArrayToBST(num,0,num.length-1);
	}
	
	public TreeNode sortedArrayToBST(int[] num,int start,
			int end){
		if(start>end)
			return null;
		
		int mid=(start+end)/2;
		TreeNode root=new TreeNode(num[mid]);
		root.left=sortedArrayToBST(num,start,mid-1);
		root.right=sortedArrayToBST(num,mid+1,end);
		return root;
	}
}
