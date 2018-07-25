package com.xu.lintcode.binary_search;

/**
 * !!!!
 */

public class First_Position_of_Target_14 {

    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = -1, end = nums.length;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (target> nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (end == nums.length || nums[end] != target) {
            return -1;
        } else {
            return end;
        }
    }

}
