package com.xu.lintcode.dp;

public class Climbing_Stairs_111 {

    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        }
        int ret0 = 1, ret1 = 1, ret2 = 1;
        for (int i = 2; i < n + 1; i++) {
            ret0 = ret1 + ret2;
            ret2 = ret1;
            ret1 = ret0;
        }
        return ret0;
    }

}
