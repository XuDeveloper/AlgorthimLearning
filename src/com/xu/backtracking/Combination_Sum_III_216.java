package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III_216 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (n == 0 || k == 0) {
            return res;
        }
        generateCombination(k, n, 1, new ArrayList<>());
        return res;
    }

    private void generateCombination(int k, int n, int start, ArrayList<Integer> temp) {
        if (temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            generateCombination(k, n - i, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

}
