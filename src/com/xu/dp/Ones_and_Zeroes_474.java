package com.xu.dp;

public class Ones_and_Zeroes_474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < l; i++) {
            int[] nums = getNums(strs[i]);
            for (int j = m; j >= nums[0]; j--) {
                for (int k = n; k >= nums[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - nums[0]][k - nums[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getNums(String str) {
        int[] nums = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                nums[0]++;
            } else {
                nums[1]++;
            }
        }
        return nums;
    }

}
