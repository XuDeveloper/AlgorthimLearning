package com.xu.dp;

public class Delete_and_Earn_740 {

    // https://leetcode.com/problems/delete-and-earn/discuss/257344/Easy-Java-solution-explained
    // https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-740-delete-and-earn/
    public int deleteAndEarn(int[] nums) {
        int length = 10001;
        int[] dp = new int[length];
        int[] totalPointsForNum = new int[length];
        for (int num: nums) {
            totalPointsForNum[num] = totalPointsForNum[num] + num;
        }
        dp[0] = 0;
        dp[1] = totalPointsForNum[1];
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 1], totalPointsForNum[i] + dp[i - 2]);
        }
        return dp[length - 1];
    }

}
