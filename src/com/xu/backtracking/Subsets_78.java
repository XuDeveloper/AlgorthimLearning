package com.xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回溯
 */
public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if (nums == null) {
            return results;
        }

        if (nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }

        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }

    public void helper(int[] nums, int startIndex, List<Integer> cur, List<List<Integer>> result) {
        result.add(new ArrayList<>(cur));
        for (int i = startIndex; i < nums.length; i++) {
            cur.add(nums[i]);
            helper(nums, i + 1, cur, result);
            cur.remove(cur.size() - 1);
        }
    }
}
