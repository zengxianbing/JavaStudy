package com.programcreek.simpleJAVA;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class collectionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<String> a1=new ArrayList<String>();
		a1.add("Program");
		a1.add("Creek");
		a1.add("Java");
		a1.add("Java");
        System.out.println(a1);
        
        List<String> l1=new LinkedList<String>();
        l1.add("Program");
		l1.add("Creek");
		l1.add("Java");
		l1.add("Java");
        System.out.println(l1);
        
        
        Set<String> s1=new HashSet<String>();
        s1.add("Program");
		s1.add("Creek");
		s1.add("Java");
		s1.add("Java");
        
		System.out.println(s1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
