package com.xu.dp;

/**
 * 0-1背包问题（采药问题）（动态规划）
 * 问题：在规定时间t内，采摘总价值最大的草药，并输出最大总价值(草药一共m颗)
 * 输入
 * 第一行:t m (能够采药的总时间t, 山洞里共有的草药株数)
 * 接下来m行：
 * time price
 * time price
 * ...
 * 即每颗草药需要采摘的时间time 每颗草药的价值
 * 输出：
 * 所采摘草药的最大总价值
 */
public class Drug_Collection {

    public static int getValue(int t, int m, int[] val, int[] time) {
        int[] dp = new int[t + 1];
        for (int i = 0; i < m; i++) {
            for (int j = t; j >= time[i]; j--) {
                if (val[i] + dp[j - time[i]] > dp[j]) {
                    dp[j] = val[i] + dp[j - time[i]];
                }
            }
        }
        return dp[t];
    }

    public static void main(String[] args) {
        int t = 70;
        int m = 3;
        int[] val = new int[3];
        val[0] = 100;
        val[1] = 1;
        val[2] = 2;
        int[] time = new int[3];
        time[0] = 71;
        time[1] = 69;
        time[2] = 1;
        System.out.println(getValue(t, m, val, time));
    }

}
