package com.xu.array;

public class Search_in_Rotated_Sorted_Array_33 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = 0, ub = nums.length - 1;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] == target) return mid;
            if (nums[lb] < nums[mid]) {
                if (nums[lb] <= target && target <= nums[mid]) {
                    ub = mid;
                } else {
                    lb = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[ub]) {
                    lb = mid;
                } else {
                    ub = mid;
                }
            }
        }
        if (nums[lb] == target) {
            return lb;
        } else if (nums[ub] == target) {
            return ub;
        }
        return -1;
    }

}
