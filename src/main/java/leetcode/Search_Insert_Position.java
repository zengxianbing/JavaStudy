package leetcode;

public class Search_Insert_Position {

	public int searchInsert(int[] A,int target){
		if(A==null||A.length==0){
			return 0;
		}
		
		int l=0;
		int r=A.length-1;
		while(l<=r){
			int mid=(l+r)/2;
			if(A[mid]==target)
				return mid;
			if(A[mid]<target)
				l=mid+1;
			else
				r=mid-1;
		}
		return l;
	}
}
