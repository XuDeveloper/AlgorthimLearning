package com.xu.offer;

import java.util.ArrayList;
import java.util.Stack;

public class Print_List_from_Tail_to_Head_5 {

    // 递归
    public void printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            if (listNode.next != null) {
                printListFromTailToHead(listNode.next);
            }
            System.out.print("" + listNode.val);
        }
    }

    // Stack
//    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        if(listNode == null){
//            ArrayList list = new ArrayList();
//            return list;
//        }
//        Stack<Integer> stk = new Stack<Integer>();
//        while(listNode != null){
//            stk.push(listNode.val);
//            listNode = listNode.next;
//        }
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        while(!stk.isEmpty()){
//            arr.add(stk.pop());
//        }
//        return arr;
//    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}