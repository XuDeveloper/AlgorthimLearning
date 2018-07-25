package com.xu.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_Search_Tree_Iterator_173 {

    private Queue<Integer> queue;

    public Binary_Search_Tree_Iterator_173(TreeNode root) {
        queue = new LinkedList<>();
        initQueue(root);
    }

    private void initQueue(TreeNode root) {
        if (root == null) {
            return;
        }
        initQueue(root.left);
        queue.offer(root.val);
        initQueue(root.right);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

}
