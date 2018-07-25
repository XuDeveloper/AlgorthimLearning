package com.xu.offer;

public class String_Path_in_Matrix_66 {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows <= 0 || cols <= 0 || str == null) {
            return false;
        }
        if (str.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (findPath(matrix, i, j, rows, cols, 0, visited, str)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean findPath(char[] matrix, int row, int col,
                             int rows, int cols, int k,
                             boolean[] visited, char[] str) {
        if (row < 0 || row >= rows || col < 0 || col >= cols ||
                str[k] != matrix[row * cols + col] || visited[row * cols + col]) {
            return false;
        }
        if (k == str.length - 1) {
            return true;
        }
        visited[row * cols + col] = true;
        if (findPath(matrix, row + 1, col, rows, cols, k + 1, visited, str) ||
                findPath(matrix, row, col + 1, rows, cols, k + 1, visited, str) ||
                findPath(matrix, row - 1, col, rows, cols, k + 1, visited, str) ||
                findPath(matrix, row, col - 1, rows, cols, k + 1, visited, str)) {
            return true;
        }
        visited[row * cols + col] = false;
        return false;
    }

}
