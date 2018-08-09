package com.xu.dp;

/**
 * 最大K乘积问题（dp）
 *
 * 设l是一个n位十进制整数。如果将l划分为k段，则可得到k个整数。这k个整数的乘数称为l的一个k乘积。
 *
 * 试设计一个算法，对给定的l和k，求出l的最大k乘积。
 *
 */
public class Max_K {

    public int getMax(int l, int n, int k) {
        int[] single = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int t = 1;
            for (int j = 1; j <= n - i; j++) {
                t *= 10;
            }
            single[i] = l / t;
            l %= t;
        }
        int[][] number = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            number[i][i] = single[i];
            for (int j = i + 1; j <= n; j++) {
                number[i][j] = number[i][j - 1] * 10 + single[j];
            }
        }
        // dp[i][j] 长度为i 切j段得到的最大乘积
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = number[1][i];
            for (int j = 2; j <= k; j++) {
                int max = 0;
                for (int m = 1; m < i; m++) {
                    int temp = dp[i][j - 1] * number[m + 1][i];
                    if (temp > max) {
                        max = temp;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[n][k];
    }

}
