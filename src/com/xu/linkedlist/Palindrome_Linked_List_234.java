package com.xu.linkedlist;

public class Palindrome_Linked_List_234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // skip mid node if the number of ListNode is odd
        if (fast != null) slow = slow.next;

        // reverse right part of List
        ListNode rHead = reverse(slow);
        ListNode lCurr = head, rCurr = rHead;
        while (rCurr != null) {
            if (rCurr.val != lCurr.val) {
                reverse(rHead);
                return false;
            }
            lCurr = lCurr.next;
            rCurr = rCurr.next;
        }
        // recover right part of List
        reverse(rHead);

        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode after = head.next;
            head.next = prev;
            prev = head;
            head = after;
        }

        return prev;
    }

}
