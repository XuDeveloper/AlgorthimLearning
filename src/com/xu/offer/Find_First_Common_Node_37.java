package com.xu.offer;

public class Find_First_Common_Node_37 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = findListLenth(pHead1);
        int len2 = findListLenth(pHead2);
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        if (len1 - len2 > 0) {
            walkStep(cur1, len1 - len2);
        } else {
            walkStep(cur2, len2 - len1);
        }
        while (cur1 != null && cur2 != null) {
            if (cur1 == cur2) {
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    private ListNode walkStep(ListNode cur, int step) {
        // 从step~1
        while (step-- > 0)
            cur = cur.next;
        return cur;
    }

    // 计算链表长度
    private int findListLenth(ListNode head) {
        if (head == null)
            return 0;
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

}
