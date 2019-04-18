package com.xu.dp;

import java.util.Arrays;

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
        // 动态规划
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][c + 1];
        for (int i = 0; i < c + 1; i++) {
            if (w[0] <= i) {
                dp[0][i] = v[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        return dp[n - 1][c];
    }

    private int[][] memo;

    public int backpack01(int n, int c, int[] w, int[] v) {
        // 记忆化搜索
        memo = new int[n][c + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return bestValue(n, c, w, v, n - 1);
    }

    public int bestValue(int n, int c, int[] w, int[] v, int index) {
        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] != -1) {
            return memo[index][c];
        }
        int res = bestValue(n, c, w, v, index - 1);
        if (w[index] <= c) {
            res = Math.max(res, v[index] + bestValue(n, c - w[index], w, v, index - 1));
        }
        memo[index][c] = res;
        return res;
    }


    public int backpack01_improve1(int n, int c, int[] w, int[] v) {
        // 空间复杂度优化1：由多行变成两行
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[2][c + 1];
        for (int i = 0; i < c + 1; i++) {
            if (w[0] <= i) {
                dp[0][i] = v[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < c + 1; j++) {
                if (w[i] > j) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j];
                } else {
                    dp[i % 2][j] = Math.max(dp[i % 2][j], dp[(i - 1) % 2][j - w[i]] + v[i]);
                }
            }
        }
        return dp[(n - 1) % 2][c];
    }

    public int backpack01_improve2(int n, int c, int[] w, int[] v) {
        // 空间复杂度优化2：由多行变成一行
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[c + 1];
        for (int i = 0; i < c + 1; i++) {
            if (w[0] <= i) {
                dp[i] = v[0];
            } else {
                dp[i] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }
        return dp[c];
    }

}
