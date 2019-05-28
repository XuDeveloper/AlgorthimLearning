package com.xu.linkedlist;

public class Middle_of_the_Linked_List_876 {

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next == null) {
            return slow;
        } else {
            return slow.next;
        }
    }

}
