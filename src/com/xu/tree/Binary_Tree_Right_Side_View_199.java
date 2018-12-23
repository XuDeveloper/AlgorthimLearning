package com.xu.tree;

import java.util.*;

public class Binary_Tree_Right_Side_View_199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int qLen = q.size();
            result.add(q.getLast().val);
            for (int i = 0; i < qLen; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }

        return result;
    }

}
