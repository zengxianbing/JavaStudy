package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;

public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		/*Combinations combinations=new Combinations();
		combinations.combine(4, 2);*/
	}

	
	/*public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> subset = new ArrayList<Integer>();
		int[] num = new int[n];
		for (int j = 0; j < n; j++) {
			num[j] = j + 1;
			System.out.print(num[j]);
			
			System.out.println("---------");
		}
		
		subsets(n, k, num, 0, subset, result);
		return result;
	}

	private void subsets(int n, int k, int[] num, int begin,
			ArrayList<Integer> subset, ArrayList<ArrayList<Integer>> result) {
		if (subset.size() >= k) {
			System.out.println(subset+"---");
			ArrayList<Integer> c = new ArrayList<Integer>(subset);
		//	System.out.println(c);
			result.add(c);
		} else {
			for (int i = begin; i < num.length; i++) {
				subset.add(num[i]);
				System.out.println(num[i]);
				subsets(n, k, num, i + 1, subset, result);
				subset.remove(subset.size() - 1);
				System.out.println(subset+"***");
			}
		}
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ArrayList<ArrayList<Integer>> combine(int n,int k){
		ArrayList<ArrayList<Integer>> rst=new 
				ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> solution=new 
				ArrayList<Integer>();
		helper(rst,solution,n,k,1);
		return rst;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private void helper(
		ArrayList<ArrayList<Integer>> rst,
		ArrayList<Integer> solution,
		int n,
		int k,
		int start){
		if(solution.size()==k){
			rst.add(new ArrayList(solution));
			return;
		}
		
		
		for(int i=start;i<=n;i++){
			solution.add(i);
			
			helper(rst,solution,n,k,i+1);
			solution.remove(solution.size()-1);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
