package com.xu.tree;

import java.util.Deque;
import java.util.LinkedList;

// 看过一遍 （2019.07.04 ）

public class Maximum_Depth_of_Binary_Tree_104 {

//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        return left > right ? left + 1: right + 1;
//    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }

}
