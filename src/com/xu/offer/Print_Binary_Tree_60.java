package com.xu.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Print_Binary_Tree_60 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> layerlist = new ArrayList<>();
        queue.add(pRoot);
        int start = 0, end = 1;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            layerlist.add(cur.val);
            start++;
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            if (start == end) {
                end = queue.size();
                start = 0;
                result.add(layerlist);
                layerlist = new ArrayList<>();
            }
        }
        return result;
    }

}
