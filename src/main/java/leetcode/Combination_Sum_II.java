package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combination_Sum_II {

	public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		Arrays.sort(num);
		Set<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		combination(num, 0, target, new ArrayList<Integer>(), set);
		return new ArrayList<ArrayList<Integer>>(set);
	}

	private void combination(int[] nums, int index, int target,
			List<Integer> list, Set<ArrayList<Integer>> res) {
		int n = nums.length;
		if (index == n) {
			if (target == 0)
				res.add(new ArrayList<Integer>(list));
			return;
		}
		combination(nums, index + 1, target, list, res);
		if (target >= nums[index]) {
			list.add(nums[index]);
			combination(nums, index + 1, target - nums[index], list, res);
			list.remove(list.size() - 1);
		}
	}

}
