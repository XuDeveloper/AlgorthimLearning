package com.xu.array;

// 刷过1遍（2019.09.16 ）

public class Maximum_Length_of_Repeated_Subarray_718 {

    public int findLength(int[] A, int[] B) {
        int m = A.length + 1;
        int n = B.length + 1;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

}
