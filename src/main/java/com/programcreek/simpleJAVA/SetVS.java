package com.programcreek.simpleJAVA;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.TreeSet;

public class SetVS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Random r=new Random();
		HashSet<Dog>  hashSet=new HashSet<Dog>();
		TreeSet<Dog> treeSet=new TreeSet<Dog>();
		LinkedHashSet<Dog> linkedSet=new LinkedHashSet<Dog>();
		
		long startTime=System.nanoTime();
		
		for(int i=0;i<1000;i++){
			int x=r.nextInt(1000-10)+10;
			hashSet.add(new Dog(x));
		}
		long endTime=System.nanoTime();
		long duration=endTime-startTime;
		
		System.out.println("HashSet"+duration);
		
	}

}
