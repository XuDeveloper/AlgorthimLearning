package com.xu.tree;

import java.util.Stack;

public class Minimum_Absolute_Difference_in_BST_530 {

//    private int min = Integer.MAX_VALUE;
//    private TreeNode prev = null;
//
//    // 结合中序遍历
//
//    public int getMinimumDifference(TreeNode root) {
//        // 递归
//        if (root == null) {
//            return min;
//        }
//        getMinimumDifference(root.left);
//        if (prev != null) {
//            min = Math.min(min, root.val - prev.val);
//        }
//        prev = root;
//        getMinimumDifference(root.right);
//        return min;
//    }

    public int getMinimumDifference(TreeNode root) {
        // 迭代
        int min = Integer.MAX_VALUE;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (prev != null) {
                    min = Math.min(min, root.val - prev.val);
                }
                prev = root;
                root = root.right;
            }
        }
        return min;
    }

}
