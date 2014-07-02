package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;
import java.util.Stack;

public class Binary_Tree_Inorder_Traversal {

	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> lst=new ArrayList<Integer>();
		
		if(root==null)
			return lst;
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		
		TreeNode p=root;
		
		while(!stack.empty()||p!=null){
			if(p!=null){
				stack.push(p);
				p=p.left;
			}else{
				TreeNode t=stack.pop();
				lst.add(t.val);
				p=t.right;
			}
		}
		return lst;
	}
}
