package com.programcreek.java_basics;

import java.util.Comparator;
import java.util.TreeSet;

class SizeComparator implements Comparator<Dog>{

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		return o1.size-o2.size;
	}
	
}


class Dog1 implements Comparable<Dog>{

	int size;
	
	public Dog1(int size) {
		super();
		this.size = size;
	}

	@Override
	public int compareTo(Dog o) {
		// TODO Auto-generated method stub
		return o.size-this.size;
	}
	
}

public class Common_Methods {

	
	
	public void test1(){
	TreeSet<Dog> dd=new TreeSet<Dog>(new SizeComparator());
	dd.add(new Dog(1,2));
	dd.add(new Dog(2,3));
	dd.add(new Dog(4,5));
	}
	
	
	
	
	public void test2(){
		TreeSet<Dog1> d=new TreeSet<Dog1>();
		d.add(new Dog1(1));
		d.add(new Dog1(2));
		d.add(new Dog1(3));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
