package com.xu.array;

import java.util.HashMap;

public class Contains_Duplicate_217 {

    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        if (map.size() != nums.length) {
            return true;
        }
        return false;
    }

}
