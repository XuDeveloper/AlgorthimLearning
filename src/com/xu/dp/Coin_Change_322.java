package com.xu.dp;

import java.util.Arrays;

public class Coin_Change_322 {

    public int coinChange2(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i == coin) {
                    dp[i] = 1;
                } else if (i > coin) {
                    if (dp[i - coin] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[amount];
    }

    private int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        return tryCoinChange(coins, amount);
    }

    private int tryCoinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int tmp = tryCoinChange(coins, amount - coin);
            if (tmp >= 0) {
                res = Math.min(res, tmp + 1);
            }
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }

}
