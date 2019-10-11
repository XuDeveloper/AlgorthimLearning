package com.xu.linkedlist;

// 刷过1遍（2019.10.09 ）

public class Middle_of_the_Linked_List_876 {

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null) {
            return slow.next;
        } else {
            return slow;
        }
    }

}
