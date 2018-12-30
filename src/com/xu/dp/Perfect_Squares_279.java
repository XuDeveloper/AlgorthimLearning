package com.xu.dp;

import javafx.util.Pair;

import java.util.LinkedList;

public class Perfect_Squares_279 {

    public int numSquares(int n) {
        // 动态规划
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    public int numSquares1(int n) {
        // 转化为图的方式进行思考
        // 该方法会导致 Time Limit Exceeded 或者 Memory Limit Exceeded
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> first = queue.removeFirst();
            int num = first.getKey();
            int step = first.getValue();
            if (num == 0) {
                return step;
            }
            for (int i = 1; num - i * i >= 0; i++) {
                queue.addLast(new Pair<>(num - i * i, step + 1));
            }
        }
        return -1;
    }

    public int numSquares2(int n) {
        // 使用visited数组 时间空间都为O(N)
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> first = queue.removeFirst();
            int num = first.getKey();
            int step = first.getValue();
            if (num == 0) {
                return step;
            }
            for (int i = 1; num - i * i >= 0; i++) {
                if (!visited[num - i * i]) {
                    queue.addLast(new Pair<>(num - i * i, step + 1));
                    visited[num - i * i] = true;
                }
            }
        }
        return -1;
    }

    public int numSquares3(int n) {
        // 进一步优化
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));
        boolean[] visited = new boolean[n + 1];
        visited[n] = true;
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> first = queue.removeFirst();
            int num = first.getKey();
            int step = first.getValue();
            if (num == 0) {
                return step;
            }
            for (int i = 1; num - i * i >= 0; i++) {
                int a = num - i * i;
                if (!visited[a]) {
                    if (a == 0) {
                        return step + 1;
                    }
                    queue.addLast(new Pair<>(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        return -1;
    }

}
