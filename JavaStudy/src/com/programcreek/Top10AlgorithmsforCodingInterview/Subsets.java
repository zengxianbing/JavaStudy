package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	
	public static void main(String[] ars){
	
		/*int[] a={1,2,3}; 
		 subsets(a);*/
	}
	
	/*public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null)
			return null;
	 
		Arrays.sort(S);
	 
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = 0; i < S.length; i++) {
			System.out.println("****"+i);
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
	 
			//get sets that are already in result
			for (ArrayList<Integer> a : result) {
				System.out.println("---"+a);
				temp.add(new ArrayList<Integer>(a));
			}
	 
			//add S[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				System.out.println("existing"+a);
				a.add(S[i]);
				//System.out.println(a);
			}
	 
			//add S[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			System.out.println("single"+single);
			temp.add(single);
			System.out.println("temp"+temp);
			result.addAll(temp);
			System.out.println("result"+result);
		}
	 
		//add empty set
		result.add(new ArrayList<Integer>());
		
		return result;
	}*/
	
	
	
	
	/*public ArrayList<ArrayList<Integer>> subsets(int[] S){
		if(S==null)
			return null;
		
		Arrays.sort(S);
		ArrayList<ArrayList<Integer>> result=
				new 		ArrayList<ArrayList<Integer>>();
		for(int i=0;i<S.length;i++){
			ArrayList<ArrayList<Integer>> temp=new
					ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> a:result){
				temp.add(new ArrayList<Integer>(a));
			}
			
			for(ArrayList<Integer> a:temp){
				a.add(S[i]);
			}
			
			ArrayList<Integer> single=new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);
			
			result.addAll(temp);
		}
		result.add(new ArrayList<Integer>());
		return result;
	}
	*/
	
	public ArrayList<ArrayList<Integer>> sumsets(int[] S){
		ArrayList<ArrayList<Integer>> ans=new
				ArrayList<ArrayList<Integer>>();
		
		ans.add(new ArrayList<Integer>());
		Arrays.sort(S);
		for(int i=0;i<S.length;i++){
			int curSize=ans.size();
			for(int j=0;j<curSize;j++){
				ArrayList<Integer> cur=new 
						ArrayList<Integer>(ans.get(i));
				cur.add(S[i]);
				ans.add(cur);
			}
		}
		return ans;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
