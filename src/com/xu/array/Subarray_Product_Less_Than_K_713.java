package com.xu.array;

/**
 * http://blog.csdn.net/dashenxueba/article/details/78442100
 */
public class Subarray_Product_Less_Than_K_713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int res = 0, prod = 1, left = 0;
        for (int i = 0; i < nums.length; ++i) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[left++];
            }
            res += i - left + 1;
        }
        return res;
    }
}
