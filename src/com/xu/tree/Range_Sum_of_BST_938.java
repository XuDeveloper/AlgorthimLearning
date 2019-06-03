package com.xu.tree;

public class Range_Sum_of_BST_938 {

    private int res;

    public int rangeSumBST(TreeNode root, int L, int R) {
        getSumBST(root, L, R);
        return res;
    }

    private void getSumBST(TreeNode node, int L, int R) {
        if (node == null) {
            return;
        }
        if (node.val >= L && node.val <= R) {
            res += node.val;
            getSumBST(node.left, L, R);
            getSumBST(node.right, L, R);
        }
        if (node.val < L) {
            getSumBST(node.right, L, R);
        }
        if (node.val > R) {
            getSumBST(node.left, L, R);
        }
    }

}
