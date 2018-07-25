package com.xu.tree;

/**
 * https://algorithm.yuanbin.me/zh-hans/math_and_bit_manipulation/unique_binary_search_trees.html
 */
public class Unique_Binary_Search_Trees_96 {

    public int numTrees(int n) {
        if (n < 0) {
            return -1;
        }

        int[] count = new int[n + 1];
        count[0] = 1;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 0; j < i; ++j) {
                count[i] += count[j] * count[i - j - 1];
            }
        }

        return count[n];
    }

}
