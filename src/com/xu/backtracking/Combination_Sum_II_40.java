package com.xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length < 1)
            return res;
        Arrays.sort(candidates);

        backtrack(candidates, target, res, new ArrayList<Integer>(), 0);

        return res;
    }

    // 如果不加参数start，会出现：input:[2,3,6,7]7
    // 结果：[[2,2,3],[2,3,2],[3,2,2],[7]]instead of [[2,2,3],[7]]的情况
    private void backtrack(int[] nums, int target, List<List<Integer>> res, ArrayList<Integer> list, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i < nums.length && target >= nums[i]; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            backtrack(nums, target - nums[i], res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
