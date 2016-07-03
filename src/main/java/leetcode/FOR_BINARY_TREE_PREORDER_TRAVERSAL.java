package leetcode;

import java.util.ArrayList;
import java.util.Stack;

public class FOR_BINARY_TREE_PREORDER_TRAVERSAL {

	
	
	
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> returnList=new ArrayList<Integer>();
		
		if(root==null)
			return returnList;
		
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
			TreeNode n=stack.pop();
			
			returnList.add(n.val);
			
			if(n.right!=null){
				stack.push(n.right);
			}
			
			
			if(n.left!=null){
				stack.push(n.left);
			}
		}
		
		return returnList;
	}
}
