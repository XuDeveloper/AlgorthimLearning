package com.xu.array;

public class Rotate_Image_48 {

    public void rotate(int[][] matrix) {
        int row, col;
        int length = matrix.length;
        int edge = length - 1;
        int nEdge;

        for (row = 0; row < edge; row++) {
            nEdge = edge;
            for (col = row; col < edge; col++, nEdge--) {
                int val = matrix[row][col];
                matrix[row][col] = matrix[nEdge][row];
                matrix[nEdge][row] = matrix[edge][nEdge];
                matrix[edge][nEdge] = matrix[col][edge];
                matrix[col][edge] = val;
            }
            edge--;
        }
    }
}
