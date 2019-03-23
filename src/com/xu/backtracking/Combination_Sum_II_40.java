package com.xu.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_II_40 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length < 1)
            return res;
        Arrays.sort(candidates);
        generateCombination(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    private void generateCombination(int[] candidates, int target, int start, ArrayList<Integer> temp) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
            // !!!
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            generateCombination(candidates, target - candidates[i], i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
