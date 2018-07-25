package com.xu.tree;

import java.util.Stack;

public class Validate_Binary_Search_Tree_98 {

//    public boolean isValidBST(TreeNode root) {
//        // 递归
//        if (root == null) {
//            return true;
//        }
//        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
//    }
//
//    public boolean helper(TreeNode root, long lower, long higher) {
//        if (root == null) {
//            return true;
//        }
//        if (root.val <= lower || root.val >= higher) {
//            return false;
//        }
//        boolean isLeftValid = helper(root.left, lower, root.val);
//        boolean isRightValid = helper(root.right, root.val, higher);
//        return isLeftValid && isRightValid;
//    }

    public boolean isValidBST(TreeNode root) {
        // 迭代 中序遍历
        if (root == null) {
            return true;
        }
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val <= pre) {
                    return false;
                }
                pre = root.val;
                root = root.right;
            }
        }
        return true;
    }

}
