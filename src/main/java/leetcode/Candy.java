package leetcode;

public class Candy {

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;

		int[] nums = new int[ratings.length];

		nums[0] = 1;

		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				nums[i] = nums[i - 1] + 1;
			} else {
				nums[i] = 1;
			}
		}

		int res = nums[ratings.length - 1];
		for (int i = ratings.length - 2; i >= 0; i--) {
			int cur = 1;
			if (ratings[i] > ratings[i + 1]) {
				cur = nums[i + 1] + 1;
			}
			res += Math.max(cur, nums[i]);
			nums[i] = cur;
		}

		return res;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int candy1(int[] ratings){
		int minLeft=1;
		int end=ratings.length;
		
		int sum=0;
		int k=1;
		for(int i=0;i<end;i++,k++){
			if(i==end-1||ratings[i]<=ratings[i+1]){
				sum+=Math.max(k, minLeft);
				if(i<end-1&&ratings[i+1]>ratings[i])
					minLeft=(k==1?minLeft:1)+1;
				else
					minLeft=1;
					
				k=0;
			}else{
				sum+=k;
			}
			}
		return sum;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

