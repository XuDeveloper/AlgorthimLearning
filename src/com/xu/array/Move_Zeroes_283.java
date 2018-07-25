package com.xu.array;

public class Move_Zeroes_283 {

    public void moveZeroes(int[] nums) {
        int n = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else  {
                nums[n] = nums[i];
                n++;
            }
        }
        for (int j = 0; j < count; j++) {
            nums[n] = 0;
            n++;
        }
    }
}
