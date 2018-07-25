package com.xu.lintcode.binary_search;

import com.xu.tree.TreeNode;

public class Insert_Node_in_a_Binary_Search_Tree_85 {

//    public TreeNode insertNode(TreeNode root, TreeNode node) {
//        // 递归
//        if (root == null) {
//            return node;
//        }
//        if (node.val < root.val) {
//            root.left = insertNode(root.left, node);
//        } else {
//            root.right = insertNode(root.right, node);
//        }
//        return root;
//    }

    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // 迭代
        if (root == null) return node;
        if (node == null) return root;
        TreeNode rootcopy = root;
        while (root != null) {
            if (node.val < root.val && root.left == null) {
                root.left = node;
                break;
            }
            if (node.val >= root.val && root.right == null) {
                root.right = node;
                break;
            }
            if (node.val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return rootcopy;
    }

}
