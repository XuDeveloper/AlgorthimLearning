package com.xu.tree;

public class Path_Sum_III_437 {

    /**
     * 在以root为根结点的二叉树中，寻找和为sum的路径，返回路径个数
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        // 包含root
        int res = findPath(root, sum);
        // 不包含root
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    /**
     * 在以root为根结点的二叉树中，寻找包含root的路径，和为sum
     * 返回这样的路径个数
     * @param root
     * @param sum
     * @return
     */
    private int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (root.val == sum) {
            res += 1;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }

}
