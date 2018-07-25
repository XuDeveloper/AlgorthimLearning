package com.xu.math_and_bit_manipulation;

public class Reverse_Integer_7 {

    public int reverse(int n) {
        long reverse_n = 0;
        while (n != 0) {
            reverse_n = 10 * reverse_n + n % 10;
            n /= 10;
        }
        if (reverse_n < Integer.MIN_VALUE || reverse_n > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) reverse_n;
    }

}
