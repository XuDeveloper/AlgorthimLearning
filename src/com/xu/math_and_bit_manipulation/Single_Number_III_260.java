package com.xu.math_and_bit_manipulation;

public class Single_Number_III_260 {

    public int[] singleNumber(int[] nums) {
        if (nums.length == 2 && nums[0] != nums[1]) {
            return nums;
        }
        int[] res = new int[2];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        int n = result & (~(result - 1));
        for (int i = 0; i < nums.length; i++) {
            if ((n & nums[i]) != 0) {
                res[0] = res[0] ^ nums[i];
            } else {
                res[1] = res[1] ^ nums[i];
            }
        }
        return res;
    }

}
