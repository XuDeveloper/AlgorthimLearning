package com.xu.dp;

/**
 * 01背包问题
 */
public class Backpack_01 {

    /**
     *
     * @param n 物品总数
     * @param c 总容量
     * @param w 每件物品的容量
     * @param v 每件物品的价值
     * @return 最大价值
     */
    public int getBest(int n, int c, int[] w, int[] v) {
        // dp(i, j)表示从i到n的物品里选择总重量不超过j时的最大价值
        int[][] dp = new int[n + 1][c + 1];
        for (int j = 0; j <= c; j++) {
            if (w[n] > j) {
                dp[n][j] = 0;
            } else {
                dp[n][j] = v[n];
            }
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 0; j <= c; j++) {
                if (w[i] > j) {
                    dp[i][j] = dp[i + 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[1][c];
    }

}
