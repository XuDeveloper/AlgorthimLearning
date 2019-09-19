package com.xu.tree;

public class Sum_of_Root_To_Leaf_Binary_Numbers_1022 {

    private int sum;

    public int sumRootToLeaf(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int pre) {
        if (root == null) {
            return;
        }
        pre = 2 * pre + root.val;
        if (root.left == null && root.right == null) {
            sum += pre;
        }
        if (root.left != null) {
            helper(root.left, pre);
        }
        if (root.right != null) {
            helper(root.right, pre);
        }
    }

}
