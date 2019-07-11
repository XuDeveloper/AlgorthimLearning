package com.xu.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_ary_Tree_Preorder_Traversal_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            res.add(root.val);
            for (Node node : root.children) {
                res.addAll(preorder(node));
            }
        }
        return res;
    }

    public List<Integer> preorder1(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private void helper(List<Integer> res, Node node) {
        if (node == null) {
            return;
        }
        if (node.children == null || node.children.size() == 0) {
            res.add(node.val);
            return;
        }
        res.add(node.val);
        for (Node temp: node.children) {
            helper(res, temp);
        }
    }

    // stack
    public List<Integer> preorder2(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            if (node.children.size() > 0) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
        }
        return res;
    }

}
