package com.xu.tree;

import java.util.*;

public class Binary_Tree_Zigzag_Level_Order_Traversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean flag = true;
        while (!q.isEmpty()) {
            int qLen = q.size();
            ArrayList<Integer> aList = new ArrayList<>();
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                aList.add(node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            if (flag) {
                Collections.reverse(aList);
            }
            flag = !flag;
            result.add(aList);
        }

        return result;
    }

}
