package com.xu.tree;

import com.xu.linkedlist.ListNode;

// 刷过一次 （2019.06.25 ）

public class Convert_Sorted_List_to_Binary_Search_Tree_109 {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return helper(head);
    }

    public TreeNode helper(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        TreeNode L = helper(head);
        TreeNode R = helper(slow.next);
        root.left = L;
        root.right = R;
        return root;
    }

}
