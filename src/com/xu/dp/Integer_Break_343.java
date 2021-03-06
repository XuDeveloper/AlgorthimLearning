package com.xu.dp;

import java.util.Arrays;

// 刷过2遍（2019.07.06, 2019.09.14）

public class Integer_Break_343 {

    public int integerBreak(int n) {
//        memo = new int[n + 1];
//        Arrays.fill(memo, -1);
//        return breakInteger(n);
        // 动态规划
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    // 记忆化搜索（自顶向下）
    private int[] memo;

    // 将n进行分隔（至少分隔两部分），可以获得的最大乘积
    private int breakInteger(int n) {
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            return memo[n];
        }
        int res = -1;
        for (int i = 1; i <= n - 1; i++) {
            res = Math.max(res, Math.max(i * (n - i), i * breakInteger(n - i)));
        }
        memo[n] = res;
        return res;
    }

}
