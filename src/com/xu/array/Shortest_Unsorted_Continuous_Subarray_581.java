package com.xu.array;

public class Shortest_Unsorted_Continuous_Subarray_581 {

    // 也可复制到一个辅助数组进行排序 一一对比
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        int end = -2;
        int beg = -1;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i - 1]);
            if (max > nums[i]) {
                end = i;
            }
            if (min < nums[len - i - 1]) {
                beg = len - i - 1;
            }
        }
        return end - beg + 1;
    }

}
