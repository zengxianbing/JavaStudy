package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.Stack;

public class FLATTEN_BINARY_TREE_TO_LINKED_LIST {

	
	public void flatten(TreeNode root){
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode p=root;
		
		while(p!=null||!stack.empty()){
			if(p.right!=null){
				stack.push(p.right);
			}
			
			if(p.left!=null){
				p.right=p.left;
				p.left=null;
			}else if(!stack.empty()){
				TreeNode temp=stack.pop();
				p.right=temp;
				
				
			}
			p=p.right;
		}
	}
}
