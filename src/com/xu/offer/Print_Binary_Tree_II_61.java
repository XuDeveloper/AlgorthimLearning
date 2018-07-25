package com.xu.offer;

import java.util.*;

public class Print_Binary_Tree_II_61 {

    // 1
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if (pRoot == null) {
            return ret;
        }
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(null);//层分隔符
        queue.addLast(pRoot);
        boolean leftToRight = true;

        while (queue.size() != 1) {
            TreeNode node = queue.removeFirst();//删除第一个，返回删除节点，若此节点不是分层的节点null，则添加左右子节点
            if (node == null) {//判断删除的节点是否为null，以此来判断是否到达分层隔符
                Iterator<TreeNode> iter = null;
                if (leftToRight) {
                    iter = queue.iterator();//从前往后遍历
                } else {
                    iter = queue.descendingIterator();//从后往前遍历
                }
                leftToRight = !leftToRight;
                while (iter.hasNext()) {
                    TreeNode temp = (TreeNode) iter.next();
                    list.add(temp.val);
                }
                ret.add(new ArrayList<Integer>(list));
                list.clear();
                queue.addLast(null);//添加层分隔符
                continue;//一定要continue
            }
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }

        return ret;
    }

    // 2 栈
//    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        ArrayList list = new ArrayList<ArrayList<Integer>>();
//        if (pRoot == null)
//            return list;
//        Stack s1 = new Stack();//从左到右输出，所以添加时先加右，再加左
//        Stack s2 = new Stack();//从右到左输出，所以添加时先加左，再加右
//        s1.push(pRoot);
//        ArrayList arr = new ArrayList<Integer>();
//        while (true) {
//            while (s1.size() != 0) {
//                TreeNode node = (TreeNode) s1.pop();
//                arr.add(node.val);
//                if (node.left != null)
//                    s2.push(node.left);
//                if (node.right != null)
//                    s2.push(node.right);
//            }
//            list.add(arr);
//            arr = new ArrayList<Integer>();
//            if (s1.size() == 0 && s2.size() == 0)
//                break;
//            while (s2.size() != 0) {
//                TreeNode node1 = (TreeNode) s2.pop();
//                arr.add(node1.val);
//                if (node1.right != null)
//                    s1.push(node1.right);
//                if (node1.left != null)
//                    s1.push(node1.left);
//            }
//            list.add(arr);
//            arr = new ArrayList<Integer>();
//
//            if (s1.size() == 0 && s2.size() == 0)
//                break;
//        }
//
//        return list;
//    }

}
