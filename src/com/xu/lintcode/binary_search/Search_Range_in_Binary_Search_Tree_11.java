package com.xu.lintcode.binary_search;

import com.xu.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Search_Range_in_Binary_Search_Tree_11 {

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<>();
        helper(root, k1, k2, result);
        return result;
    }

    public void helper(TreeNode root, int k1, int k2, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null && root.val > k1) {
            helper(root.left, k1, k2, result);
        }
        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        if (root.right != null && root.val < k2) {
            helper(root.right, k1, k2, result);
        }
    }

}
