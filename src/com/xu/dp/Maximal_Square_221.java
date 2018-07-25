package com.xu.dp;

public class Maximal_Square_221 {

    public int maximalSquare(char[][] matrix) {
        int side = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return side;
        }

        final int ROW = matrix.length, COL = matrix[0].length;
        int[][] dp = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                side = 1;
            }
        }
        for (int i = 0; i < COL; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                side = 1;
            }
        }

        for (int i = 1; i < ROW; i++) {
            side = Math.max(side, matrix[i][0] - '0');
            for (int j = 1; j < COL; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + minTri(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]);
                    side = Math.max(side, dp[i][j]);
                }
            }
        }

        return side * side;
    }

    private int minTri(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
