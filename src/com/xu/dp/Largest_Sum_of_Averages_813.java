package com.xu.dp;

public class Largest_Sum_of_Averages_813 {

    public double largestSumOfAverages(int[] A, int K) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int len = A.length;
        double[] sum = new double[len + 1];
        double[][] dp = new double[K + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + A[i - 1];
            dp[1][i] = sum[i] / i;
        }
        for (int k = 2; k <= K; k++) {
            for (int i = k; i <= len; i++) {
                for (int j = k - 1; j < i; j++) {
                    dp[k][i] = Math.max(dp[k][i], dp[k - 1][j] + (sum[i] - sum[j]) / (i - j));
                }
            }
        }
        return dp[K][len];
    }

}
