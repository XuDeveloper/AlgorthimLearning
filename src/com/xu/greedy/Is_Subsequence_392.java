package com.xu.greedy;

public class Is_Subsequence_392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int si = 0, ti = 0;
        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                si++;
            }
            ti++;
            if (si == s.length()) {
                return true;
            }
        }
        return false;
    }

}
