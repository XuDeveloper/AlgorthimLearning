package com.xu.tree;

public class Binary_Tree_Tilt_563 {

    int res = 0;

    public int findTilt(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        res += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

}
