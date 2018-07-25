package com.xu.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length < 1)
            return res;
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<>(), res);

        return res;
    }

    public void helper(int[] nums, int start, int target, List<Integer> cur, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(cur);
            return;
        }
        //加上target >= nums[i]：33ms to 23ms
        for (int i = start; i < nums.length && target >= nums[i]; i++) {
            cur.add(nums[i]);
            helper(nums, i, target - nums[i], new ArrayList<Integer>(cur), result);
            cur.remove(cur.size() - 1);
        }
    }

}
