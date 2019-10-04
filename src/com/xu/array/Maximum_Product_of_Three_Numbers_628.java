package com.xu.array;

import java.util.Arrays;

// 刷过1遍（2019.10.04 ）

public class Maximum_Product_of_Three_Numbers_628 {

    public int maximumProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE, thirdMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n > thirdMax) {
                firstMax = secondMax;
                secondMax = thirdMax;
                thirdMax = n;
            } else if (n > secondMax) {
                firstMax = secondMax;
                secondMax = n;
            } else if (n > firstMax) {
                firstMax = n;
            }
            if (n < secondMin) {
                firstMin = secondMin;
                secondMin = n;
            } else if (n < firstMin) {
                firstMin = n;
            }
        }
        return Math.max(firstMax * secondMax * thirdMax, firstMin * secondMin * thirdMax);
    }

    public int maximumProduct2(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int n = nums.length;
        int max1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int max2 = nums[0] * nums[1] * nums[n - 1];
        return Math.max(max1, max2);
    }

}
