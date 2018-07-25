package com.xu.offer;

public class Reconstruct_Binary_Tree_6 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn,
                        in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre,
                        in, i + 1, endIn);
            }
        }
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = rebuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }

    public TreeNode rebuildTree(int[] inorder, int startIn, int endIn, int[] postorder, int startPo, int endPo) {
        if (startIn > endIn || startPo > endPo) {
            return null;
        }
        TreeNode node = new TreeNode(postorder[endPo]);
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == postorder[endPo]) {
                node.left = rebuildTree(inorder, startIn, i - 1, postorder, startPo, startPo + i - startIn - 1);
                node.right = rebuildTree(inorder, i + 1, endIn, postorder, endPo - (endIn - i), endPo - 1);
            }
        }
        return node;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
