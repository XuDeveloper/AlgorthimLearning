package com.xu.array;

public class Minimum_Size_Subarray_Sum_209 {

    public int minSubArrayLen(int s, int[] nums) {
        int l = 0, r = -1; // [l...r]
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) { // 边界问题
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }

}
