package com.xu.offer;

import java.util.LinkedList;
import java.util.Queue;

public class Two_Queue_to_Stack_7 {

    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (q2.isEmpty()) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        while (!q2.isEmpty()) {
            if (q2.size() == 1)
                return q2.poll();
            q1.offer(q2.poll());
        }
        while (!q1.isEmpty()) {
            if (q1.size() == 1)
                return q1.poll();
            q2.offer(q1.poll());
        }
        return -1;
    }

    /**
     * Get the top element.
     */
    public int top() {
        while (!q2.isEmpty()) {
            if (q2.size() == 1) {
                int x = q2.peek();
                q1.offer(q2.poll());
                return x;
            }

            q1.offer(q2.poll());
        }
        while (!q1.isEmpty()) {
            if (q1.size() == 1) {
                int x = q1.peek();
                q2.offer(q1.poll());
                return x;
            }
            q2.offer(q1.poll());
        }
        return -1;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

}
