package com.xu.array;

public class Find_Minimum_in_Rotated_Sorted_Array_II_154 {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                left++;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
