package com.programcreek;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HowtoCheckifanArrayContainsaValueinJavaEfficiently {

	
	public static boolean useList(String[] arr,String targetValue){
		return Arrays.asList(arr).contains(targetValue);
	}
	
	
	public static boolean useSet(String[] arr,String targetValue){
		Set<String> set=new HashSet<String>(Arrays.asList(arr));
		return set.contains(targetValue);
	}
	
	public static boolean useLoop(String[] arr,String targetValue){
		for(String s:arr){
			if(s.equals(targetValue))
				return true;
		}
		return false;
	}
	
	
	public static boolean useArraysBinarySearch(String[] arr,String targetValue){
		int a=Arrays.binarySearch(arr, targetValue);
		if(a>0)
			return true;
		else
			return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = new String[] {  "CD",  "BC", "EF", "DE", "AB"};
		 
		//use list
		long startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			useList(arr, "A");
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("useList:  " + duration / 1000000);
	 
		//use set
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			useSet(arr, "A");
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("useSet:  " + duration / 1000000);
	 
		//use loop
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			useLoop(arr, "A");
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("useLoop:  " + duration / 1000000);
	 
		//use Arrays.binarySearch()
		startTime = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			useArraysBinarySearch(arr, "A");
		}
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("useArrayBinary:  " + duration / 1000000);

		
	/*	Clearly, using a simple loop method is more efficient than using any collection. A lot of developers use the first method, but it is inefficient. Pushing the array to another Collection type will require spin through all elements to read them in before doing anything with the collection type.

		The array must be sorted, if Arrays.binarySearch() method is used. In this case, the array is not sorted, therefore, it should not be used.

		Actually, if you really need to check if a value is contained in some array/collection efficiently, a sorted list or tree can do it in O(log(n)) or hashset can do it in O(1).
*/

	}

}
