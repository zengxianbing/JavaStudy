package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Minimum_Path_Sum {

	public int minPathSum(int[][] grid){
		int m=grid.length;
		int n=grid[0].length;
		
		int[][] paths=new int[m][n];
		
		paths[0][0]=grid[0][0];
		
		for(int i=1;i<m;i++){
			paths[i][0]=paths[i-1][0]+grid[i][0];
		}
		
		for(int j=1;j<n;j++){
			paths[0][j]=paths[0][j-1]+grid[0][j];
		}
		
		for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				paths[i][j]=Math.min(paths[i-1][j], paths[i][j-1])
						+grid[i][j];
			}
		}
		
		return paths[m-1][n-1];
		
	}
	
}
