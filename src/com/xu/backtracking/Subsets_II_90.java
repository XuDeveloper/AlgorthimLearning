package com.xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_II_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //回溯法
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        List<Integer> tmp = new ArrayList<Integer>();
        helper(result, tmp, 0, nums);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> tmp, int start, int[] nums) {
        if (!result.contains(tmp)) {
            result.add(new ArrayList<>(tmp));
        }
        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            helper(result, tmp, i + 1, nums);
            tmp.remove(tmp.size() - 1);
        }

        // or
//        if (i != pos && nums[i] == nums[i - 1]) {
//            continue;
//        }
    }

}
