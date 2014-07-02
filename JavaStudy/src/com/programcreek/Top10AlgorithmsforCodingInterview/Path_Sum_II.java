package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;


public class Path_Sum_II {

	
	public static ArrayList<ArrayList<Integer>> pathSum(
			TreeNode root,int sum){
		ArrayList<ArrayList<Integer>> res=new 
				ArrayList<ArrayList<Integer>>();
		pathSum(root,sum,res,new ArrayList<Integer>());
		return res;
	}
	
	private static void pathSum(TreeNode root,int sum,
			ArrayList<ArrayList<Integer>> res,ArrayList<Integer> list){
		if(root==null)
			return;
		
		list.add(root.val);
		sum-=root.val;
		if(root.left==null&&root.right==null&&
				sum==0){
			res.add(new ArrayList<Integer>(list));
		}else{
			pathSum(root.left,sum,res,list);
			pathSum(root.right,sum,res,list);
			
		}
		System.out.println(list.get(list.size()-1));
		list.remove(list.size()-1);
		System.out.println(list);
	}
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(8);
		root.left = n1;
		root.right = n2;
		TreeNode n3 = new TreeNode(11);
		TreeNode n4 = new TreeNode(13);
		TreeNode n5 = new TreeNode(4);
		n1.left = n3;
		n2.left = n4;
		n2.right = n5;
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(2);
		n3.left = n6;
		n3.right = n7;
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(1);
		n5.left = n8;
		n5.right = n9;
		
		ArrayList<ArrayList<Integer>> list = pathSum(root, 22);
		System.out.println(list);
	}
	
	/*public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l =new ArrayList<Integer>();
		dfs(root, sum, list, l);
		return list;
    }
	
	// 经典递归回溯
	private static void dfs(TreeNode root, int sum, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> l){
		if(root == null){
			return;
		}
	
		// 找到最后一个合适的叶子节点
		if(root.val==sum && root.left==null && root.right==null){
			l.add(root.val);
			
			// 注意！在把结果加入结果集时，必须深拷贝一份！
			// 否则被加进去的集合之后可能会变动
			ArrayList<Integer> clone = new ArrayList<Integer>(l);
			list.add(clone);
			
			l.remove(l.size()-1);		// 恢复全局变量//回溯部分
			return;
		}
	
		l.add(root.val);
		dfs(root.left, sum-root.val, list, l);
		dfs(root.right, sum-root.val, list, l);
		l.remove(l.size()-1);		// 恢复全局变量//回溯部分
		System.out.println(l);
	}*/
}
