package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal {

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (root == null)
			return result;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		queue.add(root);

		while (!queue.isEmpty()) {
			ArrayList<TreeNode> tempList = new ArrayList<TreeNode>();
			ArrayList<Integer> tempValueList = new ArrayList<Integer>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.remove();
				tempList.add(node);
				tempValueList.add(node.val);
			}
			list.add(tempValueList);
			for (int i = 0; i < tempList.size(); i++) {
				TreeNode node = tempList.get(i);
				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}

		}
		for(int i=list.size()-1;i>=0;i--){
			result.add(list.get(i));
		}
		return result;
	}
	
	

}
