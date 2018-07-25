package com.xu.linkedlist;

public class Partition_List_86 {

    public ListNode partition(ListNode head, int x) {
        ListNode leftDummy = new ListNode(0);
        ListNode leftCurr = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightCurr = rightDummy;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                leftCurr.next = cur;
                leftCurr = leftCurr.next;
            } else {
                rightCurr.next = cur;
                rightCurr = rightCurr.next;
            }
            cur = cur.next;
        }
        rightCurr.next = null;
        leftCurr.next = rightDummy.next;
        return leftDummy.next;
    }

}
