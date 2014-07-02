package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II {

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
	/*	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

		if (root == null) {
			return ret;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		ArrayList<ArrayList<Integer>> alal = new ArrayList<ArrayList<Integer>>();

		ArrayList<Integer> al = new ArrayList<Integer>();

		int currentLevel = 1;
		int nextLevel = 0;

		while (!queue.isEmpty()) {
			TreeNode cur = queue.remove();
			currentLevel--;
			al.add(cur.val);

			if (cur.left != null) {
				queue.add(cur.left);
				nextLevel++;
			}
			if (cur.right != null) {
				queue.add(cur.right);
				nextLevel++;
			}
			if (currentLevel == 0) {
				alal.add(al);
				al = new ArrayList<Integer>();
				currentLevel = nextLevel;
				nextLevel = 0;
			}

		}

		for (int i = alal.size() - 1; i >= 0; i--) {
			ret.add(alal.get(i));
		}

		return ret;*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ArrayList<ArrayList<Integer>>  result=
				new ArrayList<ArrayList<Integer>> ();
		if(root==null){
			return result;
		}
		
		Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.offer(root);
		int currLevelNodeNum=1;
		int nextLevelNodeNum=0;
		while(currLevelNodeNum!=0){
			ArrayList<Integer> currLevelResult=
				new ArrayList<Integer>();
			nextLevelNodeNum=0;
			while(currLevelNodeNum!=0){
				TreeNode node=queue.poll();
				
				currLevelNodeNum--;
				currLevelResult.add(node.val);
				
				if(node.left!=null){
					queue.offer(node.left);
					nextLevelNodeNum++;
					
				}
				
				if(node.right!=null){
					queue.offer(node.right);
					nextLevelNodeNum++;
				}
			}
			
			result.add(0,currLevelResult);
			currLevelNodeNum=nextLevelNodeNum;
		}
		
		return result;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}
