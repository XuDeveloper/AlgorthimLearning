package com.xu.array;

public class Minimum_Size_Subarray_Sum_209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (start < nums.length && end < nums.length) {
            while (sum < s && end < nums.length) {
                sum += nums[end++];
            }
            while (sum >= s && start <= end) {
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }
        return min == Integer.MAX_VALUE ? 0: min;
    }

}
