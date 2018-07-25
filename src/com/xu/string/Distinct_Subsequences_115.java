package com.xu.string;

/**
 * http://blog.csdn.net/cslbupt/article/details/54286571,
 * https://algorithm.yuanbin.me/zh-hans/dynamic_programming/distinct_subsequences.html
 */
public class Distinct_Subsequences_115 {

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= t.length(); i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j <= s.length(); j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i <= t.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[i][j] = dp[i][j - 1];
                if (s.charAt(j - 1) == t.charAt(i - 1)){
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }

}
