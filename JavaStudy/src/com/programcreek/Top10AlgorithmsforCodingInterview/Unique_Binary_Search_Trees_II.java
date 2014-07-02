package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;

public class Unique_Binary_Search_Trees_II {
	/*Unique Binary Search Trees II Total Accepted: 8652 Total Submissions: 32396 My Submissions
	Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.

	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


	OJ's Binary Tree Serialization:
	The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

	Here's an example:
	   1
	  / \
	 2   3
	    /
	   4
	    \
	     5
	The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<TreeNode> generateTrees(int n) {
		return dfs(0, n-1);
	}
	
	public static ArrayList<TreeNode> dfs(int begin, int end){
		ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
		if(begin > end){
			ret.add(null);			// 相当于占位符
			return ret;
		}
		
		for(int i=begin; i<=end; i++){
			ArrayList<TreeNode> left = dfs(begin, i-1);	// left和right至少会有一个元素null！
			ArrayList<TreeNode> right = dfs(i+1, end);
			
			for(int j=0; j<left.size(); j++){			// 因为size至少为1，所以左右都会被访问到
				for(int k=0; k<right.size(); k++){
					TreeNode root = new TreeNode(i+1);		// root node, i+1 因为第一个从1而不是从0开始
					root.left = left.get(j);
					root.right = right.get(k);
					ret.add(root);
				}
			}
		}
		return ret;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
