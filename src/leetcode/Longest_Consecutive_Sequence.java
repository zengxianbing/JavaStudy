package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Longest_Consecutive_Sequence {

	/*public int longestConsecutive(int[] num) {
		Set<Integer> set = new HashSet<Integer>();
		int max = 1;

		for (int e : num)
			set.add(e);

		for (int e : num) {
			int left = e - 1;
			int right = e + 1;

			int count = 1;
			while (set.contains(left)) {
				count++;
				set.remove(left);
				left--;
			}

			while (set.contains(right)) {
				count++;
				set.remove(right);
				right++;
			}

			max = Math.max(count, max);
		}
		return max;

	}*/
	
	
	
	
	
	
	
	
	
	 public int longestConsecutive(int[] num) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        Set<Integer> set = new HashSet<Integer>();
	        for (int i : num) {
	            set.add(i);
	        }
	        int max = 0;
	        for (int i : num) {
	            max = Math.max(max, getCount(set, i));
	        }
	        return max;
	    }

	    private int getCount(Set<Integer> set, int i) {
	        int count = 1;
	        int k = i;
	        while (set.contains(--k)) {
	            set.remove(k);
	            count++;
	        }
	        k = i;
	        while (set.contains(++k)) {
	            set.remove(k);
	            count++;
	        }
	        return count;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
