package com.xu.backtracking;

// 刷过1遍（2019.09.22 ）

/**
 * https://blog.csdn.net/gulaixiangjuejue/article/details/86562632
 */
public class Unique_Paths_III_980 {

    private int m;
    private int n;
    private int res;
    private int sx, sy, ex, ey;

    // dfs暴力搜索（题干说最多是20，复杂度能通过）
    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // 空位置计数，加上入口点
        int empty = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                } else if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    ex = i;
                    ey = j;
                }
            }
        }
        dfs(grid, sx, sy, empty);
        return res;
    }

    public void dfs(int[][] grid, int x, int y, int empty) {
        if (!check(x, y, grid)) {
            return;
        }
        if (x == ex && y == ey && empty == 0) {
            res++;
            return;
        }
        grid[x][y] = -2;
        empty--;
        dfs(grid, x - 1, y, empty);
        dfs(grid, x, y + 1, empty);
        dfs(grid, x + 1, y, empty);
        dfs(grid, x, y - 1, empty);
        empty++;
        grid[x][y] = 0;
    }

    public boolean check(int x, int y, int[][] grid) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] >= 0;
    }

}
