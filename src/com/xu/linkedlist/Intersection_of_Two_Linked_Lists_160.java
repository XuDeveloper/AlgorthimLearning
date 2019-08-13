package com.xu.linkedlist;

public class Intersection_of_Two_Linked_Lists_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode la = headA, lb = headB;
        while (la != null && lb != null) {
            if (la == lb) {
                return la;
            }
            la = la.next;
            lb = lb.next;
            if (la == lb) {
                return la;
            }
            if (la == null) {
                la = headB;
            }
            if (lb == null) {
                lb = headA;
            }
        }
        return la;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode ta; // 用于记录headA链表的尾结点
        ListNode ha = headA;
        // 第一步、找到headA的尾结点
        while (ha.next != null) {
            ha = ha.next;
        }
        ta = ha; // 记录链表headA的尾结点
        // 第二步、将headB接到ta后面
        ta.next = headB;

        // 第三步、判断是否存在环
        // 判断链表是否存在环，办法为：
        // 设置两个指针(fast, slow)，初始值都指向头，slow每次前进一步，fast每次前进二步，
        // 如果链表存在环，则fast必定先进入环，而slow后进入环，两个指针必定相遇。
        // (当然，fast先行头到尾部为NULL，则为无环链表)程序如下：

        ListNode fast = headA; // 每次前进一步
        ListNode slow = headA; // 每次前进二步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) { // 如果相遇了就退出来
                break;
            }
        }

        // 没有环的情况
        if (fast == null || fast.next == null) {
            ta.next = null; // 解开拼接好的链表
            return null;
        }

        // 有环的情况
        // 找到环的入口点
        // 当fast若与slow相遇时，slow肯定没有走遍历完链表，而fast已经在环内循环了n圈(1<=n)。
        // 假设slow走了s步，则fast走了2s步（fast步数还等于s 加上在环上多转的n圈），设环长为r，则：
        //
        // 2s = s + nr
        // s= nr
        //
        // 设整个链表长L，入口环与相遇点距离为x，起点到环入口点的距离为a。
        // a + x = nr
        // a + x = (n – 1)r +r = (n-1)r + L - a
        // a = (n-1)r + (L – a – x)
        //
        // (L – a – x)为相遇点到环入口点的距离，由此可知，从链表头到环入口点等于(n-1)循环内环+相遇点到环入口点，
        // 于是我们从链表头、与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇第一点为环入口点。
        slow = headA;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        ta.next = null;
        return slow;
    }

}
