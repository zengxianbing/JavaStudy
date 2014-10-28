package com.programcreek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Top10MistakesJavaDevelopersMake {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		1
		String[] strArray={"aa","bb"};
		
		List<String> list=Arrays.asList(strArray);
		
		Arrays.asList(strArray).contains("aa");
//		2
		
		for(String s:strArray){
			if(s.equals("aa")){
				System.out.println("true");
			}
		}
		
		
		ArrayList<String> list1=new ArrayList<String>(Arrays.asList(
				"a", "b", "c", "d"));
		/*for(int i=0;i<list1.size();i++){
			list.remove(i);
		}*/
		
		
		
		Iterator<String> iter=list1.iterator();
		while(iter.hasNext()){
			String s=iter.next();
			if(s.equals("a")){
				iter.remove();
			}
		}
		System.out.println(list1);
		
		
		
		String a="abcd";
		String b="abcd";
		System.out.println(a==b);
		System.out.println(a.equals(b));
		
		
		String c=new String("abcd");
		String d=new String("abcd");
		System.out.println(c==d);
		System.out.println(c.equals(d));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
