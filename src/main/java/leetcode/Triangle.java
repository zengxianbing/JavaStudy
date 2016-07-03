package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {

	/*public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[] total = new int[triangle.size()];
		int l = triangle.size() - 1;
	 
		for (int i = 0; i < triangle.get(l).size(); i++) {
			total[i] = triangle.get(l).get(i);
		}
	 
		// iterate from last second row
		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
				total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
			}
		}
	 
		return total[0];
	}*/
	
	
	
	public static void main(String[] args){
		ArrayList<Integer> list1=new ArrayList<Integer>(2);
		ArrayList<Integer> list2=new ArrayList<Integer>(Arrays.asList(3,4));
		ArrayList<Integer> list3=new ArrayList<Integer>(Arrays.asList(6,5,7));
		ArrayList<Integer> list4=new ArrayList<Integer>(Arrays.asList(4,1,8,3));
		ArrayList<ArrayList<Integer>> lists=new ArrayList<ArrayList<Integer>>();
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		minimumTotal(lists);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        int n = triangle.size();
	        int[] min = new int[n + 1];
	        for(int i = n - 1; i >= 0; i--){
	            for(int j = 0; j <= i; j++){
	                min[j] = Math.min(min[j], min[j + 1]);
	                System.out.println("---"+min[j]);
	                min[j] += triangle.get(i).get(j);
	                System.out.println("****"+min[j]);
	            }
	        }
	        return min[0];
	    }
	
	
}
