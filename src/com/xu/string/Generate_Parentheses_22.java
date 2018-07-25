package com.xu.string;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses_22 {

    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        dfs(result, "", n, n);
        return result;
    }

    public void dfs(ArrayList<String> result, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }
        if (left > 0) {
            dfs(result, s + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(result, s + ")", left, right - 1);
        }
    }

}
