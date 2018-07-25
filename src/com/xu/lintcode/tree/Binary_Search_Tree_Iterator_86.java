package com.xu.lintcode.tree;

import com.xu.tree.TreeNode;

import java.util.Stack;

public class Binary_Search_Tree_Iterator_86 {

    /**
     * Definition of TreeNode:
     * public class TreeNode {
     *     public int val;
     *     public TreeNode left, right;
     *     public TreeNode(int val) {
     *         this.val = val;
     *         this.left = this.right = null;
     *     }
     * }
     * Example of iterate a tree:
     * BSTIterator iterator = new BSTIterator(root);
     * while (iterator.hasNext()) {
     *    TreeNode node = iterator.next();
     *    do something for node
     * }
     */


    public class BSTIterator {

        private Stack<TreeNode> stack;
        private TreeNode cur;

        /*
         * @param root: The root of binary tree.
         */
        public BSTIterator(TreeNode root) {
            // do intialization if necessary
            stack = new Stack<>();
            cur = root;
        }

        /*
         * @return: True if there has next node, or false
         */
        public boolean hasNext() {
            // write your code here
            return cur != null || !stack.isEmpty();
        }

        /*
         * @return: return next node
         */
        public TreeNode next() {
            // write your code here
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            TreeNode node = cur;
            cur = cur.right;
            return node;
        }
    }

}
