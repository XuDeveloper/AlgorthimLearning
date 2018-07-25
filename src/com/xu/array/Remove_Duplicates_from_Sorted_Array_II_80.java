package com.xu.array;

public class Remove_Duplicates_from_Sorted_Array_II_80 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return n;
        int index = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i] != nums[index - 2])
                nums[index++] = nums[i];
        }
        return index;
    }
}
