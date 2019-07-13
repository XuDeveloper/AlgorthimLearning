package com.xu.dp;

// 刷过1遍（2019.07.13 ）

public class Longest_Palindromic_Subsequence_516 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            // !!!
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    // 空间优化版！！！！
    public int longestPalindromeSubseq_1(String s) {
        int n = s.length();
        int cur = 0;
        int[][] dp = new int[2][n];
        for (int i = n - 1; i >= 0; i--) {
            // !!!
            dp[cur][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[cur][j] = dp[1 - cur][j - 1] + 2;
                } else {
                    dp[cur][j] = Math.max(dp[1 - cur][j], dp[cur][j - 1]);
                }
            }
            cur = 1 - cur;
        }
        return dp[1 - cur][n - 1];
    }

}
