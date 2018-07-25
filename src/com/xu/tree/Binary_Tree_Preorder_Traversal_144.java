package com.xu.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 先序遍历 先根后左再右
 */
public class Binary_Tree_Preorder_Traversal_144 {

//    public List<Integer> preorderTraversal(TreeNode root) {
//        ArrayList<Integer> result = new ArrayList<>();
//        if (root != null) {
//            result.add(root.val);
//            result.addAll(preorderTraversal(root.left));
//            result.addAll(preorderTraversal(root.right));
//        }
//        return result;
//    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);

        while (!nodeStack.empty()) {
            TreeNode node = nodeStack.pop();
            result.add(node.val);

            if (node.right != null) {
                nodeStack.push(node.right);
            }

            if (node.left != null) {
                nodeStack.push(node.left);
            }
        }

        return result;
    }

}
