package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(n, k, 1, list, result);
        return result;
    }

    private void dfs(int n, int k, int pos, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos; i <= n; i++) {
            temp.add(i);
            dfs(n, k, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

}
