package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.Stack;

public class Valid_Palindrome {

	public boolean isPalindrome(String s) {
		char[] cs = s.toLowerCase().toCharArray();
		int a = 0;
		int b = cs.length - 1;
		while (a < b) {
			while (a < b && !isLetter(cs[a]))
				a++;
			while (a < b && !isLetter(cs[b]))
				b--;
			if (cs[a] != cs[b])
				return false;
			a++;
			b--;
		}
		return true;
	}

	private boolean isLetter(char c) {
		return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
	}

	public boolean isPalindrome1(String s) {
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

		int len = s.length();
		if (len < 2)
			return true;

		Stack<Character> stack = new Stack<Character>();

		int index = 0;
		while (index < len / 2) {
			stack.push(s.charAt(index));
			index++;
		}

		if (len % 2 == 1) {
			index++;
		}
		while (index < len) {
			if (stack.empty())
				return false;

			char temp = stack.pop();
			if (s.charAt(index) != temp)
				return false;
			else
				index++;
		}
		return true;

	}

}
