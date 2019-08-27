package com.xu.linkedlist;

// 刷过1遍（2019.08.27 ）

/**
 * https://blog.csdn.net/linhuanmars/article/details/24389429
 */
public class Remove_Duplicates_from_Sorted_List_II_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode pre = helper;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && pre.next.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return helper.next;
    }

}
