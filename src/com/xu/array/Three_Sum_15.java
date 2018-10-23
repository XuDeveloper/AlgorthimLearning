package com.xu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.programcreek.com/2012/12/leetcode-3sum/
// https://www.programcreek.com/2013/02/leetcode-4sum-java/

public class Three_Sum_15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int j = i + 1;
                int k = nums.length - 1;

            }
        }
    }

}
