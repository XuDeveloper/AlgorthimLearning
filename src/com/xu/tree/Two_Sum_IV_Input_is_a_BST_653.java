package com.xu.tree;

import java.util.ArrayList;
import java.util.List;

public class Two_Sum_IV_Input_is_a_BST_653 {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList();
        inOrder(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum < k) {
                i++;
            } else if (sum > k) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

}
