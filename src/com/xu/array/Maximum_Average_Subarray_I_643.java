package com.xu.array;

public class Maximum_Average_Subarray_I_643 {

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, sumMax;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        sumMax = sum;
        for (int i = k; i < nums.length; i++) {
            sum += (nums[i] - nums[i - k]);
            sumMax = Math.max(sum, sumMax);
        }
        return (double) sumMax / k;
    }

}
