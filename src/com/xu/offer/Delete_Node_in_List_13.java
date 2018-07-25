package com.xu.offer;

public class Delete_Node_in_List_13 {

    public void deleteNodeInList(Node head, Node toDelete) {
        if (toDelete == null) {
            return;
        }
        if (toDelete.next != null) {//删除的节点不是尾节点
            toDelete.val = toDelete.next.val;
            toDelete.next = toDelete.next.next;
        } else if (head == toDelete) {//链表只有一个节点，删除头结点也是尾节点
            head = null;
        } else { //删除的节点是尾节点的情况
            Node node = head;
            while (node.next != toDelete) {//找到倒数第二个节点
                node = node.next;
            }
            node.next = null;
        }
    }

}

class Node {
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
    }
}
