package com.xu.offer;

public class Copy_Complex_List_26 {

    public ComplexListNode clone(ComplexListNode pHead) {
        if (pHead == null)
            return null;
        ComplexListNode pCur = pHead;
        // 复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while (pCur != null) {
            ComplexListNode temp = new ComplexListNode(pCur.value);
            temp.next = pCur.next;
            pCur.next = temp;
            pCur = temp.next;
        }
        pCur = pHead;
        // 复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while (pCur != null) {
            if (pCur.random != null) {
                pCur.next.random = pCur.random.next;
            }
            pCur = pCur.next.next;
        }
        ComplexListNode pCloneHead = null;
        ComplexListNode pCloneNode = null;
        pCur = pHead;
        // 初始化，让pcur指向pCloneNode的下一个结点,避免空指针
        if (pCur != null) {
            pCloneHead = pCloneNode = pCur.next;
            pCur.next = pCloneNode.next;
            pCur = pCur.next;
        }
        while (pCur != null) {
            pCloneNode.next = pCur.next;
            pCloneNode = pCloneNode.next;
            pCur.next = pCloneNode.next;
            pCur = pCur.next;
        }
        return pCloneHead;
    }

}

class ComplexListNode {
    int value;
    ComplexListNode random;
    ComplexListNode next;

    public ComplexListNode(int value) {
        this.value = value;
    }
}