package com.xu.tree;

import java.util.ArrayList;
import java.util.List;

public class Leaf_Similar_Trees_872 {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        getLeafList(l1, root1);
        getLeafList(l2, root2);
        if (l1.size() != l2.size()) {
            return false;
        }
        for (int i = 0; i < l1.size(); i++) {
            if (l1.get(i) != l2.get(i)) {
                return false;
            }
        }
        return true;
    }

    public void getLeafList(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        getLeafList(list, root.left);
        getLeafList(list, root.right);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
    }

}
