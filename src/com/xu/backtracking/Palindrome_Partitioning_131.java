package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

// 刷过1遍（2019.07.21 ）

public class Palindrome_Partitioning_131 {

    private List<List<String>> res;

    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        generatePartition(s, 0, new ArrayList<>());
        return res;
    }

    public void generatePartition(String s, int pos, List<String> temp) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            String subStr = s.substring(pos, i);
            if (!isPalindrome(subStr)) {
                continue;
            }
            temp.add(subStr);
            generatePartition(s, i, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
