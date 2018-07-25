package com.xu.array;

public class Remove_Element_27 {

    public int removeElement(int[] nums, int val) {
        int pointer = nums.length - 1;
        int i = 0;
        while (i <= pointer) {
            if (nums[i] == val) {
                nums[i] = nums[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }

}
