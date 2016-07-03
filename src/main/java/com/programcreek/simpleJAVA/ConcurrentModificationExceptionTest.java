package com.programcreek.simpleJAVA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExceptionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> list1=new ArrayList<String>();
		list1.add("aa");
		list1.add("bb");
		list1.add("cc");
		Iterator<String> iter=list1.iterator();
		while(iter.hasNext()){
			String str=iter.next();
			if(str.equals("bb")){
				iter.remove();
			}
		}
		
		
		
		
		
		
		
		
		List<String> list2=new CopyOnWriteArrayList<String>();
		list2.add("A");
		list2.add("B");
		list2.add("C");
		for(String s:list2){
			if(s.equals("B")){
				list2.remove(s);
			}
		}
		
		
		Set<String> set=new HashSet<String>();
		set.add("A");
		set.add("B");
		for(String s:set){
			if(s.equals("B")){
				set.remove(s);
			}
		}
		
		
		
		
		LinkedList<String> list3=new LinkedList<String>();
		list3.add("A");
		list3.add("B");
		
		for(String s:list3){
			if(s.equals("B")){
				list3.remove(s);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		


	}

}
