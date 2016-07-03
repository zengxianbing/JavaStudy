package com.programcreek.java_basics;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import junit.framework.TestCase;

public class ArraysDemo extends TestCase {

	
	
	public void test1(){
		String[] aArray=new String[5];
		String[] bArray={"a","b"};
		String[] cArray=new String[]{"a","b"};
		
		
		
		int[] intArray={1,2,3,4,5};
		String intArrayString=Arrays.toString(intArray);
		
		System.out.println(intArray);
		System.out.println(intArrayString);
		
		
		String[] stringArray={"a","b","c","d","e"};
		ArrayList<String> arrayList=new
				ArrayList<String>(Arrays.asList(stringArray));
		System.out.println(stringArray);
		
		
		boolean b=Arrays.asList(stringArray).contains("a");
		System.out.println(b);
		
		
		/*
		int[] intArray = { 1, 2, 3, 4, 5 };
		int[] intArray2 = { 6, 7, 8, 9, 10 };
		// Apache Commons Lang library
		int[] combinedIntArray = ArrayUtils.addAll(intArray, intArray2);
		*/
		
		
		
		
		/*String j = StringUtils.join(new String[] { "a", "b", "c" }, ", ");
		System.out.println(j);
		*/
		
		
		String[] stringArray1={"a","b","c","d","e"}; 
		ArrayList<String>   arrayList1=new 
				ArrayList<String>(Arrays.asList(stringArray1));
		String[] stringArr=new String[arrayList.size()];
		arrayList1.toArray(stringArr);
		for(String s:stringArr){
			System.out.println(s);
		}
		
		
		
		
		Set<String> set=new HashSet<String>(Arrays.asList(stringArray1));
		System.out.println(set);
		
		
		
		ArrayUtils.reverse(intArray);
		System.out.println(Arrays.toString(intArray));
		
		
		
		
		int[] removed=ArrayUtils.removeElement(intArray, 3);
		
		System.out.println(Arrays.toString(removed));
		
		
		
		
		byte[] bytes=ByteBuffer.allocate(4).putInt(8).array();
		
		for(byte t:bytes){
			System.out.format("0x%x",t);
		}
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
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
	
	public static boolean useArraysBinarySearch(
			String[] arr,String targetValue){
		int a=Arrays.binarySearch(arr, targetValue);
		if(a>0)
			return true;
		else
			return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
