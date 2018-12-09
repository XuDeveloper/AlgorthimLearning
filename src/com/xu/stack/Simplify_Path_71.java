package com.xu.stack;

import java.util.Stack;

public class Simplify_Path_71 {

    public String simplifyPath(String path) {
        if (path.length() == 0) {
            return "";
        }
        if (path.length() == 1) {
            return "/";
        }
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for (int i = 0; i < paths.length; i++) {
            String str = paths[i];
            if (str.equals(".") || str.equals("")) {
                continue;
            } else if (str.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res;
    }

}
