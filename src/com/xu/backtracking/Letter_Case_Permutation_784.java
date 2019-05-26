package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Letter_Case_Permutation_784 {

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        permutation(S, res, 0, "");
        return res;
    }

    public void permutation(String s, List<String> res, int index, String temp) {
        if (index == s.length()) {
            res.add(temp);
            return;
        }
        char c = s.charAt(index);
        if (Character.isLetter(c)) {
            permutation(s, res, index + 1, temp + Character.toUpperCase(c));
            permutation(s, res, index + 1, temp + Character.toLowerCase(c));
        } else {
            permutation(s, res, index + 1, temp + c);
        }
    }

}
