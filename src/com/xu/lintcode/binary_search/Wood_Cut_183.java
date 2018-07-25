package com.xu.lintcode.binary_search;

public class Wood_Cut_183 {

    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }
        int lb = 0, ub = Integer.MIN_VALUE;
        for (int l: L) {
            if (ub < l) ub = l + 1;
        }
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (C(L, k, mid)) {
                lb = mid;
            } else {
                ub = mid;
            }
        }
        return lb;
    }

    public boolean C(int[] L, int k, int x) {
        int sum = 0;
        for (int l: L) {
            sum += l / x;
        }
        return sum >= k;
    }

}
