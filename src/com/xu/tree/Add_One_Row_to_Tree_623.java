package com.xu.tree;

public class Add_One_Row_to_Tree_623 {

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode treeNode = new TreeNode(v);
            treeNode.left = root;
            return treeNode;
        } else {
            int deep = d - 1;
            addOneRow(root, v, deep, 1);
        }
        return root;
    }

    private TreeNode addOneRow(TreeNode root, int v, int deep, int thisdeep) {
        if (root == null) {
            return root;
        }
        if (deep == thisdeep) {
            TreeNode tempLeft = new TreeNode(v);
            if (root.left != null) {
                tempLeft.left = root.left;
            }
            TreeNode tempRight = new TreeNode(v);
            if (root.right != null) {
                tempRight.right = root.right;
            }
            root.left = tempLeft;
            root.right = tempRight;
        } else {
            root.left = addOneRow(root.left, v, deep, thisdeep + 1);
            root.right = addOneRow(root.right, v, deep, thisdeep + 1);
        }
        return root;
    }

}
