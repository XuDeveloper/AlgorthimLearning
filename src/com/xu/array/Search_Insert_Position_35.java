package com.xu.array;

public class Search_Insert_Position_35 {

    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        if (target < nums[0]) {
            return 0;
        }
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[end] == target) {
            return end;
        }
        if (nums[end] < target) {
            return end + 1;
        }
        if (nums[start] == target) {
            return start;
        }
        return start + 1;
    }

}
