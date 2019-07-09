package com.xu.linkedlist;

// 刷过1遍（2019.07.09 ）

public class Palindrome_Linked_List_234 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // find mid
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        // reverse
        ListNode lCurr = head;
        ListNode rHead = reverse(slow);
        ListNode rCurr = rHead;
        while (rCurr != null) {
            if (rCurr.val != lCurr.val) {
                reverse(rHead);
                return false;
            }
            lCurr = lCurr.next;
            rCurr = rCurr.next;
        }
        reverse(rHead);
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode pNext = head.next;
            head.next = pre;
            pre = head;
            head = pNext;
        }
        return pre;
    }

}
