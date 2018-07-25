package com.xu.binary_search;

public class Search_for_a_Range_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        int lb = -1, ub = nums.length;
        int mid;
        while (lb + 1 < ub) {
            mid = lb + (ub - lb) / 2;
            if (nums[mid] < target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }
        // whether A[lb + 1] == target, check lb + 1 first
        if ((lb + 1 < nums.length) && (nums[lb + 1] == target)) {
            result[0] = lb + 1;
        } else {
            result[0] = -1;
            result[1] = -1;
            // target is not in the array
            return result;
        }

        // upper bound, since ub >= lb, we do not reset lb
        ub = nums.length;
        while (lb + 1 < ub) {
            mid = lb + (ub - lb) / 2;
            if (nums[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }
        // target must exist in the array
        result[1] = ub - 1;

        return result;
    }

}
