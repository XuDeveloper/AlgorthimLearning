package com.xu.array;

public class Missing_Number_268 {

    public int missingNumber(int[] nums) {
        int result = (0 + nums.length) * (nums.length + 1) / 2;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur += nums[i];
        }
        return result - cur;

    }
}
