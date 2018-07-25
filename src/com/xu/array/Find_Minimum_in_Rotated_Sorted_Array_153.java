package com.xu.array;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        while (left <= right) {
            if (right - left == 1) {
                return nums[right];
            }

            int m = left + (right - left) / 2;

            if (nums[m] > nums[right])
                left = m;
            else
                right = m;
        }
        return nums[left];
    }
}
