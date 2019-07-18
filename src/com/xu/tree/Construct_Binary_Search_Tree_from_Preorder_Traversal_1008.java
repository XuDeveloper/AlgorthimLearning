package com.xu.tree;

public class Construct_Binary_Search_Tree_from_Preorder_Traversal_1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, 0, preorder.length - 1);
    }

    public TreeNode build(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[left]);
        boolean found = false;
        for (int i = left + 1; i <= right; i++) {
            if (preorder[i] > preorder[left]) {
                root.left = build(preorder, left + 1, i - 1);
                root.right = build(preorder, i, right);
                found = true;
                break;
            }
        }
        if (!found) {
            root.left = build(preorder, left + 1, right);
        }
        return root;
    }

}
