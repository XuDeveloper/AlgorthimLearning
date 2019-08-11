package com.xu.lintcode.string;

/**
 * 最长公共子串（连续）
 * http://baike.baidu.com/view/2020307.htm
 */
public class Longest_Common_Substring_79 {

    public int longestCommonSubstring(String A, String B) {
        if (A == null || A.isEmpty() || B == null || B.isEmpty()) {
            return 0;
        }
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                }
            }
        }
        // find max lcs
        int lcs = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i][j] > lcs) lcs = dp[i][j];
            }
        }
        return lcs;
    }

}
