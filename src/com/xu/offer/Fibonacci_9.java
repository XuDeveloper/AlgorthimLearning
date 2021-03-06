package com.xu.offer;

/**
 * 拓展：青蛙跳台阶和覆盖矩形
 */
public class Fibonacci_9 {

    public int fibonacci(int n) {
        int[] result = new int[]{0, 1};
        if (n < 2) {
            return result[n];
        }
        int f1 = 1;
        int f2 = 0;
        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = f1 + f2;
            f2 = f1;
            f1 = fn;
        }
        return fn;
    }

    private int[] memo;

    /**
     * （记忆化搜索）
     * @param n
     * @return
     */
    public int fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] != -1) {
            memo[n] = fibonacci2(n - 1) + fibonacci2(n - 2);
        }
        return memo[n];
    }
}
