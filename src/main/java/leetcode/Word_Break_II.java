package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Word_Break_II {
	private Map<Integer, ArrayList<String>> records = new HashMap<Integer, ArrayList<String>>();
	private Set<String> dict = null;
	private String s = null;
	private int N = 0;

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		if (s == null || s.length() <= 0 || dict == null || dict.size() <= 0) {
			return new ArrayList<String>();
		}
		records.clear();
		this.dict = dict;
		this.s = s;
		N = s.length();

		ArrayList<String> list = solve(0);
		if (list == null) {
			list = new ArrayList<String>();
		}
		return list;
	}

	private ArrayList<String> solve(int i) {
		if (records.containsKey(i)) {
			return records.get(i);
		}

		ArrayList<String> list = new ArrayList<String>();
		if (i >= N) {
			records.put(i, list);
			return list;
		}
		for (int j = i + 1; j <= N; ++j) {
			String word = s.substring(i, j);
			if (dict.contains(word)) {
				ArrayList<String> subList = solve(j);
				ArrayList<String> newList = new ArrayList<String>();
				if (subList == null) {
					continue;
				} else if (subList.size() == 0) {
					newList.add(word);
				} else {
					for (String result : subList) {
						newList.add(word + " " + result);
					}
				}
				list.addAll(newList);
			}
		}
		if (list.size() == 0) {
			list = null;
		}
		records.put(i, list);
		return list;
	}
}
