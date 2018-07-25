package com.xu.offer;

public class Array_Find_3 {

    public boolean find(int[][] arr, int target) {
        int column = arr[0].length - 1;
        int row = 0;
        while (column >= 0 && row < arr.length) {
            if (arr[row][column] == target) {
                return true;
            } else if (arr[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

}
