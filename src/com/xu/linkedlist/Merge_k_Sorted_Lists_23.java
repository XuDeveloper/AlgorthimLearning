package com.xu.linkedlist;

// 刷过1遍（2019.08.06 ）

public class Merge_k_Sorted_Lists_23 {

    // 思路一： 迭代调用Merge Two Sorted Lists

    // 思路二： 二分法
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    public ListNode helper(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start + 1 == end) {
            return mergeTwoLists(lists[start], lists[end]);
        }
        ListNode left = helper(lists, start, start + (end - start) / 2);
        ListNode right = helper(lists, start + (end - start) / 2 + 1, end);
        return mergeTwoLists(left, right);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1 != null ? l1 : l2;
        return dummy.next;
    }

}
