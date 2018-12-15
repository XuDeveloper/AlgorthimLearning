package com.xu.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Flatten_Nested_List_Iterator_341 {

    class NestedIterator implements Iterator<Integer> {

        Stack<NestedInteger> stack = new Stack<>();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                return stack.pop().getInteger();
            }
            return null;
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty()) {
                if (stack.peek().isInteger()) {
                    return true;
                } else {
                    NestedInteger nestedInteger = stack.pop();
                    for (int i = nestedInteger.getList().size() - 1; i >= 0; i--) {
                        stack.push(nestedInteger.getList().get(i));
                    }
                }
            }
            return false;
        }
    }

    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

}
