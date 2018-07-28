package com.xu.backtracking;

/**
 * 有n件工作分配给n个人。将工作i分配给第j个人所需费用为cij。
 * 设计一个算法，对于给定的工作费用，为每一个人都分配1件不同的工作，
 * 并使总费用达到最小。
 *
 */
public class Work_Assignment {
    int[][] cost;
    int N;
    int cur;
    int best = Integer.MAX_VALUE;
    int a[];

    public int getResult(int n, int[][] cost) {
        N = n;
        this.cost = cost;
        a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = i;
        }
        backtrack(1);
        return best;
    }

    public void backtrack(int t) {
        if (t > N) {
            if (cur < best) {
                best = cur;
            }
        } else {
            for (int i = t; i <= N; i++) {
                cur += cost[t][a[i]];
                swap(i, t);
                if (cur < best) {
                    backtrack(t + 1);
                }
                swap(i, t);
                cur -= cost[t][a[i]];
            }
        }
    }

    public void swap(int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
