package com.xu.array;

import java.util.Arrays;

public class Valid_Triangle_Number_611 {

    public int triangleNumber(int[] nums) {
        int result = 0;
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    result += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

}
