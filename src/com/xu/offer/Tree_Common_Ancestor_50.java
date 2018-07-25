package com.xu.offer;

import java.util.LinkedList;

public class Tree_Common_Ancestor_50 {

    // 1.求二叉搜索树的最低公共祖先：参考leetcode-tree-235

    // 2.如果非二叉树而是普通的树 但有指向父节点的指针：退化成链表 从输入结点出发到根结点 形成 链表
    //   求两个链表第一个公共节点

    // 3.普通树

    LinkedList<NormalTreeNode> list1 = new LinkedList<>();
    LinkedList<NormalTreeNode> list2 = new LinkedList<>();

    public NormalTreeNode getLastCommonAncestor(NormalTreeNode node1, NormalTreeNode node2, NormalTreeNode root) {
        getNodePath(node1, root, list1);
        getNodePath(node2, root, list2);
        //list1 : D -- B -- A
        //list2 : E -- B -- A

        //接下来遍历两个链表找到最近的公共节点
        int index = 0;
        int length1 = list1.size();
        int length2 = list2.size();
        int sub = length1 > length2 ? length1 - length2 : length2 - length1;
        if (length2 > length1) {
            LinkedList temp = list1;
            list1 = list2;
            list2 = temp;
        }
        while (index != length2 - 1) {
            if (list1.get(index + sub).val == list2.get(index).val) {
                return list2.get(index);
            } else {
                index++;
            }
        }
        return null;
    }

    public boolean getNodePath(NormalTreeNode node, NormalTreeNode root, LinkedList<NormalTreeNode> list) {
        if (node.val == root.val) {
            return true;
        }
        list.add(root);
        boolean result = false;
        NormalTreeNode[] childs = root.childs;
        if (childs != null && childs.length > 0) {
            for (int i = 0; i < childs.length; i++) {
                if (result) {
                    break;
                } else {
                    result = getNodePath(node, childs[i], list);
                }
            }
        }
        if (!result) {
            list.pop();
        }
        return result;
    }

}

class NormalTreeNode {

    int val;
    NormalTreeNode[] childs;

}
