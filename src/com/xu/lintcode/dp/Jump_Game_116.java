package com.xu.lintcode.dp;

public class Jump_Game_116 {

    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }
        boolean[] jumpto = new boolean[A.length];
        jumpto[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (jumpto[j] && j + A[j] >= i) {
                    jumpto[i] = true;
                    break;
                }
            }
        }
        return jumpto[A.length - 1];
    }

}
