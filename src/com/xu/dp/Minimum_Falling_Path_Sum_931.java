package com.xu.dp;

public class Minimum_Falling_Path_Sum_931 {

    public int minFallingPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i][j] = A[i][j];
                } else {
                    if (j == 0) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + A[i][j];
                    } else if (j == n - 1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + A[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + A[i][j];
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[m - 1][i], min);
        }
        return min;
    }

}
