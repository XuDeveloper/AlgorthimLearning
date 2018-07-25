package com.xu.string;

import java.util.Stack;

public class Longest_Valid_Parentheses_32 {

    public int longestValidParentheses(String s) {
        Stack<Parenthese> stack = new Stack<>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(new Parenthese(i, s.charAt(i)));
            } else {
                if (!stack.isEmpty() && stack.peek().symbol == '(') {
                    int curLen = 0;
                    stack.pop();
                    if (stack.isEmpty()) {
                        curLen = i + 1;
                    } else {
                        curLen = i - stack.peek().index;
                    }
                    maxLen = Math.max(maxLen, curLen);
                } else {
                    stack.push(new Parenthese(i, ')'));
                }
            }
        }
        return maxLen;
    }

}

class Parenthese {
    int index;
    char symbol;

    public Parenthese(int i, char s) {
        this.index = i;
        this.symbol = s;
    }
}

