package com.xu.dp;

public class House_Robber_198 {

    public int rob(int[] nums) {
//        int n = nums.length;
//        if (n == 0) {
//            return 0;
//        }
//        // memo[i]表示抢劫nums[i...n-1]
//        int[] memo = new int[n];
//        memo[n - 1] = nums[n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//            for (int j = i; j < n; j++) {
//                memo[i] = Math.max(memo[i], nums[j] + (j + 2 < n ? memo[j + 2] : 0));
//            }
//        }
//        return memo[0];

        // 改变函数定义
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        // memo[i]表示抢劫nums[0...i]
        int[] memo = new int[n];
        memo[0] = nums[0];
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                memo[i] = Math.max(memo[i], nums[j] + (j - 2 >= 0 ? memo[j - 2] : 0));
            }
        }
        return memo[n - 1];
    }

//    private int[] memo;
//
//    // 考虑抢劫nums[index...nums.length)这个范围内的所有房子
//    private int tryRob(int[] nums, int index) {
//        if (index >= nums.length) {
//            return 0;
//        }
//        if (memo[index] != -1) {
//            return memo[index];
//        }
//        int res = 0;
//        for (int i = index; i < nums.length; i++) {
//            res = Math.max(res, nums[i] + tryRob(nums, i + 2));
//        }
//        memo[index] = res;
//        return res;
//    }

}
