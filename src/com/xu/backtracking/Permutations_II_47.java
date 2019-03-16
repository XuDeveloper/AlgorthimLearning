package com.xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.jianshu.com/p/db90675cb82b
 */
public class Permutations_II_47 {

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0 || nums == null) return res;

        used = new boolean[len];
        List<Integer> list = new ArrayList<Integer>();

        Arrays.sort(nums);
        generatePermutation(nums, used, list, len);
        return res;
    }

    public void generatePermutation(int[] nums, boolean[] used, List<Integer> list, int len) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 当前位置的数已经在List中了
            if (used[i]) {
                continue;
            }
            // 当前元素与其前一个元素值相同 且 前元素未被加到list中，跳过该元素
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            generatePermutation(nums, used, list, len);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

}
