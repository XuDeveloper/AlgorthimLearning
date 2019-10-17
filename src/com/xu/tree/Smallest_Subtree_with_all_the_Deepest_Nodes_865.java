package com.xu.tree;

import javafx.util.Pair;

public class Smallest_Subtree_with_all_the_Deepest_Nodes_865 {

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair<Integer, TreeNode> pair = dfs(root);
        return pair.getValue();
    }

    private Pair<Integer, TreeNode> dfs(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, null);
        }
        Pair<Integer, TreeNode> left = dfs(root.left);
        Pair<Integer, TreeNode> right = dfs(root.right);
        int lDepth = left.getKey();
        int rDepth = right.getKey();
        int depth = Math.max(lDepth, rDepth) + 1;
        if (lDepth == rDepth) {
            return new Pair<>(depth, root);
        } else if (lDepth > rDepth) {
            return new Pair<>(depth, left.getValue());
        } else {
            return new Pair<>(depth, right.getValue());
        }
    }

}
