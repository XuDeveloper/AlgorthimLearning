package com.xu.lintcode.linkedlist;

import com.xu.linkedlist.ListNode;

public class Remove_Duplicates_from_Unsorted_List_CTCI {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode cur = head;
        while (cur != null) {
            ListNode inner = cur;
            while (inner.next != null) {
                if (inner.next.val == cur.val) {
                    inner.next = inner.next.next;
                } else {
                    inner = inner.next;
                }
            }
            cur = cur.next;
        }
        return head;
    }

}
