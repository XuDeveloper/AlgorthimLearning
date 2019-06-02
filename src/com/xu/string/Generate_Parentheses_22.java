package com.xu.string;

import java.util.ArrayList;
import java.util.List;

// 刷过一遍 （2019.06.02 ）

public class Generate_Parentheses_22 {

    private List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        getParenthesis("", n, n);
        return res;
    }

    public void getParenthesis(String temp, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(temp);
            return;
        }
        if (left > 0) {
            getParenthesis(temp + '(', left - 1, right);
        }
        if (right > 0) {
            getParenthesis(temp + ')', left, right - 1);
        }
    }

}
