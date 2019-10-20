package com.xu.backtracking;

// 刷过1遍（2019.10.20 ）

public class Beautiful_Arrangement_526 {

    private int res;
    private boolean[] visited;

    public int countArrangement(int N) {
        visited = new boolean[N + 1];
        generateArrangement(N, 1, visited);
        return res;
    }

    public void generateArrangement(int N, int cur, boolean[] visited) {
        if (cur > N) {
            res++;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (cur % i == 0 || i % cur == 0)) {
                visited[i] = true;
                generateArrangement(N, cur + 1, visited);
                visited[i] = false;
            }
        }
    }

}
