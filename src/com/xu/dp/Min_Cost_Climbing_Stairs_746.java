package com.xu.dp;

public class Min_Cost_Climbing_Stairs_746 {

    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return -1;
        }
        int length = cost.length + 1;
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[length - 1];
    }

    // 空间复杂度优化
    public int minCostClimbingStairs_2(int[] cost) {
        if (cost == null || cost.length == 0) {
            return -1;
        }
        int length = cost.length + 1;
        int dp1 = 0;
        int dp2 = 0;
        int dpn = 0;
        for (int i = 2; i < length; i++) {
            dpn = Math.min(dp2 + cost[i - 1], dp1 + cost[i - 2]);
            dp1 = dp2;
            dp2 = dpn;
        }
        return dpn;
    }

}
