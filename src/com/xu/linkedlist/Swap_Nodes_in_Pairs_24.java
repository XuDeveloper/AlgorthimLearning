package com.xu.linkedlist;

public class Swap_Nodes_in_Pairs_24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        // p -> n1 -> n2 -> next`
        while (p.next != null && p.next.next != null) {
            ListNode n1 = p.next;
            ListNode n2 = n1.next;
            ListNode next = n2.next;
            n2.next = n1;
            n1.next = next;
            p.next = n2;
            p = n1;
        }
        return dummy.next;
    }

}
