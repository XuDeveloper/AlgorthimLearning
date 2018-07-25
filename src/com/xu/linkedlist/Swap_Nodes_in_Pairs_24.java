package com.xu.linkedlist;

public class Swap_Nodes_in_Pairs_24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;

        while (curr != null && curr.next != null) {
            ListNode after = curr.next;
            ListNode nextCurr = after.next;
            after.next = curr;
            curr.next = nextCurr;
            // link new node after prev
            prev.next = after;
            // update prev and curr
            prev = curr;
            curr = nextCurr;
        }

        return dummy.next;
    }

}
