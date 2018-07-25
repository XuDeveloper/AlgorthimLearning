package com.xu.offer;

public class Next_Node_in_Binary_Tree_58 {

    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }
        while (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        TreeLinkNode temp = null;
        while (node.parent != null) {
            temp = node.parent;
            if (temp.left == node) {
                return temp;
            }
            node = node.parent;
        }
        return null;
    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode parent= null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
