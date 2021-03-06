package com.xu.string;

public class Regular_Expression_Matching_10 {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        int m = s.length(), n = p.length();
        boolean[][] res = new boolean[m + 1][n + 1];
        res[0][0] = true;
        //s.charAt(i)与p.charAt(j)的结果是存储在res[i+1][j+1]中
        //所以res[0][i]其实是存储p中与0个字符(s.charAt(-1)不存在)的匹配结果
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*' && res[0][i - 1])
                res[0][i + 1] = true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (p.charAt(j) == '.')
                    res[i + 1][j + 1] = res[i][j];
                if (p.charAt(j) == s.charAt(i))
                    res[i + 1][j + 1] = res[i][j];
                if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.')
                        res[i + 1][j + 1] = res[i + 1][j - 1];
                    else {
                        //res[i + 1][j - 1] 表示*一个都不匹配;
                        //res[i + 1][j]表示匹配一个
                        //res[i][j + 1]表示匹配多个
                        res[i + 1][j + 1] = res[i + 1][j - 1] || res[i + 1][j] || res[i][j + 1];
                    }
                }
            }
        }
        return res[m][n];
    }

}
