package com.xu.tree;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II_113 {

    private ArrayList<Integer> temp = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return result;
        }
        temp.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(temp));
        }
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        temp.remove(temp.size() - 1);
        return result;
    }

}
