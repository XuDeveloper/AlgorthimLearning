package com.xu.lintcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Subarray_Sum_138 {

    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int curSum = 0;
        map.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (map.containsKey(curSum)) {
                result.add(map.get(curSum));
                result.add(i);
                return result;
            } else {
                map.put(curSum, i + 1);
            }
        }
        return result;
    }

}
