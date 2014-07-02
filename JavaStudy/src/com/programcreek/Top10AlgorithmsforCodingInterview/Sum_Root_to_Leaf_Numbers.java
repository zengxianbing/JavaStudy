package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Sum_Root_to_Leaf_Numbers {

	public int sumNumbers(TreeNode root){
		if(root==null)return 0;
		return helper(root,0,0);
	}
	
	
	public int helper(TreeNode node, int num, int sum) {
		if (node == null)
			return sum;

		num = num * 10 + node.val;

		if (node.left == null && node.right == null) {
			sum += num;
			return sum;
		}

		sum = helper(node.left, num, sum) + helper(node.right, num, sum);
		return sum;
	}
}
