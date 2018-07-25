package com.xu.tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {

    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return result;
        }
        findPath(root, root.val + "");
        return result;
    }

    private void findPath(TreeNode root, String path) {
        if (root.left == null && root.right == null) {
            result.add(path);
        }
        if (root.left != null) {
            findPath(root.left, path + "->" + root.left.val);
        }
        if (root.right != null) {
            findPath(root.right, path + "->" + root.right.val);
        }
    }

}
