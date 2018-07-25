package com.xu.lintcode.linkedlist;

import com.xu.linkedlist.ListNode;

public class Remove_Nth_Node_From_End_of_List_174 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preDel = dummy;
        for (int i = 0; i < n; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            preDel = preDel.next;
        }
        preDel.next = preDel.next.next;
        return dummy.next;
    }

}
