package com.mainshi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class qunaerwang1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = new ArrayList<String>();
		list.add("aString");
		list.add("thrid");
		list.add("aLongString");
		list.add("twoString");
		System.out.println(list);

		/*
		 * for (int i = list.size()-1; i >=0; i--) { if (((String)
		 * list.get(i)).startsWith("abcde")) { list.remove(i); } }
		 */

		/*
		 * for (int i = 0; i < list.size(); i++) { if (((String)
		 * list.get(i)).startsWith("abcde")) { list.remove(i); i=i-1;
		 * 
		 * } }
		 */

		/*
		 * for (Iterator it = list.iterator(); it.hasNext();) { String str =
		 * (String)it.next(); if (str.equals("chengang")){ it.remove(); } }
		 */
		// list = removeStartWithA(list);

		System.out.println(list);
	}

	public static List<String> removeStartWithA(List<String> list) {
		List<String> tempList = new ArrayList<String>();
		for (String str : list) {
			if (!str.startsWith("a")) {
				tempList.add(str);
			}
		}
		return tempList;
	}

}
