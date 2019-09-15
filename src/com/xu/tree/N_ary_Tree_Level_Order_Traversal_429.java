package com.xu.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_ary_Tree_Level_Order_Traversal_429 {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                Node node = queue.poll();
                temp.add(node.val);
                if (node.children.size() > 0) {
                    for (int j = 0; j < node.children.size(); j++) {
                        queue.offer(node.children.get(j));
                    }
                }
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }

}
