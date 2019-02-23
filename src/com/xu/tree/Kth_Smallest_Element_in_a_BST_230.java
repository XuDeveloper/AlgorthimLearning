package com.xu.tree;

import java.util.Stack;

public class Kth_Smallest_Element_in_a_BST_230 {

    private int count;
    private int res;

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root, k);
        return res;
    }

    public void inOrder(TreeNode root, int k) {
        if (root == null || count >= k) {
            return;
        }
        inOrder(root.left, k);
        count++;
        if (count == k) {
            res = root.val;
        }
        inOrder(root.right, k);
    }

    // 非递归
    public TreeNode KthSmallest(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (pRoot == null || k == 0) return null;
        int t = 0;
        while (pRoot != null || !stack.isEmpty()) {
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (stack.size() > 0) {
                pRoot = stack.pop();
                t++;
                if (t == k) return pRoot;
                pRoot = pRoot.right;
            }
        }
        return null;
    }
}
