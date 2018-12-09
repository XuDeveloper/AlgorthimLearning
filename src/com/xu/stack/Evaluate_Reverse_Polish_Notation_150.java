package com.xu.stack;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation_150 {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<>();
        int tempVal = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (operators.contains(tokens[i])) {
                int val2 = stack.pop();
                int val1 = stack.pop();
                int index = operators.indexOf(tokens[i]);
                switch (index) {
                    case 0:
                        stack.push(val1 + val2);
                        break;
                    case 1:
                        stack.push(val1 - val2);
                        break;
                    case 2:
                        stack.push(val1 * val2);
                        break;
                    case 3:
                        stack.push(val1 / val2);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.peek();
    }

}
