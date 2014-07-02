package com.programcreek.Top10AlgorithmsforCodingInterview;

import java.util.Stack;

public class Largest_Rectangle_in_Histogram {

	public int largestRectangleArea(int[] height) {
		int area = 0;
		Stack<Integer> stk = new Stack<Integer>();

		for (int i = 0; i < height.length; i++) {
			if (stk.empty() || height[i] > height[stk.peek()])
				stk.push(i);
			else {
				int h = stk.pop();
				int w = stk.empty() ? i : i - stk.peek() - 1;
				area = Math.max(area, w * height[h]);
				i--;
			}
		}

		while (!stk.empty()) {
			int h = stk.pop();
			int w = stk.empty() ? height.length : height.length - stk.peek()
					- 1;
			area = Math.max(area, w * height[h]);
		}
		return area;

	}

}
