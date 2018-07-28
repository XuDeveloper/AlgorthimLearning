package com.xu.backtracking;

/**
 * n * n的国际象棋上摆放n个皇后，使其不能互相攻击
 * 即任意两个皇后都不能处于同一行、同一列或同一斜线，问有多少种摆法
 *
 * Input
 * 输入n值（n <= 13）
 *
 * Output
 * 输出共有多少种摆法
 *
 * Sample Input
 * 10
 *
 * Sample OutPut
 */
public class Queen_N {

    int[] x;
    int sum;
    int N;

    public int getResult(int n) {
        N = n;
        x = new int[n + 1];
        backtrack(1);
        return sum;
    }

    public void backtrack(int t) {
        if (t > N) {
            sum++;
        } else {
            for (int j = 1; j <= N; j++) {
                x[t] = j;
                if (place(t)) {
                    backtrack(t + 1);
                }
            }
        }
    }

    public boolean place(int t) {
        for (int i = 1; i < t; i++) {
            if (x[i] == x[t] || Math.abs(x[i] - x[t]) == Math.abs(i - t)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Queen_N queen_n = new Queen_N();
        System.out.println(queen_n.getResult(10));
    }

}
