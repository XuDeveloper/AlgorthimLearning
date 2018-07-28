package com.xu.dp;

/**
 * 游艇俱乐部在长江上设置了n个游艇出租站。游客可在这些游艇出租站
 * 出租游艇，并在下游的任何一个游艇出租站归还游艇。
 * 游艇出租站i到游艇出租站j之间的租金为r(i, j)
 * 第一行为n，表示有n个游艇出租站。接下来的n-1行是r(i, j)
 * 输出从1到n所需的最少租金
 */
public class Rent_Boat {

    public int rent(int n, int[][] r) {
        int[] dp = new int[n + 1];
        dp[1] = r[1][1];
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + r[j][i]);
            }
        }
        return dp[n];
    }

}
