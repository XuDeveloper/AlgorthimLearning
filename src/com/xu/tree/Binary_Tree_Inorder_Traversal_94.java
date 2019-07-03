package com.xu.tree;

import com.xu.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 刷过一遍 （2019.07.03 ）

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

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        while (cur != null || !stack.isEmpty()) {
//            if (cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            } else {
//                cur = stack.pop();
//                result.add(cur.val);
//                cur = cur.right;
//            }
//        }
//        return result;
//    }

    class Command {
        String s;
        TreeNode node;
        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<Command> stack = new Stack<>();
        Command command = new Command("go", root);
        stack.push(command);
        while (!stack.isEmpty()) {
            Command c = stack.peek();
            stack.pop();
            if (c.s.equals("print")) {
                result.add(c.node.val);
            } else {
                if (c.node.right != null) {
                    stack.push(new Command("go", c.node.right));
                }
                stack.push(new Command("print", c.node));
                if (c.node.left != null) {
                    stack.push(new Command("go", c.node.left));
                }
            }
        }
        return result;
    }

}

