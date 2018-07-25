package com.xu.array;

public class First_Missing_Positive_41 {

    public int firstMissingPositive(int[] nums) {
        if (nums == null) return -1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0
                    && nums[i] <= nums.length
                    && nums[i] != i + 1
                    && (nums[i] != nums[nums[i] - 1])) {

                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return i + 1;
        }

        return 1 + nums.length;
    }

}
