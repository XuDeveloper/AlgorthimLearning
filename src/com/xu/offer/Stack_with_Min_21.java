package com.xu.offer;

import java.util.Stack;

/*思路：用一个栈data保存数据，用另外一个辅助栈min保存依次入栈最小的数
比如，data中依次入栈，5,  4,  3, 8, 10, 11, 12, 1
       则min依次入栈，5,  4,  3，3,3, 3, 3, 1
每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则不如栈。
*/
public class Stack_with_Min_21 {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        if (min.empty()) {
            min.push(node);
        } else {
            int top = min.peek();
            if (node < top) {
                min.push(node);
            } else {
                min.push(top);
            }
        }
        data.push(node);
    }

    public void pop() {
        if (!(data.empty())) {
            data.pop();
            min.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        if (min.empty()) {
            return 0;
        }
        return min.peek();
    }

}
