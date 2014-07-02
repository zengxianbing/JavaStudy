package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;
import java.util.Stack;

public class OF_BINARY_TREEINORDER_TRAVERSAL {

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
				p=stack.pop();
				lst.add(p.val);
				p=p.right;
			}
		}
		return lst;
	}
}
