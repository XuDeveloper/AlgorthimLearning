package com.xu.tree;

public class Balanced_Binary_Tree_110 {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = depth(root.left);
        int right = depth(root.right);
        if (left - right > 1 || left - right < -1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    /**
     * 求树的高度
     *
     * @param n 树的根结点
     * @return 树的高度
     */
    private int depth(TreeNode n) {
        if (n == null) {
            return 0;
        }
        if (n.left == null && n.right == null) {
            return 1;
        } else {
            int left = depth(n.left);
            int right = depth(n.right);
            return 1 + (left > right ? left : right);
        }
    }

}
