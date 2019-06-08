package com.xu.array;

public class Fibonacci_Number_509 {

    public int fib(int N) {
        int f0 = 0;
        int f1 = 1;
        int fn = 1;
        if (N == 0) {
            return f0;
        }
        if (N == 1) {
            return f1;
        }
        for (int i = 2; i <= N; i++) {
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

}
