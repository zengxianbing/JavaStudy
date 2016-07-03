package com.suggest;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class StringStudy {

	/*
	 * 推荐使用String直接量赋值
	 * 
	 * replaceAll传递的第一个参数是正则表达式
	 * 
	 * 推荐在复杂字符串操作中使用正则表达式
	 */
	public static void main(String[] args) {

		String str1="abc";
		String str2="abc";
		String str3=new String("abc");
		String str4=str3.intern();
		boolean b1=(str1==str2);
		boolean b2=(str1==str3);
		
		boolean b3=(str1==str4);
		
		
		String[] strs={"张三","李四","王五"};
		Comparator c=Collator.getInstance(Locale.CHINA);
		Arrays.sort(strs,c);
		int i=0;
		for (String str : strs) {
			System.out.println((++i)+"、"+str);
			
		}
		
		
		
		
		
		
		
		
		
		
	}

}
