package com.xu.offer;

public class Has_Sub_Tree_18 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        // 当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            // 如果找到了对应Tree2的根节点的点
            if (root1.val == root2.val) {
                // 以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1, root2);
            }
            // 如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            // 如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        // 返回结果
        return result;
    }

    public boolean doesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return false;
        }
        if (root2 == null) {
            return true;
        }
        if (root1.val == root2.val) {
            return doesTree1HaveTree2(root1.left, root2.left) && doesTree1HaveTree2(root1.right, root2.right);
        }
        return false;
    }

}
