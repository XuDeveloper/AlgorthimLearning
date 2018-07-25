package com.xu.tree;

public class Find_Bottom_Left_Tree_Value_513 {

    public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValue(root, 0, new int[]{0, 0});
    }

    public int findBottomLeftValue(TreeNode root, int depth, int[] res) {
        if (res[1] < depth) {
            res[0] = root.val;
            res[1] = depth;
        }
        if (root.left != null) {
            findBottomLeftValue(root.left, depth + 1, res);
        }
        if (root.right != null) {
            findBottomLeftValue(root.right, depth + 1, res);
        }
        return res[0];
    }

}
