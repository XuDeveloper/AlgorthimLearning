package com.xu.lintcode.dp;

public class Backpack_92 {

    public int backPack(int m, int[] A) {
        if (A == null || A.length == 0) return 0;

        int M = m;
        int N = A.length;
        int[][] bp = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (A[i] > j) {
                    bp[i + 1][j] = bp[i][j];
                } else {
                    bp[i + 1][j] = Math.max(bp[i][j], bp[i][j - A[i]] + A[i]);
                }
            }
        }

        return bp[N][M];
    }

}
