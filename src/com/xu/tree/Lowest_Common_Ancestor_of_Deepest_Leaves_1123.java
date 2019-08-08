package com.xu.tree;

public class Lowest_Common_Ancestor_of_Deepest_Leaves_1123 {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (left == right) {
            return root;
        } else {
            return left > right ? lcaDeepestLeaves(root.left) : lcaDeepestLeaves(root.right);
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return 1 + Math.max(left, right);
    }

}
