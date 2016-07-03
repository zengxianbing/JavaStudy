package com.programcreek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HowDevelopersSortinJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] str={"aa","1pp","qq","rr"};
		List<String> list=new ArrayList<String>(Arrays.asList(str));
		System.out.println(list);
		Collections.sort(list,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.toString().compareTo(o2.toString());
				
			}
			
		});
		
		
		System.out.println(list);
		
		for(String str1:str){
			System.out.print(str1);
		}
		
		System.out.println();
		Arrays.sort(str,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.toString().compareTo(o2.toString());
			}
			
		});
		
		for(String str1:str){
			System.out.print(str1);
		}
		
		
		
		
		
		
		
		Set<String> sortedSet1=new TreeSet<String>();
		sortedSet1.add("aaa");
		sortedSet1.add("sdfsd");
		sortedSet1.add("2xd");
		sortedSet1.add("pdf3");
		sortedSet1.add("1aaa");
		System.out.println(sortedSet1);
		Set<String> sortedSet=new TreeSet<String>(new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				return o1.toString().compareTo(o2.toString());
			}
			
		});
		
		
		sortedSet.addAll(sortedSet1);
		System.out.println(sortedSet);
		
		
		/*//TreeMap - In general, defined comparator
		Map<ObjectName, String> sortedMap = new TreeMap<ObjectName, String>(new Comparator<ObjectName>() {
			public int compare(ObjectName o1, ObjectName o2) {
				return o1.toString().compareTo(o2.toString());
			}
		});
		sortedMap.putAll(unsortedMap);*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
