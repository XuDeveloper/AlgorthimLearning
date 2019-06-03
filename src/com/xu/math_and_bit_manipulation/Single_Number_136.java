package com.xu.math_and_bit_manipulation;

import java.util.HashMap;

// 刷过一遍 （2019.06.04 ）

public class Single_Number_136 {

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    // hashtable解法
    public int singleNumber_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (int key: map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }

}
