package com.xu.tree;

public class Invert_Binary_Tree_226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // level order
//    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//
//    if(root!=null){
//        queue.add(root);
//    }
//
//    while(!queue.isEmpty()){
//        TreeNode p = queue.poll();
//        if(p.left!=null)
//            queue.add(p.left);
//        if(p.right!=null)
//            queue.add(p.right);
//
//        TreeNode temp = p.left;
//        p.left = p.right;
//        p.right = temp;
//    }
//
//    return root;

}
