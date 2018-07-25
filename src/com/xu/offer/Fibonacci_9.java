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

}
