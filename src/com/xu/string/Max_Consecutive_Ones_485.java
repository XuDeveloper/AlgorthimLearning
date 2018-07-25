package com.xu.string;

public class Max_Consecutive_Ones_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                max = count > max ? count : max;
                count = 0;
            }
        }
        return count > max ? count : max;
    }
}
