package com.programcreek.java_basics;

import java.util.Arrays;
import java.util.Comparator;

class Dog {
	int size;
	int weight;

	public Dog(int size, int weight) {
		super();
		this.size = size;
		this.weight = weight;
	}
}

class DogSizeComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		return o1.size - o2.size;
	}

}

class DogWeightComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		// TODO Auto-generated method stub
		return o1.weight - o2.weight;
	}

}

public class ArraySort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Dog d1 = new Dog(2, 50);
		Dog d3 = new Dog(1, 30);
		Dog d2 = new Dog(3, 40);

		Dog[] dogArray = { d1, d2, d3 };
		printDogs(dogArray);

		Arrays.sort(dogArray, new DogSizeComparator());

		printDogs(dogArray);

		Arrays.sort(dogArray, new DogWeightComparator());
		printDogs(dogArray);
	}

	public static void printDogs(Dog[] dogs) {
		for (Dog d : dogs) {
			System.out.println("size=" + d.size + " weight=" + d.weight);
		}
		System.out.println();

	}

}
