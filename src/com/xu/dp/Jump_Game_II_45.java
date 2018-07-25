package com.xu.dp;

public class Jump_Game_II_45 {

    public int jump(int[] nums) {
        // version 1: Dynamic Programming
        // 这个方法，复杂度是 O(n^2)，会超时，但是依然需要掌握。
        // state
        int[] steps = new int[nums.length];

        // initialize
        steps[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            steps[i] = Integer.MAX_VALUE;
        }

        // function
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + nums[j] >= i) {
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
            }
        }

        // answer
        return steps[nums.length - 1];
    }

//    // Greedy
//    public int jump(int[] A) {
//        if (A == null || A.length == 0) {
//            return -1;
//        }
//        int start = 0, end = 0, jumps = 0;
//        while (end < A.length - 1) {
//            jumps++;
//            int farthest = end;
//            for (int i = start; i <= end; i++) {
//                if (A[i] + i > farthest) {
//                    farthest = A[i] + i;
//                }
//            }
//            start = end + 1;
//            end = farthest;
//        }
//        return jumps;
//    }

}
