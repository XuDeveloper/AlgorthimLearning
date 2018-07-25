package com.xu.tree;

import java.util.ArrayList;
import java.util.List;

public class Lowest_Common_Ancestor_of_a_Binary_Tree_236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        getNodePath(root, p, list1);
        getNodePath(root, q, list2);
        int size1 = list1.size();
        int size2 = list2.size();
        int len = size1 < size2 ? size1 : size2;
        int k = 0;
        while (k < len) {
            TreeNode node1 = list1.get(k);
            TreeNode node2 = list2.get(k);
            if (node1 != node2) {
                break;
            }
            k++;
        }
        return list1.get(k - 1);
    }

    private boolean getNodePath(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == target) {
            list.add(root);
            return true;
        }
        if (root != null) {
            list.add(root);
            if (getNodePath(root.left, target, list) || getNodePath(root.right, target, list)) {
                return true;
            }
            list.remove(list.size() - 1);
        }
        return false;
    }

}
