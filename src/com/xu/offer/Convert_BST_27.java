package com.xu.offer;

public class Convert_BST_27 {

    public BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode node = null;
        convert(root, node);
        while (node != null && node.leftNode != null) {
            node = node.leftNode;
        }
        return node;
    }

    public void convert(BinaryTreeNode root, BinaryTreeNode lastNode) {
        if (root == null)
            return;
        BinaryTreeNode current = root;
        if (current.leftNode != null)
            convert(current.leftNode, lastNode);
        current.leftNode = lastNode;
        if (lastNode != null)
            lastNode.rightNode = current;
        if (current.rightNode != null)
            convert(current.rightNode, lastNode);
    }

}

class BinaryTreeNode {
    int value;
    BinaryTreeNode leftNode;
    BinaryTreeNode rightNode;
}
