package com.xu.tree;

public class Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal_889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    public TreeNode constructFromPrePost(int[] pre, int preS, int preE, int[] post, int postS, int postE) {
        if (preS > preE || postS > postE) {
            return null;
        } else if (preS == preE) {
            return new TreeNode(pre[preS]);
        }
        TreeNode root = new TreeNode(pre[preS]);
        for (int i = postE - 1; i >= postS; i--) {
            if (pre[preS + 1] == post[i]) {
                root.left = constructFromPrePost(pre, preS + 1, preS + 1 + i - postS, post, postS, i);
                root.right = constructFromPrePost(pre, preS + 2 + i - postS, preE, post, i + 1, postE - 1);
            }
        }
        return root;
    }

}
