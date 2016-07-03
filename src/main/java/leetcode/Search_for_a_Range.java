package leetcode;

public class Search_for_a_Range {

	/*public static int[] searchRange(int[] A, int target) {
		int[] ret = {Integer.MAX_VALUE, Integer.MIN_VALUE};
		rec(A, target, ret, 0, A.length-1);
		if(ret[0] == Integer.MAX_VALUE){
			ret[0] = -1;
		}
		if(ret[1] == Integer.MIN_VALUE){
			ret[1] = -1;
		}
		return ret;
	}
	

	public static void rec(int[] A, int target, int[] ret, int low, int high){
		if(low > high){
			return;
		}
		
		int mid = low + (high-low)/2;
		if(target == A[mid]){
			ret[0] = Math.min(ret[0], mid);		
			ret[1] = Math.max(ret[1], mid);	
			rec(A, target, ret, low, mid-1);	
			rec(A, target, ret, mid+1, high);		
		}else if(target < A[mid]){
			rec(A, target, ret, low, mid-1);
		}else{
			rec(A, target, ret, mid+1, high);
		}
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int[] searchRange(int[] A,int target){
		int n=A.length;
		int left=bsearchCeil(A,target,0,n);
		int right=bsearchFloor(A,target,0,n);
		if(left>=n||A[left]!=target)
			left=-1;
		if(right<0||A[right]!=target)
			right=-1;
		int[] res=new int[2];
		res[0]=left;
		res[1]=right;
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	private int bsearchCeil(int[] a,int target,int s,int e){
		if(s==e)
			return e;
		int mid=(s+e)/2;
		int val=a[mid];
		if(target>val){
			return bsearchCeil(a,target,mid+1,e);
		}else{
			return bsearchCeil(a,target,s,mid);
		}
	} 
	
	private int bsearchFloor(int[] a,int target,int s,int e){
		if(s==e)
			return s-1;
		int mid=(s+e)/2;
		int val=a[mid];
		
		if(target>=val){
			return bsearchFloor(a,target,mid+1,e);
		}else{
			return bsearchFloor(a,target,s,mid);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
