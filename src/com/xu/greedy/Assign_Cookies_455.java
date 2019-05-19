package com.xu.greedy;

import java.util.Arrays;

public class Assign_Cookies_455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int si = s.length - 1, gi = g.length - 1;
        int res = 0;
        while (si >= 0 && gi >= 0) {
            if (s[si] >= g[gi]) {
                res++;
                si--;
                gi--;
            } else {
                gi--;
            }
        }
        return res;
    }

}
