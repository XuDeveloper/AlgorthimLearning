package com.xu.tree;

public class Sum_of_Left_Leaves_404 {

    public int sumOfLeftLeaves(TreeNode root) {
        int res = 0;
        if (root != null) {
            if (isLeaf(root.left)) {
                res += root.left.val;
            } else {
                res += sumOfLeftLeaves(root.left);
            }
            res += sumOfLeftLeaves(root.right);
        }
        return res;
    }

    public boolean isLeaf(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return true;
        }
        return false;
    }

}
