package com.xu.array;

public class Max_Consecutive_Ones_485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int length = nums.length;
        int result = 0;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 1) {
                result += 1;
            }
            if (result > max) {
                max = result;
            }
            if (nums[i] == 0) {
                result = 0;
            }
        }
        return max;
    }
}
