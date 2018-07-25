package com.xu.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print_Tree_From_Top_to_Bottom_23 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            result.add(node.val);
        }
        return result;
    }

}
