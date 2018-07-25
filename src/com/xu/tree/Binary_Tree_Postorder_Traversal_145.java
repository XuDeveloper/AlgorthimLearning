package com.xu.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历 先左后右再根
 */
public class Binary_Tree_Postorder_Traversal_145 {

    private List<Integer> resultList = new ArrayList<>();
//
//    // 递归
//    public List<Integer> postorderTraversal(TreeNode root) {
//        postOrder(root);
//        return result;
//    }
//
//    private void postOrder(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        if (node.left != null) {
//            postOrder(node.left);
//        }
//        if (node.right != null) {
//            postOrder(node.right);
//        }
//        result.add(node.val);
//    }

    private List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return resultList;
        }
        Stack<WrapperNode> stack = new Stack<>();
        stack.push(new WrapperNode(root, false));
        WrapperNode wrapperNode = null;
        while (!stack.isEmpty()) {
            wrapperNode = stack.peek();
            if (wrapperNode.node == null) {
                stack.pop();
                continue;
            }
            if (wrapperNode.isFinished) {
                resultList.add(stack.pop().node.val);
            } else {
                stack.push(new WrapperNode(wrapperNode.node.right, false));
                stack.push(new WrapperNode(wrapperNode.node.left, false));
                wrapperNode.isFinished = true;
            }
        }
        return resultList;
    }

    private static class WrapperNode {
        TreeNode node;
        boolean isFinished;

        public WrapperNode(TreeNode node, boolean isFinished) {
            this.node = node;
            this.isFinished = isFinished;
        }
    }

//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<Integer>();
//        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
//        if (root != null) stack.push(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode curr = stack.pop();
//            result.add(curr.val);
//            if (curr.left != null) stack.push(curr.left);
//            if (curr.right != null) stack.push(curr.right);
//        }
//
//        Collections.reverse(result);
//        return result;
//    }

}
