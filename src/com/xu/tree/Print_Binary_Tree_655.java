package com.xu.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Print_Binary_Tree_655 {

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        for (String[] arr : res) {
            Arrays.fill(arr, "");
        }
        List<List<String>> result = new ArrayList<>();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr : res) {
            // 你试试写成 ret.add(list) 最后返回的结果是什么，需要 new 一个的原因在于 list 是可变对象，你加进去的时候只是指向对象的引用。
            result.add(Arrays.asList(arr));
        }
        return result;
    }

    private void fill(String[][] res, TreeNode root, int i, int j, int k) {
        if (root == null) {
            return;
        }
        res[i][(j + k) / 2] = "" + root.val;
        fill(res, root.left, i + 1, j, (j + k) / 2);
        fill(res, root.right, i + 1, (j + k + 1) / 2, k);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

}
