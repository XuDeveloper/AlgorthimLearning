package com.xu.tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Paths_257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            result.add(String.valueOf(root.val));
            return result;
        }
        List<String> left = binaryTreePaths(root.left);
        for (int i = 0; i < left.size(); i++) {
            result.add(root.val + "->" + left.get(i));
        }
        List<String> right = binaryTreePaths(root.right);
        for (int i = 0; i < right.size(); i++) {
            result.add(root.val + "->" + right.get(i));
        }
        return result;
    }

//    public List<String> binaryTreePaths(TreeNode root) {
//        if (root == null) {
//            return result;
//        }
//        findPath(root, root.val + "");
//        return result;
//    }
//
//    private void findPath(TreeNode root, String path) {
//        if (root.left == null && root.right == null) {
//            result.add(path);
//        }
//        if (root.left != null) {
//            findPath(root.left, path + "->" + root.left.val);
//        }
//        if (root.right != null) {
//            findPath(root.right, path + "->" + root.right.val);
//        }
//    }

}
