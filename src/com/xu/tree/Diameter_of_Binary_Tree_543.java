package com.xu.tree;

public class Diameter_of_Binary_Tree_543 {

    private int max;

    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return max;
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

}
