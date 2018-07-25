package com.xu.tree;

import java.util.ArrayList;
import java.util.List;

public class Maximum_Width_of_Binary_Tree_662 {

    List<Integer> start = new ArrayList<>();
    List<Integer> end = new ArrayList<>();

    public int widthOfBinaryTree(TreeNode root) {
        return helper(root, 0, 1);
    }

    private int helper(TreeNode root, int level, int order) {
        if (root == null) {
            return 0;
        }
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else {
            end.set(level, order);
        }
        int cur = end.get(level) - start.get(level) + 1;
        int left = helper(root.left, level + 1, 2 * order);
        int right = helper(root.right, level + 1, 2 * order + 1);
        return Math.max(cur, Math.max(left, right));
    }

}
