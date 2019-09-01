package com.xu.dp;

import java.util.Arrays;

public class Maximum_Length_of_Pair_Chain_646 {

    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        Arrays.sort(pairs, (o1, o2) -> o1[0] - o2[0]);
        int length = pairs.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }

}
