package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

// 刷过2次 （2019.06.02，2019.10.06）

/**
 *  http://blog.csdn.net/happyaaaaaaaaaaa/article/details/51534048
 */
public class Permutations_46 {

    // 最终返回的结果集
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    // 判断是否被使用过
    boolean[] used;

    // 解法1
//    public List<List<Integer>> permute(int[] nums) {
//        int len = nums.length;
//        if (len == 0 || nums == null) return res;
//
//        // 采用前后元素交换的办法，dfs解题
//        exchange(nums, 0, len);
//        return res;
//    }
//
//    public void exchange(int[] nums, int i, int len) {
//        if (i == len - 1) {
//            ArrayList<Integer> list = new ArrayList<>();
//            for (int j = 0; j < len; j++) {
//                list.add(nums[j]);
//            }
//            res.add(list);
//            return;
//        }
//        for (int j = i; j < len; j++) {
//            swap(nums, i, j);
//            exchange(nums, i + 1, len);
//            swap(nums, i, j);
//        }
//    }
//
//    public void swap(int[] nums, int i, int j) {
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        generatePermutation(nums, new ArrayList<>());
        return res;
    }

    public void generatePermutation(int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                temp.add(nums[i]);
                generatePermutation(nums, temp);
                temp.remove(temp.size() - 1);
                used[i] = false;
            }
        }
    }

}
