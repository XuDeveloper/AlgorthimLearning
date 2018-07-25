package com.xu.tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_102 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        addToLevelList(root, 0);
        return result;
    }

    public void addToLevelList(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() < depth + 1) {
            result.add(depth, new ArrayList<>());
        }
        result.get(depth).add(root.val);
        depth++;
        if (root.left != null) {
            addToLevelList(root.left, depth);
        }
        if (root.right != null) {
            addToLevelList(root.right, depth);
        }
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if (root == null) return result;
//
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        q.offer(root);
//        while (!q.isEmpty()) {
//            List<Integer> list = new ArrayList<Integer>();
//            int qSize = q.size();
//            for (int i = 0; i < qSize; i++) {
//                TreeNode node = q.poll();
//                list.add(node.val);
//                // push child node into queue
//                if (node.left != null) q.offer(node.left);
//                if (node.right != null) q.offer(node.right);
//            }
//            result.add(new ArrayList<Integer>(list));
//        }
//
//        return result;
//    }
}
