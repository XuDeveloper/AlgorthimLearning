package com.xu.array;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_III_216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        helper(result, curr, k, 1, n);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> cur, int k, int start, int sum) {
        if (sum < 0) {
            return;
        }
        if (sum == 0 && cur.size() == k) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for (int i = start; i <= 9; i++) {
            cur.add(i);
            helper(result, cur, k, i + 1, sum - i);
            cur.remove(cur.size() - 1);
        }
    }
}
