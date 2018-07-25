package com.xu.tree;

public class Maximum_Binary_Tree_654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }

    public TreeNode construct(int[] nums, int l, int r) {
        if (l == r) {
            return null;
        }
        int max_i = max(nums, l, r);
        TreeNode treeNode = new TreeNode(nums[max_i]);
        treeNode.left = construct(nums, l, max_i);
        treeNode.right = construct(nums, max_i + 1, r);
        return treeNode;
    }

    public int max(int[] nums, int l, int r) {
        int max_i = l;
        for (int i = l; i < r; i++) {
            if (nums[max_i] < nums[i])
                max_i = i;
        }
        return max_i;
    }

}



