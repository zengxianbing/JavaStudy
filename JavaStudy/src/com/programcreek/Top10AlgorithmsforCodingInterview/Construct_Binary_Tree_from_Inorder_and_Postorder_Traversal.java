package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

	public TreeNode buildTree(int[] inorder,int[] postorder){
		int inStart=0;
		int inEnd=inorder.length-1;
		int postStart=0;
		int postEnd=postorder.length-1;
		
		return buildTree(inorder,inStart,inEnd,postorder,
				postStart,postEnd);
	}
	
	public TreeNode buildTree(int[] inorder,int inStart,int inEnd,
			int[] postorder,int postStart,int postEnd){
		if(inStart>inEnd||postStart>postEnd)
			return null;
		
		int rootValue=postorder[postEnd];
		TreeNode root=new TreeNode(rootValue);
		
		int k=0;
		for(int i=0;i<inorder.length;i++){
			if(inorder[i]==rootValue){
				k=i;
				break;
			}
		}
		
		root.left=buildTree(inorder,inStart,k-1,postorder,postStart,
				postStart+k-(inStart+1));
		
		root.right=buildTree(inorder,k+1,inEnd,postorder,
				postStart+k-inStart,postEnd-1);
		return root;
	}

}
