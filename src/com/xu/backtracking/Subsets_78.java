package com.xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 刷过1次 （2019.06.09 ）

/**
 * 回溯
 */
public class Subsets_78 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        generateSubsets(nums, 0, new ArrayList<>());
        return res;
    }

    private void generateSubsets(int[] nums, int start, ArrayList<Integer> temp) {
        res.add(new ArrayList<>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            generateSubsets(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
