package com.xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 刷过1遍（2019.07.28 ）

/**
 * https://www.jianshu.com/p/db90675cb82b
 */
public class Permutations_II_47 {

    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        generatePermutation(nums, used, new ArrayList<>());
        return res;
    }

    public void generatePermutation(int[] nums, boolean[] used, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            generatePermutation(nums, used, temp);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

}
