package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.ArrayList;

public class Pascal_Triangle {

	public ArrayList<ArrayList<Integer>> getRow(int numRows) {
		/*
		 * ArrayList<Integer> rs=new ArrayList<Integer>(); if(rowIndex==0){
		 * rs.add(1); return rs; }
		 * 
		 * rs.add(1); for(int i=1;i<=rowIndex;i++){ rs.add(0,1); for(int
		 * j=1;j<=i-1;j++){ rs.set(j, rs.get(j)+rs.get(j+1)); } } return rs;
		 */

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (numRows <= 0)
			return res;
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		res.add(pre);
		for (int i = 2; i <= numRows; i++) {
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for (int j = 0; j < pre.size() - 1; j++) {
				cur.add(pre.get(j) + pre.get(j + 1));
			}
			cur.add(1);
			res.add(cur);
			pre = cur;
		}
		return res;

	}
}
