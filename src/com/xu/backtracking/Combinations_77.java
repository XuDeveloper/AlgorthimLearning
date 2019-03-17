package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        generateCombination(n, k, 1, list);
        return result;
    }

    private void generateCombination(int n, int k, int start, ArrayList<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        // 优化：
        // 剪枝法
        // 还有k - list.size()个空位，所以[i..n]至少要有k - list.size()个元素
        // i最多为n - (k - list.size()) + 1
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            generateCombination(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
//        for (int i = start; i <= n; i++) {
//            list.add(i);
//            generateCombination(n, k, i + 1, list);
//            list.remove(list.size() - 1);
//        }
    }

}
