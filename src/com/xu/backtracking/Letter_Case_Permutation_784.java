package com.xu.backtracking;

// 刷过1遍（2019.09.29 ）

import java.util.ArrayList;
import java.util.List;

public class Letter_Case_Permutation_784 {

    private List<String> res;

    public List<String> letterCasePermutation(String S) {
        res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        permutation(S, 0, "");
        return res;
    }

    private void permutation(String s, int index, String temp) {
        if (index == s.length()) {
            res.add(temp);
            return;
        }
        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            permutation(s, index + 1, temp + Character.toUpperCase(c));
            permutation(s, index + 1, temp + Character.toLowerCase(c));
        } else {
            permutation(s, index + 1, temp + c);
        }
    }

}
