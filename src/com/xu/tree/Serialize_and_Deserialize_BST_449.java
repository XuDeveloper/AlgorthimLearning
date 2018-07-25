package com.xu.tree;

import java.util.Stack;

public class Serialize_and_Deserialize_BST_449 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer("");
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (stack.size() != 0) {
            root = stack.pop();
            if (root != null) {
                stack.push(root.right);
                stack.push(root.left);
                sb.append(root.val);
                sb.append(",");
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] numbers = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(numbers[0]));
        TreeNode iteratorNode = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        for (int i = 1; i < numbers.length; i++) {
            TreeNode node = new TreeNode(Integer.parseInt(numbers[i]));
            if (node.val < iteratorNode.val) {
                iteratorNode.left = node;
                stack.push(iteratorNode);
            } else {
                while (!stack.empty()) {
                    TreeNode parentNode = stack.pop();
                    if (node.val < parentNode.val) {
                        iteratorNode.right = node;
                        stack.push(parentNode);
                        break;
                    } else {
                        iteratorNode = parentNode;
                    }
                }
                if (stack.empty()) {
                    iteratorNode.right = node;
                }

            }
            iteratorNode = node;
        }
        return root;
    }

}
