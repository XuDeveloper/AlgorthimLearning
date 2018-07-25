package com.xu.array;

public class Find_Pivot_Index_724 {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int[] presums = new int[nums.length];
        presums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            presums[i] = presums[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (presums[i] - nums[i] == presums[nums.length - 1] - presums[i]) {
                return i;
            }
        }
        return -1;
    }

}
