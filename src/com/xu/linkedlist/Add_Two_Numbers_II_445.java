package com.xu.linkedlist;

import java.util.Stack;

public class Add_Two_Numbers_II_445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        // head的下一个结点为curNode
        ListNode curNode = new ListNode(0);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty())
                sum += s1.pop();
            if (!s2.isEmpty())
                sum += s2.pop();
            // head.val存储进制位，head.val可能为0
            ListNode head = new ListNode(sum / 10);
            // curNode存储结果
            curNode.val = sum % 10;
            head.next = curNode;
            // curNode往前移动，指向head
            curNode = head;
            // 此时sum存储的是进制位
            // 下次计算需要用到
            sum /= 10;
        }
        // 前导0的情况,
        // curNode为head的引用，可能为0
        if (curNode.val == 0)
            curNode = curNode.next;
        return curNode;
    }

}
