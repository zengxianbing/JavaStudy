package com.programcreek.Top10AlgorithmsforCodingInterview;

public class Unique_Paths_II {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] grid = obstacleGrid;
		int m = grid.length;

		int n = m > 0 ? grid[0].length : 0;
		int[][] sum = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					if (i == 0 && j == 0) {
						sum[i][j] = 1;
					} else {
						sum[i][j] = (i > 0 ? sum[i - 1][j] : 0)
								+ (j > 0 ? sum[i][j - 1] : 0);
					}
				}
			}
		}

		if (m == 0 || n == 0) {
			return 0;
		} else {
			return sum[m - 1][n - 1];
		}
	}
}
