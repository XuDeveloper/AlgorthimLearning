package com.xu.array;

import java.util.Arrays;

public class Maximum_Product_of_Three_Numbers_628 {

    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int n = nums.length;
        int max1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int max2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(max1, max2);
    }
}
