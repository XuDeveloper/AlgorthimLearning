package com.xu.linkedlist;

public class Merge_Two_Sorted_Lists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode last = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                last.next = l1;
                l1 = l1.next;
            } else {
                last.next = l2;
                l2 = l2.next;
            }
            last = last.next;
        }

        last.next = (l1 != null) ? l1 : l2;

        return result.next;
    }

}
