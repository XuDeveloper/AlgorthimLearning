package com.xu.linkedlist;

// 刷过1遍（2019.09.03 ）

/**
 * https://blog.csdn.net/liuchonge/article/details/74643929
 * https://blog.csdn.net/To_be_to_thought/article/details/83958314
 */
public class Linked_List_Cycle_II_142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode tmp = head;
                while (tmp != slow) {
                    tmp = tmp.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

}
