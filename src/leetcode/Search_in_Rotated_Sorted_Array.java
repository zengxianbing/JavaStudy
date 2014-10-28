package leetcode;

public class Search_in_Rotated_Sorted_Array {

	public int search(int[] A,int target){
		int left=0;
		int right=A.length-1;
		
		while(left<=right){
			int mid=(left+right)/2;
			if(A[mid]==target){
				return mid;
			}
			
			if(A[mid]>=A[left]){
				if(A[mid]>target&&A[left]<=target){
					right=mid-1;
				}else{
					left=mid+1;
				}
			}else{
				if(A[mid]<target&&A[right]>=target){
					left=mid+1;
				}else{
					right=mid-1;
				}
			}
		}
		return -1;
	}
}
