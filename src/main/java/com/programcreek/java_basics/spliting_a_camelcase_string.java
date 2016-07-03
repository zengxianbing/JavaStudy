package com.programcreek.java_basics;

import java.util.LinkedList;

public class spliting_a_camelcase_string {
	//accept a string, like aCamelString
	//return a list containing strings, in this case, [a, Camel, String]
	public static LinkedList<String> splitCamelCaseString(String s) {
		char[] cArray = s.toCharArray();
	 
		LinkedList<Integer> al = new LinkedList<Integer>();
		al.add(0);
	 
		// get all upper case letter index positions
		for (int i = 1; i < cArray.length; i++) {
			char c = cArray[i];
			//add more interested index beyond upper case letter
			if (c >= 65 && c <= 90) {
				al.add(i);
			}
		}
	 
		LinkedList<String> strl = new LinkedList<String>();
	 
		// this handles the all lower letter case
		if (al.size() == 1) {
			strl.add(s);
			return strl;
		}
	 
	 
		int prev = 0;
		int curr = 0;
		int begin = 0;
		for (int k = 1; k < al.size(); k++) {
	 
			curr = al.get(k);
	 
			if(curr == s.length() - 1){
	 
			}
	 
			if (curr == prev + 1 && curr != s.length() - 1) {
				prev = curr;
			} else if(curr == prev + 1 &&  curr == s.length() - 1){
				strl.add(s.substring(begin, curr+1));
			}else {
	 
				strl.add(s.substring(prev, curr));
				prev = curr;
				begin = curr;
				if (k == al.size() - 1) {
					strl.add(s.substring(curr, s.length()));
				}
			}
		}
	 
		return strl;
	}
}
