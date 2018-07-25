package com.xu.linkedlist;

public class Reverse_Doubly_Linked_List {

    public DListNode reverse(DListNode head) {
        DListNode curr = null;
        while (head != null) {
            curr = head;
            head = curr.next;
            curr.next = curr.prev;
            curr.prev = head;
        }
        return curr;
    }

}

class DListNode {
    int val;
    DListNode prev, next;

    DListNode(int val) {
        this.val = val;
        this.prev = this.next = null;
    }
}