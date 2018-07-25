package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.isEmpty()) return result;

        List<String> palindromes = new ArrayList<String>();
        dfs(s, 0, palindromes, result);

        return result;
    }

    private void dfs(String s, int pos, List<String> temp, List<List<String>> result) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = pos + 1; i <= s.length(); i++) {
            String substr = s.substring(pos, i);
            if (!isPalindrome(substr)) {
                continue;
            }
            temp.add(substr);
            dfs(s, i, temp, result);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;

        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        }

        return true;
    }

}
