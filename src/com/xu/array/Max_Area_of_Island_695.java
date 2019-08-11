package com.xu.array;

// 刷过1遍（2019.08.09 ）

public class Max_Area_of_Island_695 {

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int res = 1;
        grid[i][j] = 0;
        res += dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i + 1, j) + dfs(grid, i, j + 1);
        return res;
    }
}
