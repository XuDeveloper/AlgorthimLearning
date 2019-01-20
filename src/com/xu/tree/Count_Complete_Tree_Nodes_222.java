package com.xu.tree;

public class Count_Complete_Tree_Nodes_222 {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count_left = count_length(root.left);
        int count_right = count_length(root.right);
        if (count_left == count_right) {
            return (1 << count_left) + countNodes(root.right);
        } else {
            return (1 << count_right) + countNodes(root.left);
        }
    }

    public int count_length(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
}
