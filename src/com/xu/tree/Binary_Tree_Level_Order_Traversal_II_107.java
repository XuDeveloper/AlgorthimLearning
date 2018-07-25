package com.xu.tree;

import java.util.ArrayList;
import java.util.List;

public class Binary_Tree_Level_Order_Traversal_II_107 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        addToLevelList(root, 0);
        if (result.size() == 0) {
            return result;
        }
        int i = 0;
        int j = result.size() - 1;
        int mid = (i + j) / 2;
        while(i <= mid) {
            swap(result, i, j);
            i++;
            j--;
        }
        return result;
    }

    private void swap(List<List<Integer>> result, int i, int j) {
        List<Integer> temp = result.get(i);
        result.set(i, result.get(j));
        result.set(j, temp);
    }

    public void addToLevelList(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (result.size() < depth + 1) {
            result.add(depth, new ArrayList<>());
        }
        result.get(depth).add(root.val);
        depth++;
        if (root.left != null) {
            addToLevelList(root.left, depth);
        }
        if (root.right != null) {
            addToLevelList(root.right, depth);
        }
    }

//    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        if (root == null) return result;
//
//        Stack<ArrayList<Integer>> s = new Stack<ArrayList<Integer>>();
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        q.offer(root);
//        while (!q.isEmpty()) {
//            int qLen = q.size();
//            ArrayList<Integer> aList = new ArrayList<Integer>();
//            for (int i = 0; i < qLen; i++) {
//                TreeNode node = q.poll();
//                aList.add(node.val);
//                if (node.left != null) q.offer(node.left);
//                if (node.right != null) q.offer(node.right);
//            }
//            s.push(aList);
//        }
//
//        while (!s.empty()) {
//            result.add(s.pop());
//        }
//        return result;
//    }

//    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//        if (root == null) return result;
//
//        Queue<TreeNode> q = new LinkedList<TreeNode>();
//        q.offer(root);
//        while (!q.isEmpty()) {
//            int qLen = q.size();
//            ArrayList<Integer> aList = new ArrayList<Integer>();
//            for (int i = 0; i < qLen; i++) {
//                TreeNode node = q.poll();
//                aList.add(node.val);
//                if (node.left != null) q.offer(node.left);
//                if (node.right != null) q.offer(node.right);
//            }
//            result.add(aList);
//        }
//
//        Collections.reverse(result);
//        return result;
//    }

}
