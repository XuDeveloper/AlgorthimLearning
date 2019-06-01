package com.xu.linkedlist;

// 刷过1次 （2019.05.28 ）

public class Reverse_Linked_List_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode n = reverseList(p);
        head.next = null;
        p.next = head;
        return n;
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        ListNode pPre = null;
        ListNode p = head;
        ListNode pNext = head.next;
        ListNode newHead = null;

        while (p != null) {
            pNext = p.next;//一定要记录下来后面的节点
            if (pNext == null)
                newHead = p;
            p.next = pPre;//这里的方向已经转变
            pPre = p;
            p = pNext;//将保存的后面的节点作为下一次循环的p

        }
        return newHead;
    }

}
