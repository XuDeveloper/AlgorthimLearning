package com.xu.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Contains_Duplicate_II_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 滑动窗口加查找表
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            // 保持record中最多有k个数
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

//    int len = nums.length;
//        if (nums == null || nums.length == 0) {
//        return false;
//    }
//    Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//        if (map.containsKey(nums[i])) {
//            if (i - map.get(nums[i]) <= k) {
//                return true;
//            }
//            map.put(nums[i], i);
//        } else {
//            map.put(nums[i], i);
//        }
//
//    }
//    return false;
}
