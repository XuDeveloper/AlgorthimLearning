package com.xu.dp;

public class Minimum_Cost_For_Tickets_983 {

    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366];
        int n = days.length;
        for (int i = 0; i < n; i++) {
            dp[days[i]] = 1;
        }
        for (int i = 1; i <= 365; i++) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(costs[0] + dp[i - 1],
                        Math.min(costs[1] + dp[Math.max(0, i - 7)],
                                costs[2] + dp[Math.max(0, i - 30)]));
            }
        }
        return dp[days[n - 1]];
    }

}
