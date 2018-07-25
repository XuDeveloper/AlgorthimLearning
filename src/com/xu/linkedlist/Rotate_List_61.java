package com.xu.linkedlist;

public class Rotate_List_61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode fast = head, slow = head;
        int len = 1;
        for (len = 1; fast.next != null && len <= k; len++) {
            fast = fast.next;
        }
        // k mod len if k > len
        if (len <= k) {
            k = k % len;
            fast = head;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
        }
        // forward slow and fast
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // return new head
        fast.next = head;
        head = slow.next;
        slow.next = null;

        return head;
    }

}
