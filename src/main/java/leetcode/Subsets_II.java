package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets_II {

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {

		if (num == null)
			return null;
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		for (int i = num.length - 1; i >= 0; i--) {

			if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {

				prev = new ArrayList<ArrayList<Integer>>();
				for (int j = 0; j < result.size(); j++) {

					prev.add(new ArrayList<Integer>(result.get(j)));

				}
			}

			for (ArrayList<Integer> temp : prev) {
				temp.add(0, num[i]);
			}

			if (i == num.length - 1 || num[i] != num[i + 1]) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				prev.add(temp);
			}

			for (ArrayList<Integer> temp : prev) {
				result.add(new ArrayList<Integer>(temp));
			}

		}

		result.add(new ArrayList<Integer>());
		return result;
	}
}