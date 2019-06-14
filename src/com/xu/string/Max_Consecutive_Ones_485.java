package com.xu.string;

// 刷过1遍 （2019.06.14 ）

public class Max_Consecutive_Ones_485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                res = count > res ? count : res;
                count = 0;
            }
        }
        return count > res ? count : res;
    }
}
