package com.xu.lintcode.array;

public class Median_80 {

    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return Kth(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    }

    public int Kth(int[] nums, int left, int right, int k) {
        int m = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < nums[left]) {
                m++;
                swap(nums, i, m);
            }
        }
        swap(nums, left, m);
        if (k == m + 1) {
            return nums[m];
        } else if (k > m + 1) {
            return Kth(nums, m + 1, right, k);
        } else {
            return Kth(nums, left, m - 1, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
