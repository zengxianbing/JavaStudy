package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;
import java.util.Stack;

public class Binary_Tree_Preorder_Traversal {
 
	
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> returnList=new ArrayList<Integer>();
		
		if(root==null)
	         return returnList;
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.empty()){
			TreeNode n=stack.pop();
			returnList.add(n.val);
			
			if(n.right!=null)
				stack.push(n.right);
			if(n.left!=null)
				stack.push(n.left);
			
			
		
		}
	return returnList;
	} 
	
}
