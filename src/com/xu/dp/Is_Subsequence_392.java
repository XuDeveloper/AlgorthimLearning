package com.xu.dp;

// 刷过1遍（2019.07.20 ）

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

    // 使用indexOf效率提升！
    // https://blog.csdn.net/liuchonge/article/details/76210163
    public boolean isSubsequence_2(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            prev = t.indexOf(tmp, prev);
            if (prev == -1) {
                return false;
            }
            prev++;
        }
        return true;
    }

}
