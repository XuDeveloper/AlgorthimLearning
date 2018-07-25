package com.xu.linkedlist;

public class Sort_List_148 {

    public ListNode sortList(ListNode head) {
        // mergesort
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMid(head);
        ListNode head1 = head;
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode left = sortList(head1);
        ListNode right = sortList(head2);
        return merge(left, right);
    }

    public ListNode findMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            int a = l1 == null ? Integer.MAX_VALUE : l1.val;
            int b = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (a < b) {
                curr.next = new ListNode(a);
                if (l1 != null) {
                    l1 = l1.next;
                }
            } else {
                curr.next = new ListNode(b);
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            curr = curr.next;
        }
        return dummy.next;
    }

}
