package com.xu.array;

public class Sort_Colors_75 {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int bound1 = 0, bound2 = n - 1;
        int i = 0;
        while(i <= bound2) {
            while (nums[i] == 2 && bound2 > i) {
                swap(nums, i , bound2);
                bound2--;
            }
            while (nums[i] == 0 && bound1 < i) {
                swap(nums, i , bound1);
                bound1++;
            }
            i++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
