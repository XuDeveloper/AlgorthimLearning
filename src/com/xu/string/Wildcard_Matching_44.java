package com.xu.string;

/**
 * http://www.cnblogs.com/yuzhangcmu/p/4116153.html
 */
public class Wildcard_Matching_44 {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;

        boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
        res[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)=='*')
                res[0][i+1]=res[0][i];
        }

        for(int i=0;i<s.length();i++){
            for(int j=0;j<p.length();j++){
                if(p.charAt(j)=='?'||p.charAt(j)==s.charAt(i))
                    res[i+1][j+1]=res[i][j];
                if(p.charAt(j)=='*'){
                    res[i+1][j+1]=res[i+1][j]||res[i][j+1];
                }
            }
        }

        return res[s.length()][p.length()];
    }

}
