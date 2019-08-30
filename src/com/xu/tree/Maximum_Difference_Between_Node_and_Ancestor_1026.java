package com.xu.tree;

public class Maximum_Difference_Between_Node_and_Ancestor_1026 {

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = helper(root.left, root.val, root.val);
        int r = helper(root.right, root.val, root.val);
        return Math.max(l, r);
    }

    public int helper(TreeNode root, int min, int max) {
        if (root == null) {
            return max - min;
        }
        if (root.val > max) {
            max = root.val;
        }
        if (root.val < min) {
            min = root.val;
        }
        int left = helper(root.left, min, max);
        int right = helper(root.right, min, max);
        return Math.max(left, right);
    }

}
