package com.xu.array;

public class Island_Perimeter_463 {

    public int islandPerimeter(int[][] grid) {
        int num = 0;
        int neighbor = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    num++;
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        neighbor++;
                    }
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        neighbor++;
                    }
                }
            }
        }
        return num * 4 - neighbor * 2;
    }

}
