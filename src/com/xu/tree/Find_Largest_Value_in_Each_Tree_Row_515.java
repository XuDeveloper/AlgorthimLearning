package com.xu.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 刷过1遍（2019.10.10 ）

public class Find_Largest_Value_in_Each_Tree_Row_515 {

    // BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < qSize; i++) {
                TreeNode node = queue.poll();
                int value = node.val;
                if (value > max) {
                    max = value;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(max);
        }
        return res;
    }

    // DFS
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> res = new ArrayList<Integer>();
//        helper(root, res, 0);
//        return res;
//    }
//
//    private void helper(TreeNode root, List<Integer> res, int d) {
//        if (root == null) {
//            return;
//        }
//        //expand list size
//        if (d == res.size()) {
//            res.add(root.val);
//        } else {
//            //or set value
//            res.set(d, Math.max(res.get(d), root.val));
//        }
//        helper(root.left, res, d + 1);
//        helper(root.right, res, d + 1);
//    }

}
