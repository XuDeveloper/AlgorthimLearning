package com.xu.backtracking;

public class Sudoku_Solver_37 {

    // 行（存储[行下标][所填的值]）
    private int[][] map1;
    // 列
    private int[][] map2;
    // 小网格
    private int[][] map3;

    public void solveSudoku(char[][] board) {
        map1 = new int[9][9];
        map2 = new int[9][9];
        map3 = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    map1[i][num] = 1;
                    map2[j][num] = 1;
                    map3[3 * (i / 3) + j / 3][num] = 1;
                }
            }
        }
        solve(board, 0);
    }

    private boolean solve(char[][] board, int count) {
        if (count >= 81) {
            return true;
        }
        for (int i = count; i < 81; i++) {
            int ii = i / 9;
            int jj = i % 9;
            if (board[ii][jj] != '.') {
                continue;
            } else {
                for (int k = 0; k < 9; k++) {
                    if (map1[ii][k] == 1 || map2[jj][k] == 1 || map3[3 * (ii / 3) + jj / 3][k] == 1) {
                        continue;
                    } else {
                        board[ii][jj] = (char) (k + 49);
                        map1[ii][k] = 1;
                        map2[jj][k] = 1;
                        map3[3 * (ii / 3) + jj / 3][k] = 1;
                        if (solve(board, ii * 9 + jj + 1)) {
                            return true;
                        }
                        map1[ii][k] = 0;
                        map2[jj][k] = 0;
                        map3[3 * (ii / 3) + jj / 3][k] = 0;
                        board[ii][jj] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

}
