package com.xu.lintcode.string;

/**
 * 最长公共子序列（不连续）
 * http://baike.baidu.com/view/2020307.htm
 */
public class Longest_Common_Subsequence_77 {

    public int longestCommonSubsequence(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return 0;
        }
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

}
