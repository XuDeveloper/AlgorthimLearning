package com.xu.offer;

public class Find_Common_Node_in_List_37 {

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
        int l1 = getListLength(pHead1);
        int l2 = getListLength(pHead2);
        int diff = l1 - l2;
        if (diff > 0) {
            while (diff > 0) {
                pHead1 = pHead1.next;
                diff--;
            }
        }
        if (diff < 0) {
            while (diff < 0) {
                pHead2 = pHead2.next;
                diff++;
            }
        }
        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return pHead1;
    }

    public int getListLength(ListNode listNode) {
        int length = 0;
        ListNode p = listNode;
        while (p != null) {
            p = p.next;
            length++;
        }
        return length;
    }

}
