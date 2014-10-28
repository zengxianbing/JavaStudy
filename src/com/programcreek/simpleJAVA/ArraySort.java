package com.programcreek.simpleJAVA;

import java.util.Arrays;
import java.util.Comparator;

class Dog1{
	int size;
	public Dog1(int s){
		size=s;
	}
}

class DogSizeComparator implements Comparator<Dog1>{

	@Override
	public int compare(Dog1 o1, Dog1 o2) {
		// TODO Auto-generated method stub
		return o1.size-o2.size;
	}
	
}


public class ArraySort {

	public static void printDogs(Dog1[] dogs){
		for(Dog1 d:dogs){
			System.out.println(d.size+"_");
		}
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		
		
		
		
		
		Dog1 d1=new Dog1(2);
		Dog1 d2=new Dog1(1);
		Dog1 d3=new Dog1(3);
		
		Dog1[] dogArray={d1,d2,d3};
		printDogs(dogArray);
		
		Arrays.sort(dogArray,new DogSizeComparator());
		printDogs(dogArray);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
