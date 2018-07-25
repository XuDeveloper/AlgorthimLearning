package com.xu.tree;

import com.xu.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历 先左后根再右
 */
public class Binary_Tree_Inorder_Traversal_94 {

//    public List<Integer> inorderTraversal(TreeNode root) {
//        ArrayList<Integer> list = new ArrayList<>();
//        inOrder(list, root);
//        return list;
//    }
//
//    public void inOrder(List<Integer> list, TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        if (node.left != null) {
//            inOrder(list, node.left);
//        }
//        list.add(node.val);
//        if (node.right != null) {
//            inOrder(list, node.right);
//        }
//    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }

}

