package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

	public int evalRPN(String[] tokens) {

		int returnValue = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();

		for (String t : tokens) {
			if (!operators.contains(t)) {
				stack.push(t);
			} else {

				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());

				switch (t) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				}

			}
		}

		returnValue = Integer.valueOf(stack.pop());

		return returnValue;
	}

	public int evalRPN1(String[] tokens) {
		int returnValue = 0;

		String operators = "+-*/";

		Stack<String> stack = new Stack<String>();

		for (String t : tokens) {
			if (!operators.contains(t)) {
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());

				int index = operators.indexOf(t);

				switch (index) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				case 1:
					stack.push(String.valueOf(b - a));
					break;
				case 2:
					stack.push(String.valueOf(a * b));
					break;
				case 3:
					stack.push(String.valueOf(b / a));
					break;

				}

			}
		}

		returnValue = Integer.valueOf(stack.pop());

		return returnValue;
	}

}
