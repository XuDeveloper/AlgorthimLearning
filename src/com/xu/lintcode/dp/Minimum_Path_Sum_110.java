package com.xu.lintcode.dp;

public class Minimum_Path_Sum_110 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int M = grid.length;
        int N = grid[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < N; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[M - 1][N - 1];
    }

}
