package com.programcreek.simpleJAVA;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class Dog implements Comparable<Dog>{
	int size;
	Dog(int s){
		size=s;
	}
	
	public int compareTo(Dog o){
		return o.size-this.size;
	}
}
class SizeComparator1 implements Comparator<Dog>{

	
	@Override
	public int compare(Dog d1, Dog d2) {
		return d1.size-d2.size;
	}
	
}
public class TreeSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
/*
		TreeSet<Dog> d=new TreeSet<Dog>(new SizeComparator1());
		d.add(new Dog(1));
		d.add(new Dog(2));
		d.add(new Dog(1));
		for(Dog d1:d){
			System.out.println(d1.size);
		}*/
		
		

		TreeSet<Dog> d=new TreeSet<Dog>();
		d.add(new Dog(1));
		d.add(new Dog(2));
		d.add(new Dog(1));
		for(Dog d1:d){
			System.out.println(d1.size);
		}
		
		
		TreeSet<Integer> tree=new TreeSet<Integer>();
		tree.add(12);
		tree.add(63);
		tree.add(34);
		tree.add(45);
		
		Iterator<Integer> iterator=tree.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next()+"_");
		}
		System.out.println();
		System.out.println(tree.first());
		System.out.println(tree.last());
		
		System.out.println(tree.size());
		tree.clear();
		System.out.println(tree.isEmpty());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
