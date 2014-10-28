package leetcode;

public class Single_Number_II {

	public int singleNumber(int[] A){
		int[] digits=new int[32];
		
		for(int i=0;i<32;i++){
			for(int j=0;j<A.length;j++){
				digits[i]+=(A[j]>>i)&1;
			}
		}
		
		int res=0;
		for(int i=0;i<32;i++){
			res+=(digits[i]%3)<<i;
		}
		return res;
	}
}
