package com.xu.lintcode.dp;

public class Longest_Continuous_Increasing_Subsequence_397 {

    // DP 数组长度太长时会溢出
//    public int longestIncreasingContinuousSubsequence(int[] A) {
//        if (A == null || A.length == 0) return 0;
//
//        int lics = 0;
//        int[] dp = new int[A.length];
//        for (int i = 0; i < A.length; i++) {
//            if (dp[i] == 0) {
//                lics = Math.max(lics, dfs(A, i, dp));
//            }
//        }
//
//        return lics;
//    }
//
//    private int dfs(int[] A, int i, int[] dp) {
//        if (dp[i] != 0) return dp[i];
//
//        // increasing from xxx to left, right
//        int left = 0, right = 0;
//        // increasing from right to left
//        if (i > 0 && A[i - 1] > A[i]) left = dfs(A, i - 1, dp);
//        // increasing from left to right
//        if (i + 1 < A.length && A[i + 1] > A[i]) right = dfs(A, i + 1, dp);
//
//        dp[i] = 1 + Math.max(left, right);
//        return dp[i];
//    }

    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) return 0;

        int start = 0, licsMax = 1;
        boolean ascending = false;
        for (int i = 1; i < A.length; i++) {
            // ascending order
            if (A[i - 1] < A[i]) {
                if (!ascending) {
                    ascending = true;
                    start = i - 1;
                }
            } else if (A[i - 1] > A[i]) {
                // descending order
                if (ascending) {
                    ascending = false;
                    start = i - 1;
                }
            } else {
                start = i - 1;
            }
            licsMax = Math.max(licsMax, i - start + 1);
        }

        return licsMax;
    }

}
