package com.xu.lintcode.dp;

public class Backpack_II_125 {

    public int backPackII(int m, int[] A, int[] V) {
        if (A == null || V == null || A.length == 0 || V.length == 0) {
            return 0;
        }
        int N = A.length;
        int M = m;
        int[][] bp = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (A[i] > j) {
                    bp[i + 1][j] = bp[i][j];
                } else {
                    bp[i + 1][j] = Math.max(bp[i][j], bp[i][j - A[i]] + V[i]);
                }
            }
        }
        return bp[N][M];
    }

}
