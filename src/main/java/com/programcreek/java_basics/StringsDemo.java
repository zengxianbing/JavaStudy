package com.programcreek.java_basics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

public class StringsDemo extends TestCase {

	/*
	 * 5. Immutable objects are naturally thread-safe
	 * 
	 * Because immutable objects can not be changed, they can be shared among
	 * multiple threads freely. This eliminate the requirements of doing
	 * synchronization.
	 * 
	 * In summary, String is designed to be immutable for the sake of efficiency
	 * and security. This is also the reason why immutable classes are preferred
	 * in general.
	 */public void test1() throws ParseException {
		String a = "abcd";
		String b = "abcd";
		System.out.println(a == b);
		System.out.println(a.equals(b));
		String c = new String("abcd");
		String d = new String("abcd");
		System.out.println(c == d);
		System.out.println(c.equals(d));

		String str = "Sep 17,2013";
		Date date = new SimpleDateFormat("MMMM d, yy", Locale.ENGLISH)
				.parse(str);
		System.out.println(date);

	}

	public static boolean testAllUpperCase(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c >= 97 && c <= 122) {
				return false;
			}
		}
		return true;
	}

	public void test2() {
		String x = new String("ab");
		change(x);
		System.out.println(x);
	}
	
	public  static void test3(){
		StringBuilder x=new StringBuilder("ab");
		change1(x);
		System.out.println(x);
	} 
	
	
	
	
	

	public static void change(String x) {
		x = "cd";
	}
	
	public static void change1(StringBuilder x){
		x.delete(0, 2).append("cd");
	}

}
