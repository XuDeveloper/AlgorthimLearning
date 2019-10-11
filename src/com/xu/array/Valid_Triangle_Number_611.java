package com.xu.array;

import java.util.Arrays;

// 刷过1遍（2019.10.11 ）

public class Valid_Triangle_Number_611 {

    // https://www.cnblogs.com/grandyang/p/7053730.html
    public int triangleNumber(int[] nums) {
        int res = 0;
        if (nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                if (nums[left] + nums[right] > nums[i]) {
                    res += (right - left);
                    right--;
                } else {
                    left++;
                }
            }
        }
        return res;
    }

}
