package com.xu.math_and_bit_manipulation;

public class Single_Number_136 {

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

}
