package com.programcreek.simpleJAVA;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

public class ArraysTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String[] aArray=new String[5];
		String[] bArray={"a","b","c","d"};
		String[] cArray=new String[]{"a","b","c","d"};
		
		int[] intArray={1,2,3,4,5};
		String intArrayString=Arrays.toString(intArray);
		
		
		System.out.println(intArray);
		System.out.println(intArrayString);
		
		String[] stringArray={"a","b","c","d"};
		ArrayList<String> arrayList=new
				ArrayList<String>(Arrays.asList(stringArray));
		
		System.out.println(arrayList);
		
		
		boolean b=Arrays.asList(stringArray).contains("a");
		
		System.out.println(b);
		
		
		int[] intArray1={1,2,3,44};
		int[] intArray2={11,22,34,454};
		int[] combineIntArray=ArrayUtils.addAll(intArray1, intArray2);
		
		ArrayList<String> arrayList3=
	    new ArrayList<String>(Arrays.asList(stringArray));
		String[] stringArr=new String[arrayList.size()];
		arrayList3.toArray(stringArr);
		for(String s:stringArr)
			System.out.println(s);
		
		
		Set<String> set=new HashSet<String>(Arrays.asList(stringArray));
		
		System.out.println(set);
		
		ArrayUtils.reverse(intArray);
		System.out.println(Arrays.toString(intArray));
		
		
		int[]  removed=ArrayUtils.removeElement(intArray, 2);
		System.out.println(Arrays.toString(removed));
		
		
				
		byte[] bytes=ByteBuffer.allocate(4).putInt(8).array();
		
		for(byte t:bytes){
			System.out.format("%x",t);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
