package com.xu.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Pacific_Atlantic_Water_Flow_417 {

    private int m, n;
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList();
        if (matrix.length == 0 || matrix[0].length == 0) return result;

        m = matrix.length;
        n = matrix[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        // dfs, for each position
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, pacific);
            dfs(matrix, i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            dfs(matrix, 0, j, pacific);
            dfs(matrix, m - 1, j, atlantic);
        }
        // find the intersection
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) result.add(new int[]{i, j});
            }
        }
        return result;

    }

    private void dfs(int[][] matrix, int x, int y, boolean[][] visited) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if (inArea(newx, newy) && matrix[x][y] <= matrix[newx][newy]) {
                dfs(matrix, newx, newy, visited);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
