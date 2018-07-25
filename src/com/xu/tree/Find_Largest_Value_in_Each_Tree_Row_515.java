package com.xu.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find_Largest_Value_in_Each_Tree_Row_515 {

    // BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            int temp = Integer.MIN_VALUE;
            for (int i = 0; i < levelNum; i++) {
                TreeNode treeNode = queue.poll();
                if (temp < treeNode.val) {
                    temp = treeNode.val;
                }
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            list.add(temp);
        }
        return list;
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
