package leetcode;

public class Sqrt {

	public static int sqart(int x){
		double diff=0.01;
		int low=0;
		int high=x;
		
		while(low<high){
			double mid=low+(high-low)/2;
			if(Math.abs(mid*mid-x)<=diff){
				return (int)mid;
			}else if(x>mid*mid+diff){
				low=(int)mid+1;
			}else if(x<mid*mid-diff){
				high=(int)mid-1;
			}
		}
		
		return high;
	}
}

