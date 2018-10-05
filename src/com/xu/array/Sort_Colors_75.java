package com.xu.array;

public class Sort_Colors_75 {

    // 三路快排
    public void sortColors1(int[] nums) {
        int n = nums.length;
        int bound1 = -1, // nums[0..bound1]为0
                bound2 = n; // nums[two..n-1]为2
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

    // 计数排序
    public void sortColors2(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
