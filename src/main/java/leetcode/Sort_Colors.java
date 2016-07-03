package leetcode;

public class Sort_Colors {

	public void sortColors(int[] A) {
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				count0++;
			}
			if (A[i] == 1) {
				count1++;
			}
			if (A[i] == 2) {
				count2++;
			}
		}

		for (int i = 0; i < count0; i++) {
			A[i] = 0;
		}

		for (int i = count0; i < count0 + count1; i++) {
			A[i] = 1;
		}
		for (int i = count0 + count1; i < count0 + count1 + count2; i++) {
			A[i] = 2;
		}

	}
	
	
	
	
	
	
	
	
	
	
	
	
	public void sortColors1(int[] A){
		int[] hash=new int[3];
		if(A.length==0)
			return ;
		for(int key:A){
			hash[key]++;
		}
		
		int len=0;
		for(int i=0;i<3;i++){
			int cnt=hash[i];
			if(cnt>0){
				for(int k=0;k<cnt;k++){
					A[len++]=i;
				}
			}
		}
		hash=null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
