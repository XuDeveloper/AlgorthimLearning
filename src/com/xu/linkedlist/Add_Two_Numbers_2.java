package com.xu.linkedlist;

public class Add_Two_Numbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;
        while ((l1 != null) || (l2 != null) || (carry != 0)) {
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;
            int sum = carry + l1_val + l2_val;
            // update carry
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);

            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }

}
