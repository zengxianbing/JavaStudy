package com.mainshi;

import java.util.ArrayList;
import java.util.List;

public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1=new ArrayList<Integer>();
		list1.add(0);
		
		//List<Object> list2=list1;
		
		System.out.println(list1.get(0) instanceof Integer);
//		System.out.println(list2.get(0) instanceof Integer);
	}

}
