package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Maximum_Depth_of_Binary_Tree {

	public int maxDepth(TreeNode root){
		if(root==null)
			return 0;
		int nLeftDeep=maxDepth(root.left);
		int nRightDeep=maxDepth(root.right);
		return 1+Math.max(nLeftDeep, nRightDeep);
	}
}

