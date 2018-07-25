package com.xu.string;

/**
 * http://blog.csdn.net/u014688145/article/details/61623537
 */
public class Construct_Binary_Tree_from_String_536 {

    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;

        int val = 0;
        int i = 0, k = 1;

        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '-') {
            if (s.charAt(i) == '-') {
                k = -1;
            } else {
                val = val * 10 + (s.charAt(i) - '0') * k;
            }
            i++;
        }

        TreeNode root = new TreeNode(val);
        if (i == s.length()) {
            return root;
        }

        int count = 0, j;
        for (j = i; j < s.length(); j++) {
            if (s.charAt(j) == '(') {
                count++;
            }
            if (s.charAt(j) == ')') {
                count--;
            }
            if (count == 0) break;
        }

        root.left = str2tree(s.substring(i + 1, j));

        if (j != s.length() - 1) {
            root.right = str2tree(s.substring(j + 2, s.length() - 1));
        }

        return root;
    }

}

