package com.xu.string;

public class Shortest_Palindrome_214 {

    public String shortestPalindrome(String s) {
        if (s.length() <= 1) return s;
        int center = (s.length() - 1) / 2;
        String res = "";
        for (int i = center; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if ((res = check(s, i, i + 1)) != null) return res;
            }
            if ((res = check(s, i, i)) != null) return res;

        }
        return res;
    }

    //aabaac
    private String check(String s, int l, int r) {
        int i = 1;
        for (; l - i >= 0 && r + i < s.length(); i++) {
            if (s.charAt(l - i) != s.charAt(r + i)) break;
        }

        if (l - i >= 0) return null;
        StringBuilder sb = new StringBuilder(s.substring(r + i));
        sb.reverse();
        return sb + s;
    }

}
