package com.xu.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 栈的思想
 */
public class Valid_Parentheses_20 {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty() || c != map.get(stack.pop())) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

}
