package com.xu.stack;

import java.util.Stack;

public class Minimum_Add_to_Make_Parentheses_Valid_921 {

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c: S.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.size();
    }

}
