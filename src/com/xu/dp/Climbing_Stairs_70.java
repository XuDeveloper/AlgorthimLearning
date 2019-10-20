package com.xu.dp;

// 刷过1遍（2019.10.19 ）

public class Climbing_Stairs_70 {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs1(int n) {
        int i1 = 1;
        int i2 = 1;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res = i1 + i2;
            i2 = i1;
            i1 = res;
        }
        return res;
    }

}
