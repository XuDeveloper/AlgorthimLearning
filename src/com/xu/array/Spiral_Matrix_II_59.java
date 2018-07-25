package com.xu.array;

public class Spiral_Matrix_II_59 {

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int topOffset = 0;
        int rightOffset = 0;
        int bottomOffset = 0;
        int leftOffset = 0;
        int index = 1;
        int i = 0;
        while (topOffset + bottomOffset < n) {
            for (i = leftOffset; i < n - rightOffset; i++) {
                result[topOffset][i] = index++;
            }
            topOffset++;
            for (i = topOffset; i < n - bottomOffset; i++) {
                result[i][n - 1 - rightOffset] = index++;
            }
            rightOffset++;
            for (i = n - 1 - rightOffset; i >= leftOffset; i--) {
                result[n - 1 - bottomOffset][i] = index++;
            }
            bottomOffset++;
            for (i = n - 1 - bottomOffset; i >= topOffset; i--) {
                result[i][leftOffset] = index++;
            }
            leftOffset++;
        }
        return result;
    }

}
