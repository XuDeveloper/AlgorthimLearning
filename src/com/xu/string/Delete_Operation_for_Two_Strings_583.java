package com.xu.string;

public class Delete_Operation_for_Two_Strings_583 {

    public int minDistance(String word1, String word2) {
        int common = lcs(word1, word2);
        return word1.length() + word2.length() - 2 * common;
    }

    public int lcs(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int max = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

}
