package leetcode;

public class Unique_Paths {

	/*
	public int unquePaths(int m,int n){
		if(m==0||n==0)return 0;
		if(m==1||n==1)return 1;
		
		int[][] path=new int[m][n];
		for(int i=0;i<n;i++){
			path[0][i]=1;
		}
		
		for(int i=0;i<m;i++){
			path[i][0]=1;
		}
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				path[i][j]=path[i-1][j]+path[i][j-1];
			}
		}
		return path[m-1][n-1];
		
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public int uniquePaths(int m,int n){
		int[][] sum=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0&&j==0){
					sum[i][j]=1;
				}else{
					sum[i][j]=(i>0?sum[i-1][j]:0)+
							(j>0?sum[i][j-1]:0);
				}
			}
		}
		if(n==0||n==0){
			return 0;
		}else{
			return sum[n-1][n-1];
		}
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	public int uniquePaths(int m,int n){
		long x=Math.min(m, n)-1;
		long y=Math.max(m, n)-1;
		
		
		long ways=1;
		
		for(long i=y+1;i<=x+y;i++){
			ways*=i;
		}
		for(long i=1;i<=x;i++){
			ways/=i;
		}
		return (int)ways;
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static int count;
	
	
	public static int uniquePaths(int m,int n){
		if(m==0||n==0)
			return 0;
		if(m==1||n==1)
			return 1;
		
		count=0;
		helper(m,n,0,0);
		return count;
	}
	
	public static void helper(int m,int n,int row,int col){
		if(row==n-1&&col==n-1){
			count++;
		}
		if(row==m-1){
			helper(m,n,row,col+1);
		}
		
		if(col==n-1){
			helper(m,n,row+1,col);
		}
		
		if(row!=m-1&&col!=n-1){
			helper(m,n,row,col+1);
			helper(m,n,row+1,col);
		}
		return;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
