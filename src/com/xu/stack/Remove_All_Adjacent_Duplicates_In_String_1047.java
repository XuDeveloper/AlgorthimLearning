package com.xu.stack;

import java.util.Stack;

public class Remove_All_Adjacent_Duplicates_In_String_1047 {

    public String removeDuplicates(String S) {
        if (S.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            char c = S.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
