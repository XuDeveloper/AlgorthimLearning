package com.xu.lintcode.dp;

public class Longest_Increasing_Continuous_subsequence_II_398 {

    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return 0;

        int lics = 0;
        int[][] dp = new int[A.length][A[0].length];
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < A[0].length; col++) {
                if (dp[row][col] == 0) {
                    lics = Math.max(lics, dfs(A, row, col, dp));
                }
            }
        }

        return lics;
    }

    private int dfs(int[][] A, int row, int col, int[][] dp) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        // increasing from xxx to up, down, left, right
        int up = 0, down = 0, left = 0, right = 0;
        // increasing from down to up
        if (row > 0 && A[row - 1][col] > A[row][col]) {
            up = dfs(A, row - 1, col, dp);
        }
        // increasing from up to down
        if (row + 1 < A.length && A[row + 1][col] > A[row][col]) {
            down = dfs(A, row + 1, col, dp);
        }
        // increasing from right to left
        if (col > 0 && A[row][col - 1] > A[row][col]) {
            left = dfs(A, row, col - 1, dp);
        }
        // increasing from left to right
        if (col + 1 < A[0].length && A[row][col + 1] > A[row][col]) {
            right = dfs(A, row, col + 1, dp);
        }
        // return maximum of up, down, left, right
        dp[row][col] = 1 + Math.max(Math.max(up, down), Math.max(left, right));

        return dp[row][col];
    }

}
