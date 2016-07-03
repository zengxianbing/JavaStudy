package com.programcreek.simpleJAVA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] array={
				new Integer(1),
				new Integer(2),
				new Integer(3)
		};
		
		ArrayList<Integer> arrayList=new ArrayList<Integer>(Arrays.asList(array));
		
		
		List<Integer> arraylist1=Arrays.asList(array);
		
		
		
		List<Integer> arrayList2=new ArrayList<Integer>(array.length);
		Collections.addAll(arrayList2, array);
	}

}
