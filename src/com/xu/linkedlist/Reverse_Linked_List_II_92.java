package com.xu.linkedlist;

// 刷过1遍（2019.07.30 ）

public class Reverse_Linked_List_II_92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode premNode = dummy;
        for (int i = 1; i < m; i++) {
            premNode = premNode.next;
        }
        ListNode prev = null;
        ListNode curr = premNode.next;
        while (curr != null && (m <= n)) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            m++;
        }
        premNode.next.next = curr;
        premNode.next = prev;
        return dummy.next;
    }

}
