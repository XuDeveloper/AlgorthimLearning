package com.xu.linkedlist;

// 刷过一遍 （2019.06.11 ）

public class Remove_Duplicates_from_Sorted_List_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

}
