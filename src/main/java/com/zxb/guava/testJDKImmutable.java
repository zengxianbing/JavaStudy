package com.zxb.guava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class testJDKImmutable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		System.out.println(list);
		
		List<String> unmodifiavleList=Collections.unmodifiableList(list);
	
		System.out.println(unmodifiavleList);
		
		List<String> unmodifiavleList1=Collections.unmodifiableList(Arrays.asList("a","b","c"));
		System.out.println(unmodifiavleList1);
		
		
		String temp=unmodifiavleList.get(1);
		System.out.println("unmodifiableList [0]:"+temp);
		
		list.add("baby");
		System.out.println("list add a item after list:"+list);
		System.out.println("list add a item after unmodifiableList:"+unmodifiavleList);
		
		unmodifiavleList1.add("bb");
		System.out.println("unmodifiableList add a item after list:"+unmodifiavleList1);
		
		
		unmodifiavleList.add("cc");
		 System.out.println("unmodifiableList add a item after list:"+unmodifiavleList);        
    }

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


