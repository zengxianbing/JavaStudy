package leetcode;

import java.util.Stack;

public class Longest_Valid_Parentheses {

	public int longestValidParentheses(String s) {
		int max = 0;
		int N = s.length();
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(-1);

		for (int i = 0; i < N; i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				int index = stack.peek();
				if (index != -1 && s.charAt(index) == '(') {
					stack.pop();
					max = Math.max(max, i - stack.peek());
				} else {
					stack.push(i);
				}
			}
		}

		return max;
	}
}
