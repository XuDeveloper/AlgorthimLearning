package com.xu.binary_search;

public class Sqrtx_69 {

    public int mySqrt(int x) {
        if (x < 0) return -1;
        if (x == 0) return 0;

        int lb = 1, ub = x;
        long mid = 0;
        while (lb + 1 < ub) {
            mid = lb + (ub - lb) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                lb = (int) mid;
            } else {
                ub = (int) mid;
            }
        }

        return (int) lb;
    }

}
