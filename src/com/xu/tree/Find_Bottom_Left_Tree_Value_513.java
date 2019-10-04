package com.xu.tree;

// 刷过1遍（2019.10.3 ）

public class Find_Bottom_Left_Tree_Value_513 {

    public int findBottomLeftValue(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            return root.val;
        }
        return findBottomLeftValue(root, 0, new int[]{0, 0});
    }

    private int findBottomLeftValue(TreeNode root, int depth, int[] res) {
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
