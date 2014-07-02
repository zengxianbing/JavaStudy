package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;
import java.util.Stack;

public class OFIT_ERATIVE_BINARY_TREE_POS_TORDER {

	
	public ArrayList<Integer> postorderTraversal(TreeNode root){
	ArrayList<Integer> lst=new ArrayList<Integer>();
	
	if(root==null)
		return lst;
	Stack<TreeNode> stack=new Stack<TreeNode>();
	stack.push(root);
	
	
	TreeNode prev=null;
	while(!stack.empty()){
		TreeNode curr=stack.peek();
		
		if(prev==null||prev.left==curr||
				prev.right==curr){
			if(curr.left!=null){
				stack.push(curr.right);
			}else if(curr.right!=null){
				stack.push(curr.right);
			}else{
				stack.pop();
				lst.add(curr.val);
			}
			
		}else if(curr.left==prev){
			if(curr.right!=null){
				stack.push(curr.right);
			}else{
				stack.pop();
				lst.add(curr.val);
			}
		}else if(curr.right==prev){
			stack.pop();
			lst.add(curr.val);
		}
		prev=curr;
		
		
	}
	return lst;
	}
}
